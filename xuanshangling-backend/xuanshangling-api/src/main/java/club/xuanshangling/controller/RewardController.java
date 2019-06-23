package club.xuanshangling.controller;

import club.xuanshangling.pojo.Reward;
import club.xuanshangling.service.RewardService;
import club.xuanshangling.utils.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public JsonResult add(@RequestBody Reward reward) {
        rewardService.insert(reward);
        return JsonResult.ok();
    }
}
