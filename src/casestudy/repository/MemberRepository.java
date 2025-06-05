package casestudy.repository;

import casestudy.model.Member;

import java.util.ArrayList;
import java.util.List;

public class MemberRepository implements IMemberRepository{
    private static final List<Member> memberList = new ArrayList<>();
    private static final MemberRepository instance = new MemberRepository();

    private MemberRepository() {
    }
    public static MemberRepository getInstance(){
        return instance;
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
