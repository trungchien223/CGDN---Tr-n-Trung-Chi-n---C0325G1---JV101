package casestudy.service;

import casestudy.model.Member;
import casestudy.repository.IMemberRepository;
import casestudy.repository.MemberRepository;
import casestudy.utils.DuplicateIdException;
import casestudy.utils.IdNotFoundException;

import java.util.List;

public class MemberService implements IMemberService{
    private final IMemberRepository memberRepository = new MemberRepository();

    @Override
    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    @Override
    public boolean add(Member member) {
        try {
            List<Member> members = memberRepository.findAll();
            for (Member m : members) {
                if (m.getId().equals(member.getId())) {
                    throw new DuplicateIdException("ID hội viên đã tồn tại: " + member.getId());
                }
            }
            return memberRepository.add(member);
        } catch (DuplicateIdException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean delete(String id) {
        try {
            Member member = memberRepository.findById(id);
            if (member == null) {
                throw new IdNotFoundException("Không tìm thấy hội viên với ID: " + id);
            }
            return memberRepository.delete(id);
        } catch (IdNotFoundException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean update(String id, Member member) {
        try {
            Member existingMember = memberRepository.findById(id);
            if (existingMember == null) {
                throw new IdNotFoundException("Không tìm thấy hội viên với ID: " + id);
            }
            return memberRepository.update(id, member);
        } catch (IdNotFoundException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public Member findById(String id) {
        return memberRepository.findById(id);
    }
}
