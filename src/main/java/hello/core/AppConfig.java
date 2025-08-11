package hello.core;

import hello.core.Order.Order;
import hello.core.Order.OrderService;
import hello.core.Order.OrderServiceImpl;
import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(MemberRepository());
    }

    private MemoryMemberRepository MemberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(MemberRepository(), discountPolicy()); //생성자 주입(Injection)
    }

    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy(); //여기만 고치면 RateDispolicy 가능
        return new RateDiscountPolicy();
    }
    //이렇게 하면 역할이 다 드러남
}
