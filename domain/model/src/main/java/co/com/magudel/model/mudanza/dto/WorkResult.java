package co.com.magudel.model.mudanza.dto;

import java.util.LinkedList;
import java.util.List;

public class WorkResult {

    private String userIdentification;
    private List<DayTravel> travels;

    public WorkResult() {
        this.userIdentification = null;
        this.travels = new LinkedList<>();
    }

    public WorkResult(String userIdentification, List<DayTravel> travels) {
        this.userIdentification = userIdentification;
        this.travels = travels;
    }

    public List<DayTravel> getTravels() {
        return travels;
    }

    public String getUserIdentification() {
        return userIdentification;
    }

    public void setUserIdentification(String userIdentification) {
        this.userIdentification = userIdentification;
    }

    public void setTravels(List<DayTravel> travels) {
        this.travels = travels;
    }
}
