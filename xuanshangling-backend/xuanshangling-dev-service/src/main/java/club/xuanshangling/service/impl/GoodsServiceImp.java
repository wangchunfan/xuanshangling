package club.xuanshangling.service.impl;

import club.xuanshangling.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pdd.PddClient;

import java.util.HashMap;
import java.util.Map;

@Service
public class GoodsServiceImp extends BasicService implements GoodsService {

    @Autowired
    PddClient pddClient;

    /**
     * 获取商品详情
     *
     * @param id
     * @return
     */
    @Override
    public Map goodsDetail(Long id) {
        Map map = new HashMap();
        map.put("goods_detail_response", pddClient.goodsDetail(id));
        map.put("goods_promotion_url_generate_response", pddClient.goodsPromotionUrlGenerate(p_id, id));
        return map;
    }

    /**
     * 商品模糊搜索
     *
     * @param keyword
     * @param page
     * @param page_size
     * @return
     */
    @Override
    public String goodsSearch(String keyword, Integer page, Integer page_size) {
        return pddClient.goodsSearch(keyword, page, page_size);
    }

    /**
     * 获取商品标准类目接口
     *
     * @param parent_opt_id
     * @return
     */
    @Override
    public String goodsOptGet(Integer parent_opt_id) {
        return pddClient.goodsOptGet(parent_opt_id);
    }


}
