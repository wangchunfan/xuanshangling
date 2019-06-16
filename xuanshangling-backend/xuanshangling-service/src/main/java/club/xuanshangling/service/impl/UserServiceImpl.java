package club.xuanshangling.service.impl;

import club.xuanshangling.mapper.UserMapper;
import club.xuanshangling.pojo.User;
import club.xuanshangling.service.UserService;
import club.xuanshangling.utils.MD5Utils;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.security.NoSuchAlgorithmException;
import java.util.Date;

/**
 * @Author: wangcf
 * @Date: 2019/6/15 22:28
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    Sid sid;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public boolean queryUsernameIsExists(String username) {
        User user = new User();
        user.setUsername(username);
        User result = userMapper.selectOne(user);
        return result == null ? true : false;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void saveUser(User user) throws NoSuchAlgorithmException {
        user.setId(sid.nextShort());
        user.setNickname(user.getUsername());
        user.setPassword(MD5Utils.getMD5Str(user.getPassword()));
        user.setCreditScore(0);
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        userMapper.insert(user);
    }
}
