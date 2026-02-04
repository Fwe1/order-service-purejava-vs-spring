package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

public class SingletonTest {

    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    void pureContainer() {
        AppConfig appConfig = new AppConfig();
        //1. 조회 : 호출할 때 마다 객체를 생성
        MemberService memberService1 = appConfig.memberService();


        //2. 조회 : 호출할 때 마다 객체를 생성
        MemberService memberService2 = appConfig.memberService();

        //참조값이 다른 것을 확인
        System.out.println("memberService = " + memberService1);
        System.out.println("memberService = " + memberService2);

        //memberService1 != memberService2
        assertThat(memberService1).isNotSameAs(memberService2);

    }

    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    void SingletonService() {
        SingletonService single1 = SingletonService.getInstance();
        SingletonService single2 = SingletonService.getInstance();
        assertThat(single1).isSameAs(single2);

        System.out.println("single1 = " + single1);
        System.out.println("single2 = " + single2);

        assertThat(single1).isSameAs(single2);
    }

    @Test
    @DisplayName("싱글톤 컨테이너와 싱글톤")
    void springContainer() {

//        AppConfig appConfig = new AppConfig();
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);


        //memberService인 Bean을 가져오는데 객체가 MemberService타입으로 캐스팅 가능한지 검사해줘 라는 뜻
        //스프링이 이걸 보고 memberService 빈(구현체)을 생성하는 것이 아니라, 이미 생성해놓았음
        MemberService memberService1 = ac.getBean("memberService", MemberService.class);
        MemberService memberService2 = ac.getBean("memberService", MemberService.class);

        //참조값이 같은 것을 확인
        System.out.println("memberService = " + memberService1);
        System.out.println("memberService = " + memberService2);

        //memberService1 != memberService2
        assertThat(memberService1).isSameAs(memberService2);

    }
}
