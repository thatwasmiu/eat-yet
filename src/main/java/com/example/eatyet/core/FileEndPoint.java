package com.example.eatyet.core;

import com.example.eatyet.config.SpringContext;
import com.example.eatyet.core.utils.Common;
import com.example.eatyet.core.utils.DateUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class FileEndPoint {
    private AttachmentService getAttachmentService() {
        return SpringContext.getBean(AttachmentService.class);
    }

    public static final Integer BYTE = 1024;
    @RequestMapping(path = "/upload", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Map<String, String> uploadFileHandler(
            @RequestParam("file") MultipartFile file,
            @RequestParam(value = "id", required = false) Long id,
            @RequestParam(value = "type", required = false) Integer type) {
        Map<String, String> result = new HashMap<>();

        String fileName = file.getOriginalFilename();
        validateFileName(fileName);
        int pos = fileName.lastIndexOf(".");
        String extension = fileName.substring(pos+1);
        String timeStamp = DateUtils.getCurrentDateTime();
        String baseDir = System.getProperty("user.dir");
        String resource = "/attachment/";

        try {

            Common.createDirectory(baseDir + resource);
            // upload excel ra folder riêng
            resource += "images/";

            Common.createDirectory(baseDir + resource);

            fileName =   timeStamp + "." + extension;
            File convFile = new File(baseDir + resource + fileName);

            while(convFile.exists()) {
                timeStamp = DateUtils.getCurrentDateTime();
                fileName =  timeStamp + "." + extension;
                convFile = new File(baseDir + resource + fileName);
                break;
            }

            file.transferTo(convFile);
            // resize image đối với file lớn hơn 500kb
            boolean checkResize = (float) convFile.length() / (BYTE * BYTE) >= 0.5;
            if( checkResize && ("jpeg".equals(extension) || "jpg".equals(extension) || "png".equals(extension))){
                // là ảnh thì resize
                fileName = getAttachmentService().renameAndSizeImage(baseDir + resource, fileName);
                // xooá ảnh cũ
                convFile.delete();
            }

        } catch (IOException e){
            e.printStackTrace();
        }

        result.put("fileName", resource + fileName);
//        if(id !=null){
//            Attachment attachment = new Attachment();
//            attachment.setUrl(fileName);
//            attachment.setName(file.getOriginalFilename());
//            attachment.setParentId(id);
//            attachment.setType(type);
//            attachment.setModel("xxx");
//            getAttachmentService().upSert(attachment);
//        }
        return result;
    }

    public void validateFileName(String fileName){
        if(fileName.contains("../") || fileName.contains("..\\")){
            throw new RuntimeException("InvalidPath");
        }

        if(fileName.matches("%2e%2e%2f|%2e%2e/|..%2f|%2e%2e%5c|%2e%2e\\|..%5c|%252e%252e%255c|..%255c|..%255c|..%c1%9c|%00")){
            throw new RuntimeException("InvalidPath");
        }

        int pos = fileName.lastIndexOf('.');
        String extension = fileName.substring(pos+1);
        if(!extension.toLowerCase().matches("zip|rar|jpg|jpeg|png|bmp|xlsx|doc|xls|pdf|docx|txt")) {
            throw new RuntimeException("InvalidPath");
        }
    }


}
