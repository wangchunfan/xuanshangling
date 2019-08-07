package club.xuanshangling.service;

import java.util.List;
import java.util.Map;

public interface GoodsService {
    Map goodsDetail(Long id);

    String goodsSearch(String keyword, Integer page, Integer page_size);
}
