package club.xuanshangling.controller;

import club.xuanshangling.service.HomeService;
import club.xuanshangling.utils.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/home")
@Api(value = "首页接口", tags = "首页接口")
public class HomeController extends BasicController {

    @Autowired
    HomeService homeService;

    @GetMapping("/onLoad")
    @ApiOperation(value = "首页数据加载", notes = "首页数据加载")
    public JsonResult load() {
        Map<String, String> map = homeService.onLoad();
        return JsonResult.ok(map);
    }

    @GetMapping("/page")
    @ApiOperation(value = "首页上拉分页查询", notes = "首页上拉分页查询")
    public JsonResult page(@RequestParam(required = false) Integer page,
                           @RequestParam(required = false) Integer page_size) {
        if (page == null) page = 1;
        if (page_size == null) page_size = 10;
        return JsonResult.ok(homeService.page(page, page_size));
    }
}
