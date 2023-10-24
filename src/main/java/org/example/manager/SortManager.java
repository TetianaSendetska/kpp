package org.example.manager;

import org.example.instruments.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortManager  {

     public SortManager(){}
     public List<Instrument> sortInstrumentsByPrize(List<Instrument> instrumentList){
        List<Instrument> newList = new ArrayList<>(instrumentList);
        newList.sort(new PrizeComparator());
        return newList;
    }
    public List<Instrument> sortInstrumentsByName(List<Instrument> instrumentList){
        List<Instrument> newList = new ArrayList<>(instrumentList);
        newList.sort(new NameComparator());
        return newList;
    }

    public class NameComparator implements Comparator<Instrument>{
        public int compare(Instrument instrument1, Instrument instrument2) {
            return instrument1.getName().compareTo(instrument2.getName());
        }
    }

    public static class PrizeComparator implements Comparator<Instrument> {
        //@Override
        public int compare(Instrument instrument1, Instrument instrument2) {
            return Double.compare(instrument1.getPrize(), instrument2.getPrize());
        }
    }

}
