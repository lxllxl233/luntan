package com.woqiyounai.luntan.response;

public class CommonResponse<T> {
    private Integer code;
    private String msg;
    private T data;

    public CommonResponse() {
    }

    public CommonResponse(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "CommonResponse{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

    public static void main(String[] args) {
        System.out.println(23&45);
        System.out.println(23|45);
        System.out.println(23^45);
    }
}
