package club.xuanshangling.service.impl;

import club.xuanshangling.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pdd.PddClient;

import java.util.ArrayList;
import java.util.List;

@Service
public class GoodsServiceImp implements GoodsService {

    @Autowired
    PddClient pddClient;

    /**
     * 获取商品详情
     *
     * @param id
     * @return
     */
    @Override
    public String goodsDetail(Long id) {
        List<Long> goods_id_list = new ArrayList<>();
        goods_id_list.add(id);
        return pddClient.goodsDetail(goods_id_list);
    }
}
