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
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

import java.util.Date;

/**
 * @Author: wangcf
 * @Date: 2019/6/15 22:28
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private Sid sid;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public boolean queryUsernameIsExists(String username) {
        User user = new User();
        user.setUsername(username);
        User result = userMapper.selectOne(user);
        return result == null ? false : true;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void saveUser(User user) throws Exception {
        user.setId(sid.nextShort());
        user.setNickname(user.getUsername());
        user.setPassword(MD5Utils.getMD5Str(user.getPassword()));
        user.setCreditScore(0);
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        userMapper.insert(user);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public User queryUserForLogin(String username, String password) throws Exception {
        Example example = new Example(User.class);
        Criteria criteria = example.createCriteria();
        criteria.andEqualTo("username", username);
        criteria.andEqualTo("password", MD5Utils.getMD5Str(password));
        User user = userMapper.selectOneByExample(example);
        return user;
    }


    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public User queryUserById(String userId) {
        User user = new User();
        user.setId(userId);
        return userMapper.selectOne(user);
    }

    @Override
    public void update(User user) {
        userMapper.updateByPrimaryKeySelective(user);
    }
}
