package entity;


import java.io.Serializable;

//返回结果封装
public class Result implements Serializable {
    private boolean success;
    private String Message;

    public Result(boolean success, String message) {
        super();
        this.success = success;
        Message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    @Override
    public String toString() {
        return "Result{" +
                "success=" + success +
                ", Message='" + Message + '\'' +
                '}';
    }
}
