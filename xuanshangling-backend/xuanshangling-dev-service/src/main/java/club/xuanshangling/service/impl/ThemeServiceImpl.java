package club.xuanshangling.service.impl;

import club.xuanshangling.service.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pdd.PddClient;

@Service
public class ThemeServiceImpl implements ThemeService {
    @Autowired
    PddClient pddClient;

    @Override
    public String themeGoodsSearch(Long theme_id) {

        return pddClient.themeGoodsSearch(theme_id);
    }
}
