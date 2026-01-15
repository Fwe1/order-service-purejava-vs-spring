package hello.core;


import hello.core.Order.OrderService;
import hello.core.member.MemberService;

public class CoreApplication {

	public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();

        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();
	}

}
