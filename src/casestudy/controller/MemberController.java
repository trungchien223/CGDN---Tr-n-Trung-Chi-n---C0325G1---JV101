package casestudy.controller;

import casestudy.model.Member;
import casestudy.model.Trainer;
import casestudy.service.IMemberService;
import casestudy.service.ITrainerService;
import casestudy.service.MemberService;
import casestudy.service.TrainerService;

import java.util.List;

public class MemberController {
    private final IMemberService memberService = new MemberService();
    private final ITrainerService trainerService = new TrainerService();

    public List<Member> getAllMembers() {
        return memberService.findAll();
    }

    public boolean addMember(Member member) {
        return memberService.add(member);
    }

    public boolean updateMember(String id, Member member) {
        return memberService.update(id, member);
    }

    public boolean deleteMember(String id) {
        return memberService.delete(id);
    }

    public Member findMemberById(String id) {
        return memberService.findById(id);
    }

    public void assignTrainerToMember(String memberId, String trainerId) {
        Member member = memberService.findById(memberId);
        Trainer trainer = trainerService.findById(trainerId);

        if (member == null || trainer == null) {
            return;
        }

        member.setTrainerId(trainerId);
        memberService.update(memberId, member);
    }

    public List<Trainer> getAllTrainers() {
        return trainerService.findAll();
    }
    public Trainer findTrainerById(String id) {
        for (Trainer trainer : getAllTrainers()) {
            if (trainer.getId().equalsIgnoreCase(id)) {
                return trainer;
            }
        }
        return null;
    }
}
