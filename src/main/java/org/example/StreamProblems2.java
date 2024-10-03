package org.example;

import org.example.domain.Item;
import org.example.domain.Order;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamProblems2 {

    public static void main(String args[]){

        Item item = new Item("Orange",12,100);
        Item item1 = new Item("Banana",10,200);
        Item item2 = new Item("Mango",5,30);
        Item item3 = new Item("Orange",7,150);
        Item item4 = new Item("Banana",4,100);
        Item item5 = new Item("Mango",3,50);
        Item item6 = new Item("Orange",2,60);
        Item item7 = new Item("Banana",11,130);

        Order order1 = new Order(List.of(item,item3,item4,item5));
        Order order2 = new Order(List.of(item6,item2,item1,item5));
        Order order3 = new Order(List.of(item7,item1,item3,item2));
        Order order4 = new Order(List.of(item5,item3,item6,item7));
        Order order5 = new Order(List.of(item,item1,item3,item5));

        List<Order> orderList = List.of(order1,order2,order3,order4,order5);
        joiningItemsInOrderList(orderList);
        findNumberTimesForEachItem(orderList);
        findTheAmountSpentOnEachItem(orderList);
    }


    private static void findNumberTimesForEachItem(List<Order> orderList) {
        Map<String, Long> amountMap = orderList.stream()
                .flatMap(order ->
                        order.itemList().stream()

                ).collect(Collectors.groupingBy(Item::name,Collectors.counting()));

        amountMap.entrySet().stream()
                .forEach(entry -> System.out.println(entry.getKey() +" --> "+ entry.getValue()));

    }


    private static void joiningItemsInOrderList(List<Order> orderList) {
        String  itemName = orderList.stream()
                .flatMap(order -> order.itemList().stream())
                .map( Item::name)
                .collect(Collectors.joining(","));

    System.out.println(itemName);

    }




    private static void findTheAmountSpentOnEachItem(List<Order> orderList) {

        Map<String,Integer> amountMap = orderList.stream()
                .flatMap(order ->
                    order.itemList().stream()

                ).collect(Collectors.groupingBy(Item::name,Collectors.summingInt(item -> item.price() * item.quantity())));

        amountMap.entrySet().stream()
                .forEach(entry -> System.out.println(entry.getKey() +" --> "+ entry.getValue()));

    }
}
