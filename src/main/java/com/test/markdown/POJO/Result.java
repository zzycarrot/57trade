package com.test.markdown.POJO;

public class Result {
    private Integer code;
    private Object data;
    private String msg;


    public Result() {

    }

    public Result(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public Object getData() {
        return data;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static Result Success() {
        return new Result(0, "success", null);
    }

    public static Result Success(Object data) {
        return new Result(0, "执行成功", data);
    }

    public static Result Error(String msg) {
        return new Result(0, msg, null);
    }
    @Override
    public String toString(){
        return "Result{"+
                "code="+code+
                ",msg='"+msg+'\''+
                ",data=" +data+
                "}";
    }
}
