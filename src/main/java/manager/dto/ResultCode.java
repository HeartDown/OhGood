package manager.dto;

import java.io.Serializable;

/**
 * Created by zhangheng on 2017/3/2.
 */
public class ResultCode implements Serializable{
    private int code;
    private String message;

    public ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
