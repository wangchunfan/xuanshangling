package club.xuanshangling;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @Author: wangcf
 * @Date: 2019/6/16 9:43
 * @Description ${description}
 */
@SpringBootApplication
@MapperScan(basePackages = "club.xuanshangling.mapper")
@ComponentScan(basePackages = {"club.xuanshangling", "org.n3r.idworker"})
public class ApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
    }

}
