package club.xuanshangling.service.impl;

import club.xuanshangling.enums.RewardStatusEnum;
import club.xuanshangling.mapper.RewardMapper;
import club.xuanshangling.pojo.Reward;
import club.xuanshangling.service.RewardService;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @Author: wangcf
 * @Date: 2019/6/23 11:58
 * @Description 悬赏令相关业务实现
 */
@Service
public class RewardServiceImpl implements RewardService {

    @Autowired
    RewardMapper rewardMapper;

    @Autowired
    Sid sid;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void update(Reward reward) {
        rewardMapper.updateByPrimaryKeySelective(reward);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void insert(Reward reward) {
        reward.setId(sid.nextShort());
        reward.setStatus(RewardStatusEnum.SUCCESS.value);
        reward.setCreateTime(new Date());
        reward.setUpdateTime(new Date());
        rewardMapper.insert(reward);
    }
}
