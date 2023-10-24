package org.example.manager;

import org.example.instruments.*;

import java.util.List;
import java.util.stream.Collectors;

 public class SearchManager {
     public SearchManager(){}
     static public List<Instrument> searchForType(List<Instrument> allInstrumentsList, String type){
        return allInstrumentsList.stream().filter(i -> i.getType().equals(type)).collect(Collectors.toList());
    }
     static public List<Instrument> searchForName(List<Instrument> allInstrumentsList, String name){
         return allInstrumentsList.stream().filter(i -> i.getName().equals(name)).collect(Collectors.toList());
     }

}
