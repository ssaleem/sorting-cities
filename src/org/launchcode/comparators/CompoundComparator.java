package org.launchcode.comparators;

import org.launchcode.City;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CompoundComparator implements Comparator<City> {
    private List<Comparator<City>> comparators = new ArrayList<>();

    public void add(Comparator<City> comparator) {
        comparators.add(comparator);
    }

    @Override
    public int compare(City o1, City o2) {
        int theComparatorIndex = 0;
        while(theComparatorIndex < comparators.size()){
            if(comparators.get(theComparatorIndex).compare(o1, o2) != 0){
                break;
            }
            theComparatorIndex++;
        }
        return comparators.get(theComparatorIndex).compare(o1, o2);
    }
}
