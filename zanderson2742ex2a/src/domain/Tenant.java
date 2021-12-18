package domain;

import java.time.LocalDateTime;

public class Tenant extends Person{
    private LocalDateTime birthdate;
    private String ssn;
    private String phone;
    private String employer;
    private String occupation;
    private Double grossPay;
    private LocalDateTime employmentStartDate;

    public Tenant (int personId, String firstName, String lastName, String userName, LocalDateTime birthdate, String ssn, String phone,
                   String employer, String occupation, Double grossPay, LocalDateTime employmentStartDate) {
        super(personId, firstName, lastName, userName);
        this.birthdate = birthdate;
        this.ssn = ssn;
        this.phone = phone;
        this.employer = employer;
        this.occupation = occupation;
        this.grossPay = grossPay;
        this.employmentStartDate = employmentStartDate;
    }

    @Override
    public String toString() {
        return
                super.toString() +
                "Tenant{" +
                "birthdate=" + birthdate +
                ", ssn='" + ssn + '\'' +
                ", phone='" + phone + '\'' +
                ", employer='" + employer + '\'' +
                ", occupation='" + occupation + '\'' +
                ", grossPay=" + grossPay +
                ", employmentStartDate=" + employmentStartDate +
                '}';
    }

    public LocalDateTime getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDateTime birthdate) {
        this.birthdate = birthdate;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmployer() {
        return employer;
    }

    public void setEmployer(String employer) {
        this.employer = employer;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public Double getGrossPay() {
        return grossPay;
    }

    public void setGrossPay(Double grossPay) {
        this.grossPay = grossPay;
    }

    public LocalDateTime getEmploymentStartDate() {
        return employmentStartDate;
    }

    public void setEmploymentStartDate(LocalDateTime employmentStartDate) {
        this.employmentStartDate = employmentStartDate;
    }

//    102, "Ceona", "Johnson", "spyCat", LocalDateTime.of(2004, 10, 6, 0,0,0 ), "111-11-1111",
//            "507-789-4561", "Joanne Fabric", "Sales Clerk", 2222.22,
//            LocalDateTime.of(2021, 12, 10, 0,0)
    // use for future tenant?
}
