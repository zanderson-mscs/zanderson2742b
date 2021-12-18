package domain;

import java.sql.Time;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class HourlyAdministrator extends Administrator {

    private Double hourlyRate;
    private ArrayList<TimeCard> timeCards = new ArrayList<TimeCard>();
    LocalDateTime startDateTime;
    LocalDateTime endDateTime;

    public HourlyAdministrator(int personId, String firstName, String lastName, String userName, LocalDateTime birthDate, String ssn,
                               String phone, LocalDateTime employmentStartDate, Double hourlyRate ){
        super(personId, firstName, lastName, userName, birthDate, ssn, phone, employmentStartDate);
        this.hourlyRate = hourlyRate;

    }

    public void addTimeCard(LocalDateTime startDateTime, LocalDateTime endDateTime){
        this.timeCards.add(new TimeCard(startDateTime, endDateTime));

    }

    public TimeCard removeTimeCard(int index){
        TimeCard timeCard = null;
        if (index >= 0 && index < this.timeCards.size()) {
            timeCard = this.timeCards.get(index).copy();
            this.timeCards.remove(index);
        }
        return timeCard;
    }

    public TimeCard getTimeCard(int index){
       TimeCard timeCard = null;
        if(index< this.timeCards.size()){
            timeCard = this.timeCards.get(index).copy();
            this.timeCards.remove(index);
        }
        return timeCard;
    }


    public ArrayList<TimeCard> getTimeCards(){
        ArrayList<TimeCard> timeCards = new ArrayList<TimeCard>();
        for (TimeCard timeCard : this.timeCards){
            timeCards.add(timeCard.copy());
        }
        return timeCards;
    }
    public Double calcHours(){
        return startDateTime.until(this.endDateTime, ChronoUnit.MINUTES) / 60.0 ;

    }

    public double calcTotalHours(){
        double totalHours = 0.0;

        for(TimeCard timeCard : this.timeCards)

            totalHours += timeCard.calcHours();

        return totalHours;
    }

    @Override
    public double calcGrossPay(){
        return this.hourlyRate * this.calcTotalHours();
    }


    private double getHourlyRate() {
        return hourlyRate;
    }

    private void setHourlyRate(Double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" + "HourlyAdministrator{" +
                "hourlyRate=" + hourlyRate +
//                "Hours= " + String.format( "%.2f" , calcHours() ) + //breaks the toString, nullpointer exception. needs object
//                "Total Hours= " + String.format("%.2f", this.calcTotalHours()) +
                "Gross Pay= "+ String.format("%.2f", this.calcGrossPay()) +
                '}'
                ;
    }
}
