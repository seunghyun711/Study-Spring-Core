package practice.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        basePackages ="practice.core.member", //member만 컴포넌트 스캔의 대상이 된다.
        basePackageClasses = AutoAppConfig.class,
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
        // @Configuration이 붙은 클래스는 컴포넌트 스캔 대상에서 제외
)
public class AutoAppConfig {
}
