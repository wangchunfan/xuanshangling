package club.xuanshangling.service;

import club.xuanshangling.pojo.Reward;

/**
 * @Author: wangcf
 * @Date: 2019/6/23 11:57
 * @Description 悬赏令相关业务接口
 */
public interface RewardService {
    /**
     * 功能描述
     *
     * @param * @param reward
     * @return void
     * @author yanfan
     * @date 2019/6/23
     * @description 更新悬赏令内容
     */
    void update(Reward reward);

    /**
     * 功能描述
     *
     * @param * @param reward
     * @return void
     * @author yanfan
     * @date 2019/6/23
     * @description 发布新的悬赏令
     */
    void insert(Reward reward);
}