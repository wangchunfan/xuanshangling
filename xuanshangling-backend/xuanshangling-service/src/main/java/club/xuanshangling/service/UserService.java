package club.xuanshangling.service;

import club.xuanshangling.pojo.User;

import java.security.NoSuchAlgorithmException;

/**
 * @Author: wangcf
 * @Date: 2019/6/15 22:28
 */
public interface UserService {

    /**
     *功能描述
     * @author yanfan
     * @date 2019/6/15
     * @param  * @param username
     * @return boolean
     * @description 查询用户名是否存在
     */
    boolean queryUsernameIsExists(String username);

    void saveUser(User user) throws NoSuchAlgorithmException;
}
