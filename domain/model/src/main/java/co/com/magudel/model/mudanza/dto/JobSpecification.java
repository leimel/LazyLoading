package co.com.magudel.model.mudanza.dto;

import java.util.LinkedList;
import java.util.List;

public class JobSpecification {
    private String userIdentification;
    private Integer days;
    private List<JobDay> daysSpecification;

    public JobSpecification(){
        this.userIdentification = null;
        this.days = 0;
        this.daysSpecification = new LinkedList<>();
    }

    public JobSpecification(String userIdentification, Integer days, List<JobDay> daysSpecification) {
        this.userIdentification = userIdentification;
        this.days = days;
        this.daysSpecification = daysSpecification;
    }

    public static JobSpecification from(final JobSpecification jobSpecification){
        return new JobSpecification(jobSpecification.getUserIdentification(), jobSpecification.getDays(), jobSpecification.getInfoJobDay());
    }

    public String getUserIdentification() {
        return userIdentification;
    }

    public void setUserIdentification(String userIdentification) {
        this.userIdentification = userIdentification;
    }

    public Integer getDays() {
        return days;
    }

    public List<JobDay> getInfoJobDay() {
        return daysSpecification;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public void setDaysSpecification(List<JobDay> daysSpecification) {
        this.daysSpecification = daysSpecification;
    }
}
