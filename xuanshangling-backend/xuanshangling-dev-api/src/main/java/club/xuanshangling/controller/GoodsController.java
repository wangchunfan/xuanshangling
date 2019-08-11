package club.xuanshangling.controller;

import club.xuanshangling.service.GoodsService;
import club.xuanshangling.utils.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/goods")
@Api(value = "商品接口", tags = "商品接口")
public class GoodsController extends BasicController {

    @Autowired
    GoodsService goodsService;

    @GetMapping("/{id}")
    @ApiOperation(value = "获取商品", notes = "商品详情")
    public JsonResult goodsDetail(@PathVariable Long id) {
        Map map = goodsService.goodsDetail(id);
        return JsonResult.ok(map);
    }

    @GetMapping("search")
    @ApiOperation(value = "商品关键字搜索", notes = "通过关键字搜素")
    public JsonResult goodsSearch(@RequestParam String keyword,
                                  @RequestParam(defaultValue = "1") Integer page) {
        String goods = goodsService.goodsSearch(keyword, page, DEFAULT_PAGE_SIZE);
        return JsonResult.ok(goods);
    }

    @GetMapping("/opt/{opt_id}")
    public JsonResult goodsOptGet(@PathVariable Integer opt_id) {
        String cats = goodsService.goodsOptGet(opt_id);
        return JsonResult.ok(cats);
    }
}
