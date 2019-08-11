package club.xuanshangling.service;

import java.util.Map;

public interface IndexService {
    /**
     * 进入首页渲染的内容
     *
     * @return
     */
    Map<String, String> onLoad();

    /**
     * 下拉分页获取数据
     *
     * @return
     */
    String page(Integer page, Integer page_size, Long opt_id);
}
