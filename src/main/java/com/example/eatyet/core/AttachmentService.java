package com.example.eatyet.core;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@Service
@Transactional
public class AttachmentService extends CrudService<Attachment, Long>{
    public AttachmentRepo repository;

    public AttachmentService(AttachmentRepo repo) {
        super(repo);
        this.repository = repo;
    }


    public String renameAndSizeImage(String resource, String fileName){
        try {
            BufferedImage originalImage = ImageIO.read(new File(resource + fileName));//change path to where file is located
            int type = BufferedImage.TYPE_INT_RGB; // type để resize
            float scaleX = (float) 1366 / originalImage.getWidth();
            float scaleY = (float) 1366 / originalImage.getHeight();
            float scale = Math.min(scaleX, scaleY);
            int w = Math.round(originalImage.getWidth() * scale);
            int h = Math.round(originalImage.getHeight() * scale);

            BufferedImage resizeImageJpg = resizeImage(originalImage, type, w, h);
            fileName = "resize_" + fileName;
            ImageIO.write(resizeImageJpg, "jpg", new File(resource + fileName));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return fileName;
    }

    private static BufferedImage resizeImage(BufferedImage originalImage, int type, int IMG_WIDTH, int IMG_HEIGHT) {
        BufferedImage resizedImage = new BufferedImage(IMG_WIDTH, IMG_HEIGHT, type);
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(originalImage, 0, 0, IMG_WIDTH, IMG_HEIGHT, null);
        g.dispose();

        return resizedImage;
    }
}
