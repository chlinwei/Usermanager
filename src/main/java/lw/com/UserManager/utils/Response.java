package lw.com.UserManager.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response {
    private int code;
    private String msg;
    private Object data;
    public static Response Response_200(Object data) {
        return new Response(200,"success",data);
    }
    public static Response Response_400(Object data) {
        return new Response(400,"failed",data);
    }
}
