package club.xuanshangling.service;

import club.xuanshangling.pojo.Reward;
import club.xuanshangling.pojo.vo.RewardVO;
import com.github.pagehelper.PageInfo;

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

    /**
     * 功能描述
     *
     * @param pageNum
     * @param pageSize
     * @return club.xuanshangling.utils.PageResult
     * @author yanfan
     * @date 2019/6/24
     * @description 获取所有悬赏令
     */
    PageInfo<RewardVO> page(Integer pageNum, Integer pageSize);

    /**
     *功能描述 
     * @author yanfan
     * @date 2019/6/27
     * @param  * @param id 
     * @return club.xuanshangling.pojo.vo.RewardVO
     * @description 获取悬赏的详情
     */
    RewardVO get(String id);
}
