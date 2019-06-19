package club.xuanshangling.controller;

import club.xuanshangling.pojo.User;
import club.xuanshangling.pojo.vo.UserVO;
import club.xuanshangling.service.UserService;
import club.xuanshangling.utils.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @Author: wangcf
 * @Date: 2019/6/15 20:15
 */

@RestController
@Api(value = "用户登录注册接口", tags = "登录注册controller")
public class RegisterLoginController extends BasicController {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    @ApiOperation(value = "用户注册", notes = "用户注册接口")
    public JsonResult register(@RequestBody User user) throws Exception {
        //判断账号密码不为空
        if (StringUtils.isBlank(user.getUsername()) || StringUtils.isBlank(user.getPassword()))
            return JsonResult.errorMsg("用户名或密码不能为空！");
        //判断账号是否已经存在
        Boolean usernameExistsFlag = userService.queryUsernameIsExists(user.getUsername());
        if (usernameExistsFlag)
            return JsonResult.errorMsg("用户名已存在！");
        //保存用户
        userService.saveUser(user);
        //密码脱敏
        user.setPassword(null);
        UserVO userVO = setUserRedisSessionToken(user);
        return JsonResult.ok(userVO);
    }

    @PostMapping("/login")
    @ApiOperation(value = "用户登录", notes = "用户登录接口")
    public JsonResult login(@RequestBody User user) throws Exception {
        //登录信息为空判断
        if (StringUtils.isBlank(user.getUsername()) || StringUtils.isBlank(user.getPassword()))
            return JsonResult.errorMsg("用户名或密码不能为空");
        //用户名密码是否存在判断
        user = userService.queryUserForLogin(user.getUsername(), user.getPassword());
        if (user == null) {
            return JsonResult.errorMsg("用户名或密码错误");
        }
        user.setPassword(null);
        UserVO userVO = setUserRedisSessionToken(user);
        return JsonResult.ok(userVO);
    }

    public UserVO setUserRedisSessionToken(User user) {
        //将UUID作为token
        String uniqueToken = UUID.randomUUID().toString();
        //将token存入Redis
        redis.opsForValue().set(USER_REDIS_SESSION + ":" + user.getId(), uniqueToken);
        //返回UserVO对象
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(user, userVO);
        userVO.setUserToken(uniqueToken);
        return userVO;
    }
}
