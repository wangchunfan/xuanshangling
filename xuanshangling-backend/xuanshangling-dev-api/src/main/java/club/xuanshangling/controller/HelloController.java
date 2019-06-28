package club.xuanshangling.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: wangcf
 * @Date: 2019/6/16 11:20
 * @Description ${description}
 */
@RestController
@Api(value = "hello接口", tags = "测试controller")
public class HelloController {

    @GetMapping("/hello")
    @ApiOperation(value = "hello", notes = "测试")
    public String hello() {
        return "hello";
    }
}
