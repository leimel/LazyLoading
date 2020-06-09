package co.com.magudel.model.mudanza.dto;

import java.util.LinkedList;
import java.util.List;

public class JobDay {

    private String name;
    private List<Integer> elementsWeight;

    public JobDay(){
        this.name = null;
        this.elementsWeight = new LinkedList<>();
    }

    public JobDay(String name, List<Integer> elementsWeight) {
        this.name = name;
        this.elementsWeight = elementsWeight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getElementsWeight() {
        return elementsWeight;
    }

    public void setElementsWeight(List<Integer> elementsWeight) {
        this.elementsWeight = elementsWeight;
    }


}
