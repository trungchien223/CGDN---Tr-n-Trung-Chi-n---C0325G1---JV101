package casestudy.repository;

import casestudy.model.Member;
import casestudy.utils.ReadAndWriteFile;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MemberRepository implements IMemberRepository{
    private static final String FILE_PATH = "src/casestudy/data/member.csv";

    @Override
    public List<Member> findAll() {
        List<String> lines = ReadAndWriteFile.readFile(FILE_PATH);
        List<Member> members = new ArrayList<>();
        for (String line : lines) {
            String[] array = line.split(",");
            if (array.length >= 8) {
                Member member = new Member(
                        array[0],
                        array[1],
                        LocalDate.parse(array[2]),
                        array[3],
                        array[4],
                        array[5],
                        LocalDate.parse(array[6]),
                        array[7]
                );
                members.add(member);
            }
        }
        return members;
    }

    @Override
    public boolean add(Member member) {
        List<String> lines = new ArrayList<>();
        lines.add(member.toCSV());
        ReadAndWriteFile.writeFile(FILE_PATH, lines, true);
        return true;
    }

    @Override
    public boolean delete(String id) {
        List<Member> members = findAll();
        List<String> newLines = new ArrayList<>();
        for (Member member : members) {
            if (!member.getId().equals(id)) {
                newLines.add(member.toCSV());
            }
        }
        ReadAndWriteFile.writeFile(FILE_PATH, newLines, false);
        return true;
    }

    @Override
    public boolean update(String id, Member member) {
        List<Member> members = findAll();
        List<String> newLines = new ArrayList<>();
        boolean found = false;
        for (Member m : members) {
            if (m.getId().equals(id)) {
                newLines.add(member.toCSV());
                found = true;
            } else {
                newLines.add(m.toCSV());
            }
        }
        ReadAndWriteFile.writeFile(FILE_PATH, newLines, false);
        return found;
    }

    @Override
    public Member findById(String id) {
        List<Member> members = findAll();
        for (Member member : members) {
            if (member.getId().equals(id)) {
                return member;
            }
        }
        return null;
    }
}
