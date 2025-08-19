package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        basePackages = "hello.core", //디폴트는 @ComponentScan위치부터 다 뒤짐, 패지키를 지정하지 않고, 설정정보를 최상단에 두면 좋음
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
) //@붙은 클래스 찾아내서 스프링 빈으로 등록해줌


public class AutoAppConfig {

}
