package org.example.java.problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;



public class StreamProblems3 {

    public static void main(String args[]){
        List<String> inputList = Arrays.asList("Test", "Value", "Map", "Produce", "Value", "map");
        convertLowerCaseToUpperCaseStream("Test");
        removeDuplicateElementsFromAList(inputList);
        countStringsStartingWithLetter(inputList);
    }

    //Convert a string from lowercase to uppercase usign stream
    public static void  convertLowerCaseToUpperCaseStream(String val){
       String returnedVal = Arrays.stream(val.split(""))
               .map(s -> {return s.toUpperCase();})
               .collect(Collectors.joining());

        System.out.println(returnedVal);
    }

    //to remove all duplicate elements from a list using streams.

    public static void removeDuplicateElementsFromAList(List<String> stringList){
        Set<String> stringSet = new HashSet<String>();
        List<String> outputString  = stringList.stream()
                .filter(s ->{
                   return stringSet.add(s);
                }).collect(Collectors.toUnmodifiableList());

        outputString.stream().forEach(val -> {System.out.print(val+ "  ");});
    }


    //to count the number of strings in a list that start with a specific letter using streams.
    public static void countStringsStartingWithLetter(List<String> inputList){
        long count = inputList.stream()
                .filter(input->{
                  return  input.charAt(0) == 'V';
                }).count();
        System.out.println("");
        System.out.println("Count of string starting with letter V is "+count);
    }
}
