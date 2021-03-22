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
        System.out.println("evenTotals = " + evenTotals);
        //This is what we call functional composition

        //one of the biggest advantages is that the code starts to
        //look like the problem statement


        //But what is the alternative to this? Using imperative style
        //which leads to accidental complexity, example below

        int imperativeTotal = 0;
        for (int x: numbers){
            if (x % 2 == 0){
                imperativeTotal += x * 2;
            }
        }
        System.out.println("imperativeTotal = " + imperativeTotal);


        /*
        PERFORMANCE
        Using this method, we'll be able to parallize the code
        without having to synchronize and use locks all over the place

        That is as long as your code is using pure functions
         */
    }
}
