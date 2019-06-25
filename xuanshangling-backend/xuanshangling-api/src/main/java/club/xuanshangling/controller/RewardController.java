package club.xuanshangling.controller;

import club.xuanshangling.pojo.Reward;
import club.xuanshangling.pojo.vo.RewardVO;
import club.xuanshangling.service.RewardService;
import club.xuanshangling.utils.JsonResult;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: wangcf
 * @Date: 2019/6/23 12:04
 * @Description ${description}
 */
@RestController
@Api(value = "悬赏令", tags = "悬赏令")
@RequestMapping("/reward")
public class RewardController extends BasicController {

    @Autowired
    RewardService rewardService;

    @PostMapping("/publish")
    @ApiOperation("发布悬赏")
    public JsonResult publish(@RequestBody Reward reward) {
        rewardService.insert(reward);
        return JsonResult.ok();
    }

    @GetMapping("/page")
    @ApiOperation("分页查询")
    public JsonResult page(
            @ApiParam(value = "当前页", example = "1")
            @RequestParam
                    Integer pageNum,
            @ApiParam(value = "每页数量", example = "5")
            @RequestParam
                    Integer pageSize) {
        if (pageNum == null)
            pageNum = 1;
        if (pageSize == null)
            pageSize = DEFAULT_PAGE_SIZE;
        PageInfo<RewardVO> rewardVOPageInfo = rewardService.page(pageNum, pageSize);
        return JsonResult.ok(rewardVOPageInfo);
    }
}
