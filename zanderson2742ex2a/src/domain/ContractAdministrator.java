package domain;

import java.time.LocalDateTime;

public class ContractAdministrator extends Administrator{
    private Double monthlyRate;

    public ContractAdministrator (int personId, String firstName, String lastName, String userName, LocalDateTime birthDate, String ssn,
                                  String phone, LocalDateTime employmentStartDate, Double monthlyRate){
        super(personId, firstName, lastName, userName, birthDate, ssn, phone, employmentStartDate);
        this.monthlyRate = monthlyRate;
    }

    private Double getMonthlyRate() {
        return monthlyRate;
    }

    private void setMonthlyRate(Double monthlyRate) {
        this.monthlyRate = monthlyRate;
    }

    @Override
    public String toString() {
        return super.toString() +"ContractAdministrator{" +
                "monthlyRate= " + monthlyRate +
                "Gross Pay= "+ String.format("%.2f",calcGrossPay() )+
                '}';
    }

    @Override
    public double calcGrossPay(){
        return monthlyRate;
    }
}
