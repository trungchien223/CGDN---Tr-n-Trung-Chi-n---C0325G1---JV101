package casestudy.service;

import casestudy.model.Member;

import java.util.List;

public interface IMemberService {
    List<Member> findAll();
    boolean add(Member member);
    boolean delete(String id);
    boolean update(String id, Member member);
    Member findById(String id);
}
