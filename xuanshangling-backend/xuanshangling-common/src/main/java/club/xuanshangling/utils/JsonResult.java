package club.xuanshangling.utils;

/**
 * @Author: wangcf
 * @Date: 2019/6/15 19:52
 * @Description:自定义所有controller的Json返回类型
 * code 说明：
     * 200 成功
     * 1000 自定义错误信息
     * 1001 异常
     * 1002
     * 1003
     * 1004
 */
public class JsonResult {
    private Integer code;
    private String msg;
    private Object data;

    public JsonResult(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public JsonResult(Object data) {
        this.code = 200;
        this.msg = "ok";
        this.data = data;
    }

    public JsonResult() {

    }

    public static JsonResult ok(Object data) {
        return new JsonResult(data);
    }

    public static JsonResult ok() {
        return new JsonResult(null);
    }

    public static JsonResult errorMsg(String msg) {
        return new JsonResult(1001, msg, null);
    }
}
