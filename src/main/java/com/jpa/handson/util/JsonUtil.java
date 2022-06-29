package com.jpa.handson.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JsonUtil {

    private static ObjectMapper mObjectMapper;

    private static ObjectMapper getObjectMapper() {
        if (mObjectMapper == null) {
            mObjectMapper = new ObjectMapper();
            mObjectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        }
        return mObjectMapper;
    }

    public static String toJson(Object object) {
        ObjectMapper objectMapper = getObjectMapper();
        String requestObj = null;
        try {
            requestObj = objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            log.error("Error while deserializing Object to json", e);
        }
        return requestObj;
    }

}
