package casestudy.service;

import casestudy.model.Member;
import casestudy.repository.IMemberRepository;
import casestudy.repository.MemberRepository;

import java.util.List;

public class MemberService implements IMemberService{
    private final IMemberRepository memberRepository = new MemberRepository();

    @Override
    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    @Override
    public boolean add(Member member) {
        return memberRepository.add(member);
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public boolean update(String id, Member member) {
        return false;
    }

    @Override
    public Member findById(String id) {
        return null;
    }
}
