package club.xuanshangling.mapper;

import club.xuanshangling.pojo.vo.RewardVO;
import club.xuanshangling.utils.MyMapper;

import java.util.List;

/**
 * @Author: wangcf
 * @Date: 2019/6/25 20:57
 * @Description ${description}
 */
public interface RewardVOMapper extends MyMapper<RewardVO> {

    List<RewardVO> queryPage();
}
