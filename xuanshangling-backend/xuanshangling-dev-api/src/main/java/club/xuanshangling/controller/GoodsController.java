package club.xuanshangling.controller;

import club.xuanshangling.service.GoodsService;
import club.xuanshangling.utils.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/goods")
@Api(value = "商品接口", tags = "商品接口")
public class GoodsController {

    @Autowired
    GoodsService goodsService;

    @GetMapping("/{id}")
    @ApiOperation(value = "获取商品", notes = "商品详情")
    public JsonResult goodsDetail(@PathVariable Long id) {
        String goods = goodsService.goodsDetail(id);
        return JsonResult.ok(goods);
    }
}
