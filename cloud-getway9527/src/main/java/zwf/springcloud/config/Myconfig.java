package zwf.springcloud.config;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zwf
 * @create 2021-01-20-21:06
 */
@Configuration
public class Myconfig {
    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder){
        RouteLocatorBuilder.Builder routes = builder.routes();
        routes.route("1", r->{
           return r.path("/guonei").uri("http://news.baidu.com/guonei");
        }).build();
        return routes.build();
    }
}
