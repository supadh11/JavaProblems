package org.example;

import org.example.domain.City;
import org.example.domain.State;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamProblems {

    public static void main(String args[]){
        City agra = new City("Agra","07306", 100031);
        City lucknow = new City("Lucknow","07301",476253);
        City bareilly = new City("Bareilly","07302",98753);
        List<City> cityList1 = List.of(agra,lucknow,bareilly);

        City surat = new City("Surat","08306",564365);
        City ahmedabad = new City("ahmedabad","08301",376743);
        City gandhinagar = new City("gandhinagar","08302",879043);
        City baroda = new City("baroda","08302",675755);

        List<City> cityList2 = List.of(surat,ahmedabad,gandhinagar,baroda);

        City indore = new City("indore","09306",876286);
        City bhopal = new City("bhopal","09301",865766);
        City gwalior = new City("gwalior","09302",137682);
        City ujjain = new City("ujjain","09302",2465439);

        List<City> cityList3 = List.of(indore,bhopal,gwalior,ujjain);

        City mumbai = new City("mumbai","10306",99926769);
        City pune = new City("pune","10301",4987987);
        City nasik = new City("nasik","10302",378786);

        List<City> cityList4 = List.of(mumbai,pune,nasik);

        State state1 = new State("Uttar Pradesh","Lucknow",cityList1,70);
        State state2 = new State("Gujarat","Gandhinagar",cityList2,83);
        State state3 = new State("Madhya Pradesh","Bhopal",cityList3,91);
        State state4 = new State("Maharashtra", "Mumbai", cityList4,108);

        List<State> stateList = List.of(state1, state2,state3,state4);
        countNumberOfCitiesInState(state1);
        countNumberOfCitiesInAllStates(stateList);
        capitalOfAllStates(stateList);
        cityListinStates(stateList);
        cityNameListinStates(stateList);
        cityNameListInAllStates(stateList);
        filterStatesNameWithMoreThan100Districts(stateList);
    }
    //usage of Count
    private static void countNumberOfCitiesInState(State state1){
        int count = (int)state1.cities().stream().count();
        System.out.println("Count in state1" + count);
    }

    //usage of count with map
    private static void countNumberOfCitiesInAllStates(List<State> stateList){
        List<Integer> countList = stateList.stream()
                        .map(state -> {return state.cities().size();})
                        .collect(Collectors.toUnmodifiableList());
        System.out.println("Count of cities state wise : "+countList);
    }
    //usage of map with function reference
    private static void capitalOfAllStates(List<State>stateList){
        List<String> capitalList = stateList.stream()
                .map(State::capital)
                .collect(Collectors.toUnmodifiableList());
        System.out.println("List of Capitals " +capitalList);
    }

    private static void cityListinStates(List<State> stateList){
        List<List<City>> cityList = stateList.stream()
        .map(State::cities)
                .collect(Collectors.toList());

        System.out.println("List of Cities in each State"+cityList);
    }

    //usage of map with names of cities
    private static void cityNameListinStates(List<State> stateList){
        List<List<String>> cityList = stateList.stream()
                .map(state -> {return state.cities().stream().map(City::name).collect(Collectors.toUnmodifiableList());})
                .collect(Collectors.toList());

        System.out.println("List of Cities in each State"+cityList);
    }

    //usage of flatmap with names of cities and city to flatten the lists
    private static void cityNameListInAllStates(List<State> stateList){
        List<City> cityList = stateList.stream()
                .flatMap(state -> state.cities().stream())
                .collect(Collectors.toUnmodifiableList());
        System.out.println("List of Cities in each State"+cityList);

       List<String> cityNames =   stateList.stream()
               .flatMap( state -> state.cities().stream())
               .map(City::name)
                          .collect(Collectors.toUnmodifiableList());

        System.out.println("List of City Name in each State "+cityNames);
    }


//usage of filter function
    private static void filterStatesNameWithMoreThan100Districts(List<State> stateList){

        List<String> filteredList = stateList.stream()
                .filter(state -> {return  state.numOfDistricts() > 100;})
                .map(State::name)
                .collect(Collectors.toUnmodifiableList());
        System.out.println("Filtered List with More than 100 districts "  +filteredList);
    }

    //usage of filter function on inner list
   /* private static void filterCityNameWithMorePopulation(List<State> stateList){

        List<String> filteredList = stateList.stream()
                .filter(state ->{return state.cities().stream()
                        .map(City::population)<500000})
                .map(State::name)
                .collect(Collectors.toUnmodifiableList());
        System.out.println("Filtered List with More than 100 districts "  +filteredList);
    }*/

}
