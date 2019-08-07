package club.xuanshangling.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: wangcf
 * @Date: 2019/6/18 22:36
 * @Description ${description}
 */

@RestController
public class BasicController {

    @Autowired
    public StringRedisTemplate redis;

    public static final String USER_REDIS_SESSION = "user-redis-session";

    public static final Integer DEFAULT_PAGE_SIZE = 10;


}
