package club.xuanshangling;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * 基础SpringBootServletInitializer,相当于使用web.xml的形式去启动部署
 */
public class WarStartApplication extends SpringBootServletInitializer {

    /**
     * 重写配置
     *
     * @param builder
     * @return
     */
    public SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        //使用web.xml运行应用程序，事项application，最后启动springboot
        return builder.sources(ApiApplication.class);
    }
}
