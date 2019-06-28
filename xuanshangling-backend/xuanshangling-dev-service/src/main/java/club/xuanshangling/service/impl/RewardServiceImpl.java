package club.xuanshangling.service.impl;

import club.xuanshangling.enums.RewardStatusEnum;
import club.xuanshangling.mapper.RewardMapper;
import club.xuanshangling.mapper.RewardVOMapper;
import club.xuanshangling.pojo.Reward;
import club.xuanshangling.pojo.vo.RewardVO;
import club.xuanshangling.pojo.vo.UserVO;
import club.xuanshangling.service.RewardService;
import club.xuanshangling.service.UserHelper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Author: wangcf
 * @Date: 2019/6/23 11:58
 * @Description 悬赏令相关业务实现
 */
@Service
public class RewardServiceImpl implements RewardService {

    @Autowired
    private RewardMapper rewardMapper;

    @Autowired
    private RewardVOMapper rewardVOMapper;

    @Autowired
    private Sid sid;

    @Autowired
    private UserHelper userHelper;


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

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public PageInfo<RewardVO> page(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<RewardVO> rewardVOList = rewardVOMapper.queryPage();

        PageInfo<RewardVO> rewardVOPageInfo = new PageInfo<>(rewardVOList);

        Map<String, UserVO> userCache = userHelper.getUserCache();

        rewardVOPageInfo.getList().stream().forEach(e -> {
                    e.setUserVO(userCache.get(e.getUserId()));
                    if (e.getRewardContent().length() > 100)
                        e.setRewardContent(e.getRewardContent().substring(0, 100) + "...");
                }
        );

        return rewardVOPageInfo;
    }

    @Override
    public RewardVO get(String id) {

        RewardVO rewardVO = rewardVOMapper.getRewardDetial(id);
        Map<String, UserVO> userCache = userHelper.getUserCache();
        rewardVO.setUserVO(userCache.get(rewardVO.getUserId()));
        return rewardVO;
    }

}
