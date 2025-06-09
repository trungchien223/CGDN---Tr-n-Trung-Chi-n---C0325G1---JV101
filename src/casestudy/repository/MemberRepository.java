package casestudy.repository;

import casestudy.model.Member;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MemberRepository implements IMemberRepository{
    private static final List<Member> memberList = new ArrayList<>();
    static {
        memberList.add(new Member("M1", "Tam", LocalDate.of(1995, 5, 15), "Nam", "0901234567",
                "Gói 3 tháng", LocalDate.of(2023, 10, 1), "T1"));
        memberList.add(new Member("M2", "Chien", LocalDate.of(1998, 8, 22), "Nam", "0912345678",
                "Gói 6 tháng", LocalDate.of(2023, 11, 15), "T2"));
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(memberList);
    }

    @Override
    public boolean add(Member member) {
        if (findById(member.getId())!= null){
            return false;
        }
        return memberList.add(member);
    }

    @Override
    public boolean delete(String id) {
        Member member  = findById(id);
        if (member != null){
            return memberList.remove(member);
        }
        return false;
    }

    @Override
    public boolean update(String id, Member member) {
        int index = -1;
        for (int i = 0; i < memberList.size(); i++) {
            if (memberList.get(i).getId().equals(id)) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            memberList.set(index, member);
            return true;
        }
        return false;
    }

    @Override
    public Member findById(String id) {
        for (Member member : memberList) {
            if (member.getId().equals(id)) {
                return member;
            }
        }
        return null;
    }
}
