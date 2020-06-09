package co.com.magudel.usecase.mudanza;

import co.com.magudel.model.mudanza.dto.DayTravel;
import co.com.magudel.model.mudanza.dto.JobDay;
import co.com.magudel.model.mudanza.dto.JobSpecification;
import co.com.magudel.model.mudanza.dto.WorkResult;
import co.com.magudel.model.mudanza.service.RelocationPerformerService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class RelocationPerformer implements RelocationPerformerService {

    private static final int MIN_WEIGHT = 50;

    @Override
    public WorkResult maximizeTrips(JobSpecification jobSpecification){
        Objects.requireNonNull(jobSpecification, "The jobSpecification is required");
        Objects.requireNonNull(jobSpecification.getInfoJobDay(), "The infoJobDay is required");
        Objects.requireNonNull(jobSpecification.getUserIdentification(), "The userIdentification is required");

        List<JobDay> infoJobDays = jobSpecification.getInfoJobDay();

        List<DayTravel> travels = new ArrayList<>();

        infoJobDays.forEach(weightItems -> {
            Objects.requireNonNull(weightItems, "The weightItems is required");

            List<Integer> weightItemsAux = new ArrayList<>(weightItems.getElementsWeight());

            Integer higherWeight = Collections.max(weightItemsAux);
            Integer numTravels = 0;
            Integer numItemInBox = 1;

            for (int indexWeight = 0; indexWeight < weightItems.getElementsWeight().size(); indexWeight++) {

                if ((higherWeight * numItemInBox) >= MIN_WEIGHT) {
                    numTravels++;
                    weightItemsAux.remove(higherWeight);
                    numItemInBox = 0;
                    higherWeight = weightItemsAux.isEmpty() ? higherWeight : Collections.max(weightItemsAux);
                }

                numItemInBox++;
            }
            travels.add(new DayTravel(weightItems.getName(), numTravels));

        });

        return new WorkResult(jobSpecification.getUserIdentification(), travels);
    }

}
