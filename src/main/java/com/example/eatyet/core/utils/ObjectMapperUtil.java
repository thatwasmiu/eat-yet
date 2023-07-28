package com.example.eatyet.core.utils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.List;

public class ObjectMapperUtil {
    private static final Logger logger = LoggerFactory.getLogger(ObjectMapperUtil.class);

    private ObjectMapperUtil(){

    }

    public static <T> T objectMapper(String json, Class<?> type){
        try{
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            Object o =  mapper.readValue(json, type);
            return (T) o;
        }catch (Exception ex){
            ex.printStackTrace();
            logger.error(ex.toString());
            return null;
        }
    }

    public static <T> List<T> listMapper(String json, Class<?> type){
        try{
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            List<Object> o = mapper.readValue(json, mapper.getTypeFactory().constructCollectionType(List.class, type));
            return (List<T>) o;
        }catch (Exception ex){
            logger.error(ex.getMessage(), ex);
            return Collections.emptyList();
        }
    }

    public static <T> String toJsonString(T object){
        try{
            ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(object);
        }catch (Exception ex){
            logger.error(ex.getMessage(), ex);
            return "";
        }
    }
}
