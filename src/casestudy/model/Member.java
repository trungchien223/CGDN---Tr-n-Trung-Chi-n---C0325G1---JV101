package casestudy.model;

import java.time.LocalDate;

public class Member extends Person{
    private LocalDate dateOfBirth;
    private String membershipType;
    private LocalDate startDate;
    private String trainerId;

    public Member() {
    }

    public Member(String id, String name, LocalDate dateOfBirth, String gender, String phone,
                  String membershipType, LocalDate startDate, String trainerId) {
        super(id, name, phone, gender);
        this.dateOfBirth = dateOfBirth;
        this.membershipType = membershipType;
        this.startDate = startDate;
        this.trainerId = trainerId;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getMembershipType() {
        return membershipType;
    }

    public void setMembershipType(String membershipType) {
        this.membershipType = membershipType;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public String getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(String trainerId) {
        this.trainerId = trainerId;
    }
    public String toCSV() {
        return getId() + "," + getName() + "," + getDateOfBirth() + "," + getGender() + "," +
                getPhone() + "," + getMembershipType() + "," + getStartDate() + "," + getTrainerId();
    }

    @Override
    public String toString() {
        return "Hội viên:" +
                " | " + super.toString() +
                " | Ngày sinh: " + dateOfBirth +
                " | Gói tập: '" + membershipType + '\'' +
                " | Ngày bắt đầu: " + startDate +
                " | Mã HLV: '" + trainerId + '\'';
    }
}
