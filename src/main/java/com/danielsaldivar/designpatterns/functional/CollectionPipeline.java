package com.danielsaldivar.designpatterns.functional;

import com.danielsaldivar.utils.ThreadingUtils;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


/*
Collection pipelines are a programming pattern
where you organize some computation as a sequence of operations
which compose by taking a collection as output of one operation and feeding it to the next.
(common operations are filter, map, reduce).


 */
public class CollectionPipeline {
    public static void main(String[] args) {
        List<Integer> numbers = IntStream.range(1, 11)
                .boxed()
                .collect(Collectors.toList());

        //find the total of double of even numbers
        //Here we will use a stream, which is an internal iterator
        long overallStartime = System.currentTimeMillis();
        long evenTotals = numbers.stream()
                .filter(e -> e % 2 == 0)
                .mapToLong(x -> x*2)
                .sum();
        System.out.println("evenTotals = " + evenTotals);
        System.out.println("Time it took " + (System.currentTimeMillis() - overallStartime));


        overallStartime = System.currentTimeMillis();
        long evenTotalsParralel = numbers.parallelStream()
                .filter(e -> e % 2 == 0)
                .mapToLong(x -> x*2)
                .sum();
        System.out.println("evenTotals = " + evenTotalsParralel);
        System.out.println("Time it took " + (System.currentTimeMillis() - overallStartime));
        //This is what we call functional composition

        //one of the biggest advantages is that the code starts to
        //look like the problem statement


        //But what is the alternative to this? Using imperative style
        //which leads to accidental complexity, example below

        long imperativeTotal = 0L;
        for (int x: numbers){
            if (x % 2 == 0){
                imperativeTotal += x * 2L;
            }
        }
        System.out.println("imperativeTotal = " + imperativeTotal);


        /*
        PERFORMANCE
        Using this method, we'll be able to parallize the code
        without having to synchronize and use locks all over the place

        That is as long as your code is using pure functions
         */

        //How can we do ETL with it?
        overallStartime = System.currentTimeMillis();
        numbers.stream()
                .parallel() //super easy to parallelize
                .mapToLong(e -> e)
                .forEachOrdered(System.out::println);
        System.out.println("processedNumbers = " + (System.currentTimeMillis() - overallStartime));



    }



    public static int transform(int number) {
        //System.out.println("t: " + number + "--" + Thread.currentThread() );
       ThreadingUtils.sleep(1000);
        return number;
    }


}
