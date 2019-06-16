package club.xuanshangling.controller;

import club.xuanshangling.pojo.User;
import club.xuanshangling.service.UserService;
import club.xuanshangling.utils.JsonResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.NoSuchAlgorithmException;

/**
 * @Author: wangcf
 * @Date: 2019/6/15 20:15
 */

@RestController
public class RegisterLoginController {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public JsonResult register(@RequestBody User user) throws NoSuchAlgorithmException {
        //判断账号密码不为空
        if (StringUtils.isBlank(user.getUsername()) || StringUtils.isBlank(user.getPassword()))
            return JsonResult.errorMsg("用户名或密码不能为空！");
        //判断账号是否已经存在
        Boolean usernameExistsFlag = userService.queryUsernameIsExists(user.getUsername());
        if (usernameExistsFlag)
            return JsonResult.errorMsg("用户名已存在！");
        //保存用户
        userService.saveUser(user);
        return JsonResult.ok();
    }
}
