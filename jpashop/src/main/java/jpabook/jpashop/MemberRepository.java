package jpabook.jpashop;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class MemberRepository {


    // 스프링 부트가 엔티티매니저 주입해줌
    @PersistenceContext
    private EntityManager em;

    public Long save(Member member) {
        em.persist(member);
        // 커맨드랑 쿼리를 분리하라. 사이드 이펙트를 막기위해
        // 커맨드 성이기 때문에 아이디만 조회하는걸로 설계
        return member.getId();
    }

    public Member find(Long id) {
        return em.find(Member.class, id);
    }
}
