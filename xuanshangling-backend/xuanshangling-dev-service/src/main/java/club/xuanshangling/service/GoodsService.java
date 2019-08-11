package club.xuanshangling.service;

import io.swagger.models.auth.In;

import java.util.List;
import java.util.Map;

public interface GoodsService {
    Map goodsDetail(Long id);

    String goodsSearch(String keyword, Integer page, Integer page_size);

    String goodsOptGet(Integer parent_opt_id);
}
