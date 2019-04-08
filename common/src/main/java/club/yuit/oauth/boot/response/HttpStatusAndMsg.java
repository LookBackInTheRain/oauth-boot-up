package club.yuit.oauth.boot.response;

import java.util.HashMap;
import java.util.Map;


/**
 * @author yuit
 * @date  2018/3/30 20:37
 *
 */
public class HttpStatusAndMsg {

    // final 修饰不可继承
    public final static Map<Integer, String> exs = new HashMap<>();

    static {

        exs.put(200, "Request Success");
        // 参数问题
        exs.put(400, "Bad Request");
        // 未认证
        exs.put(401, "NotAuthorization");
        // 找不到ULR
        exs.put(404, "Not Found");
        // 请求方法不正确
        exs.put(405, "Method Not Allowed");
        // 不支持Media Type
        exs.put(415, "Unsupported Media Type");
        //服务器内部错误
        exs.put(500, "Internal Server Error");
        //未知错误
        exs.put(1000, "UnKnow Error");
        // 未知异常
        exs.put(1001, "UnKnowException");
        // 运行时异常
        exs.put(1002, "RuntimeException");
        // 类型转换异常
        exs.put(1003, "ClassCastException");
        // 空指针异常
        exs.put(1004, "NullPointerException");
        // IO 异常
        exs.put(1005, "IOException");
        //找不到方法
        exs.put(1006, "NoSuchMethodException");
        // 数组越界
        exs.put(1007, "IndexOutOfBoundsException");
    }


}
