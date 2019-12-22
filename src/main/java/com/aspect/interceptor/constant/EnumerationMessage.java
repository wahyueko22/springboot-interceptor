package com.aspect.interceptor.constant;

import java.util.HashMap;
import java.util.Map;


public enum EnumerationMessage {
    //SUCCESS Message
    SUCCESS_GET_SAP_TOKEN(200001, "OK", "SUCCEED_TO_GET_SAP_TOKEN"),
    SUCCESS_RESPONSE(200000, "OK", "SUCCEED"),
    //Validation
    ERROR_VALIDATION_INPUT(422001, "ERROR", "INVALID_DATA_INPUT"),

    //ERROR Message
    ERROR(500000, "ERROR", "ERROR OCCURED"),
    ERROR_GET_SAP_TOKEN(500001, "ERROR", "FAILED_TO_GET_SAP_TOKEN"),

    ERROR_INVALID_DATE(500002, "ERROR", "Date Format Exception"),
    ERROR_INVALID_TOKEN(500003, "ERROR", "Invalid Token"),
    ;

    //field
    private int code;
    private String type;
    private String message;
    private static Map<Integer, EnumerationMessage> codeToMessageMapping;

    EnumerationMessage(int code, String type, String message) {
        this.code = code;
        this.type = type;
        this.message = message;
    }

    public static EnumerationMessage getRespondCode(int i) {
        if (codeToMessageMapping == null) {
            initMapping();
        }
        return codeToMessageMapping.get(i);
    }

    private static void initMapping() {
        codeToMessageMapping = new HashMap<Integer, EnumerationMessage>();
        for (EnumerationMessage rc : values()) {
            codeToMessageMapping.put(rc.code, rc);
        }
    }

    public int getCode() {
        return code;
    }

    public String getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }
}
