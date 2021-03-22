package com.danielsaldivar.designpatterns.functional;

import java.util.Arrays;
import java.util.List;

/*
Collection pipelines are a programming pattern
where you organize some computation as a sequence of operations
which compose by taking a collection as output of one operation and feeding it to the next.
(common operations are filter, map, reduce).


 */
public class CollectionPipeline {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);


        //find the total of double of even numbers
        //Here we will use a stream, which is an internal iterator
        int evenTotals = numbers.stream()
                .filter(e -> e % 2 == 0)
                .mapToInt(x -> x*2)
                .sum();
        System.out.println(evenTotals);
    }
}
