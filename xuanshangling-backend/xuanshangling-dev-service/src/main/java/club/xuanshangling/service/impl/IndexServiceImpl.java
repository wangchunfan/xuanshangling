package club.xuanshangling.service.impl;

import club.xuanshangling.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pdd.PddClient;

import java.util.HashMap;
import java.util.Map;

@Service
public class IndexServiceImpl extends BasicService implements IndexService {

    @Autowired
    PddClient pddClient;

    /**
     * 进入首页渲染的内容
     *
     * @return
     */
    @Override
    public Map<String, String> onLoad() {
        HashMap<String, String> map = new HashMap<>();
        String goods_search_response = pddClient.goodsSearch(1, 10, true, p_id, 0L);
        String theme_list_get_response = pddClient.themeListGet(5, 1);
        String goods_opt_get_response = pddClient.goodsOptGet(0);
        map.put("goods_search_response", goods_search_response);
        map.put("theme_list_get_response", theme_list_get_response);
        map.put("goods_opt_get_response", goods_opt_get_response);
        return map;
    }

    /**
     * 首页上拉分页内容
     *
     * @param page
     * @param page_size
     * @return
     */
    @Override
    public String page(Integer page, Integer page_size, Long opt_id) {
        return pddClient.goodsSearch(page, page_size, true, p_id, opt_id);
    }
}
