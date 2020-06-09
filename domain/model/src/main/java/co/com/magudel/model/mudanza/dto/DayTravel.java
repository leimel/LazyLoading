package co.com.magudel.model.mudanza.dto;

public class DayTravel {
    private String name;
    private Integer numTravels;

    public DayTravel(){
        this.name = null;
        this.numTravels = null;
    }
    public DayTravel(String name, Integer numTravels) {
        this.name = name;
        this.numTravels = numTravels;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumTravels() {
        return numTravels;
    }

    public void setNumTravels(Integer numTravels) {
        this.numTravels = numTravels;
    }

    @Override
    public String toString() {
        return name + ": " + numTravels;
    }
}
