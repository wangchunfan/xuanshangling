package club.xuanshangling.service.impl;

import club.xuanshangling.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pdd.PddClient;

import java.util.HashMap;
import java.util.Map;

@Service
public class IndexServiceImp implements IndexService {

    @Autowired
    PddClient pddClient;

    //带券列表推广位PID
    private static final String GOODS_SEARCH_PID = "8924949_103152019";

    /**
     * 进入首页渲染的内容
     * s
     *
     * @return
     */
    @Override
    public Map<String, String> onLoad() {
        HashMap<String, String> map = new HashMap<>();
        String goods_search_response = pddClient.goodsSearch(1, 10, true, GOODS_SEARCH_PID);
        String theme_list_get_response = pddClient.themeListGet(3, 1);
        map.put("goods_search_response", goods_search_response);
        map.put("theme_list_get_response", theme_list_get_response);
        return map;
    }

    @Override
    public String page(Integer page, Integer page_size) {
        return pddClient.goodsSearch(page, page_size, true, GOODS_SEARCH_PID);
    }
}
