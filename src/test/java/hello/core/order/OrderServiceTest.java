package hello.core.order;

import hello.core.Order.Order;
import hello.core.Order.OrderService;
import hello.core.Order.OrderServiceImpl;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


public class OrderServiceTest {

    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Test
    void createOrder() {
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = order = orderService.createOrder(memberId, "itemA", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
        /*Assertions.assertThat 사용?
        * 테스트에서만 사용 -> 일반 APP로직에선 사용 안함
        * 테스트 실패 시 에러 메세지를 통해 어디서 실패했는지 알려준다고 함 -> 로직 오류 포함
        * 왜 쓰냐? 하면 편의 도구이고, 써야만 하냐? 하면 그건 아님
        *  */


    }

}
