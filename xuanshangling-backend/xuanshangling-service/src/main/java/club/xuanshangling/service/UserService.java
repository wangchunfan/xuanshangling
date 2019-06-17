package club.xuanshangling.service;

import club.xuanshangling.pojo.User;

/**
 * @Author: wangcf
 * @Date: 2019/6/15 22:28
 */
public interface UserService {

    /**
     * @param * @param username
     * @return boolean
     * @author yanfan
     * @date 2019/6/15
     * @description 查询用户名是否存在
     */
    boolean queryUsernameIsExists(String username);

    /**
     * @param * @param user
     * @return void
     * @author yanfan
     * @date 2019/6/17
     * @description 用户注册/保存
     */
    void saveUser(User user) throws Exception;

    /**
     * @author yanfan
     * @date 2019/6/17
     * @param  * @param username
     * @param password
     * @return boolean
     * @description 用户登录，判断用户名账号密码是否存在
     */
    User queryUserForLogin(String username, String password) throws Exception;
}
