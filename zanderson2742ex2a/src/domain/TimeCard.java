package domain;

import java.sql.Time;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeCard {
    private int timeCardId;
    LocalDateTime startDateTime;
    LocalDateTime endDateTime;

    public TimeCard( LocalDateTime startDateTime, LocalDateTime endDateTime){
        this.timeCardId = DbContext.getNextTimeCardId();
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;

    }

    private TimeCard(int timeCardId,LocalDateTime startDateTime, LocalDateTime endDateTime ){
        this.timeCardId = timeCardId;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;

    }

    public  TimeCard(TimeCard timeCard){

    }

    public TimeCard copy(){
        return new TimeCard(this.timeCardId, this.startDateTime, this.endDateTime);
    }

    public Double calcHours(){
        return 0.0;
    }


    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mma");
        return "TimeCard{" +
                "timeCardId=" + timeCardId +
                ", startDateTime=" + startDateTime.format(formatter) +
                ", endDateTime=" + endDateTime.format(formatter) +
                '}';
    }
}
