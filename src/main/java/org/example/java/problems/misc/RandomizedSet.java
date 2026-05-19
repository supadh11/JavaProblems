package org.example.java.problems.misc;


/*

380. Insert Delete GetRandom O(1)

Implement the RandomizedSet class:

RandomizedSet() Initializes the RandomizedSet object.
bool insert(int val) Inserts an item val into the set if not present. Returns true if the item was not present, false otherwise.
bool remove(int val) Removes an item val from the set if present. Returns true if the item was present, false otherwise.
int getRandom() Returns a random element from the current set of elements (it's guaranteed that at least one element exists when this method is called). Each element must have the same probability of being returned.
You must implement the functions of the class such that each function works in average O(1) time complexity..

Solution :
Take a list and Map to manage the index and the value.
While removing the value :
1) find the index of the value from hashmap
2) find the lastElement of the list using list.get(list.size()-1)
3) set the lastElement to the index by list.set(index, lstElement)
4) remove the lastElement from lastIndex;
5) in the hashmap replace the lastElement, to index

while inserting
insert the element at last index
insert in the map as value, list.size()-1;

getRandom
// generate a random number using list.size() and Math.random
return the list.get(random);


 */
import java.util.*;
class RandomizedSet {

    HashMap<Integer, Integer> randomHashMap;
        List<Integer> arrayList;
        Random rand;
public RandomizedSet() {
        randomHashMap = new HashMap<>();
        arrayList = new ArrayList<>();
        rand = new Random();
        }

public boolean insert(int val) {
        if(randomHashMap.get(val) != null){
        return false;
        }else{
        arrayList.add(val);
        randomHashMap.put(val, arrayList.size()-1);
        return true;
        }
        }

public boolean remove(int val) {
        if(randomHashMap.containsKey(val)){
        int index = randomHashMap.get(val);

        int lastIndex = arrayList.size()-1;
        int lastNumber = arrayList.get(lastIndex);

        //swap
        arrayList.set(index, lastNumber);
        randomHashMap.put(lastNumber, index);

        arrayList.remove(lastIndex);
        //remove from map
        randomHashMap.remove(val);
        return true;
        }else{
        return false;
        }
        }

public int getRandom() {
        Integer randomNum = rand.nextInt(arrayList.size());
        return arrayList.get(randomNum);
        }
        }

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */