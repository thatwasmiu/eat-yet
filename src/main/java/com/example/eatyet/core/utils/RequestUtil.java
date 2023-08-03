package com.example.eatyet.core.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RequestUtil {

    private static final Logger logger = LoggerFactory.getLogger(RequestUtil.class);


    public static String sendRequest(String rUrl, String method, String body, String contentType,String token, Map<String, String> additionalHeader) throws IOException {
        StringBuilder result = new StringBuilder();
        URL url = new URL(rUrl);
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod(method);
        if (contentType == null) {
            contentType = "application/json";
        }

        conn.setRequestProperty("Content-Type", contentType);
        if (token != null) {
            conn.setRequestProperty("Authorization", token);
        }
        if (additionalHeader != null && !additionalHeader.isEmpty()) {
            for (String header: additionalHeader.keySet()) {
                conn.setRequestProperty(header, additionalHeader.get(header));
            }
        }

        conn.setConnectTimeout(30000);
        conn.setDoOutput(true);
        logger.info(method + " call: ", rUrl);

        try {
            OutputStream os = conn.getOutputStream();
            Throwable var8 = null;

            try {
                byte[] input = body.getBytes(StandardCharsets.UTF_8);
                os.write(input, 0, input.length);
            } catch (Throwable var18) {
                var8 = var18;
                throw var18;
            } finally {
                if (os != null) {
                    if (var8 != null) {
                        try {
                            os.close();
                        } catch (Throwable var17) {
                            var8.addSuppressed(var17);
                        }
                    } else {
                        os.close();
                    }
                }

            }
        } catch (Exception var20) {
            logger.info("{}", var20.getMessage());
            var20.printStackTrace();
        }

        if (conn.getResponseCode() != 200) {
            throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
        } else {
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            String output;
            while((output = br.readLine()) != null) {
                result.append(output);
            }

            conn.disconnect();
            return result.toString();
        }
    }

    public static void downloadFile(String fileURL,String apiKey, String saveDir) {
        try {
            URL url = new URL(fileURL);
            HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
            httpConn.setRequestMethod("GET");
            httpConn.setRequestProperty("Content-Type", "application/json");
            if (apiKey != null) {
                httpConn.setRequestProperty("Authorization", "Bearer " + apiKey);
            }

            if (httpConn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                String fileName = "";
                String disposition = httpConn.getHeaderField("Content-Disposition");
                String contentType = httpConn.getContentType();
                int contentLength = httpConn.getContentLength();
                fileName = fileURL.substring(fileURL.lastIndexOf("/")
                );

                InputStream inputStream = httpConn.getInputStream();
                String saveFilePath = saveDir + File.separator + fileName;

                FileOutputStream outputStream = new FileOutputStream(saveFilePath);

                int bytesRead = -1;
                byte[] buffer = new byte[4096];
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }

                outputStream.close();
                inputStream.close();


            } else {

                    throw new RuntimeException("Failed : HTTP error code : "
                            + httpConn.getResponseCode());

            }
            httpConn.disconnect();



        } catch (Exception e) {
            e.printStackTrace();
        }
    }




}
