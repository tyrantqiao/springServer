package com.qiao.graber.enums;

public enum ResultEnum {
    UNOKOWN_ERROR(-1, "UNOKWN_ERROR"),
    SUCCESS(200, "SUCCESS GRABING");

    private int code;
    private String msg;

    ResultEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
