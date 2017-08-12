package com.qiao.graber.exception;

/**
 * @author qiao
 * email tyrantqiao@icloud.com
 * 12:07
 */

public class BaikeException extends RuntimeException{
    private int code;
    private String message;

    public BaikeException(String message, int code) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public String getError() {
        return message;
    }
}
