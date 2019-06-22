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
     * @param *        @param username
     * @param password
     * @return club.xuanshangling.pojo.User
     * @author yanfan
     * @date 2019/6/17
     * @description 用户登录，根据用户名和密码查询用户
     */
    User queryUserForLogin(String username, String password) throws Exception;

    /**
     * @param * @param userId
     * @return club.xuanshangling.pojo.User
     * @author yanfan
     * @date 2019/6/22
     * @description
     */
    User queryUserById(String userId);

    /**
     * @param * @param
     * @return void
     * @author yanfan
     * @date 2019/6/22
     * @description 更新用户
     */
    void update(User user);
}
