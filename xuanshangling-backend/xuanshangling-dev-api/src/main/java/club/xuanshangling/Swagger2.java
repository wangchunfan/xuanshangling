package club.xuanshangling;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author: wangcf
 * @Date: 2019/6/16 14:31
 * @Description ${description}
 */

@Configuration
@EnableSwagger2
public class Swagger2 {
    /**
     * @param * @param
     * @return springfox.documentation.spring.web.plugins.Docket
     * @author yanfan
     * @date 2019/6/16
     * @description
     */
    @Bean
    public Docket createRestApi() {
        ParameterBuilder userTokenHeader = new ParameterBuilder();
        ParameterBuilder userIdHeader = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<Parameter>();
        userTokenHeader
                .name("headerUserToken")
                .description("userToken")
                .modelRef(new ModelRef("string"))
                .parameterType("header")
                .required(false).build();
        userIdHeader.name("headerUserId")
                .description("userId")
                .modelRef(new ModelRef("string"))
                .parameterType("header")
                .required(false).build();
        pars.add(userTokenHeader.build());
        pars.add(userIdHeader.build());

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                 .select()
                .apis(RequestHandlerSelectors.basePackage("club.xuanshangling.controller"))
                .paths(PathSelectors.any())
                .build()
                .globalOperationParameters(pars);
    }

    
    /**
     * @author yanfan
     * @date 2019/6/16
     * @param  * @param  
     * @return springfox.documentation.service.ApiInfo
     * @description 构建 API文档信息
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                // 设置页面标题
                .title("使用swagger2构建《悬赏令》后端api接口文档")
                // 设置联系人
                .contact(new Contact("言凡", "http://www.xuanshangling.club", "xuanshangling@163.com"))
                // 描述
                .description("欢迎访问《悬赏令》接口文档，这里是描述信息")
                // 定义版本号
                .version("1.0").build();
    }
}
