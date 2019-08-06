package club.xuanshangling.controller;

import club.xuanshangling.service.ThemeService;
import club.xuanshangling.utils.JsonResult;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "主题商品", tags = "主题商品")
@RequestMapping("/theme")
public class ThemeController {
    @Autowired
    ThemeService themeService;

    @GetMapping("/{theme_id}")
    public JsonResult themeGoodsSearch(@PathVariable Long theme_id) {
        String themeGoods = themeService.themeGoodsSearch(theme_id);
        return JsonResult.ok(themeGoods);
    }
}
