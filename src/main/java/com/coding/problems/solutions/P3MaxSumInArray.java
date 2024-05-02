package com.coding.problems.solutions;

import java.util.ArrayList;
import java.util.List;

/*
* Alexa loves movies and maintains a list of negative and/or
* positive integer ratings for the movies in her collection.
*  She's getting ready for a film festival and wants to choose
* some subsequence of movies from her collection to bring
* such that the following conditions are satisfied:
* The collective sum of their ratings is maximal.
* She must go through her list in order and cannot
*  skip more than one movie in a row.
* In other words, she cannot skip over two or more consecutive movies.
*  For example, if ratings = [-1, -3, -2],
* she must include either the second number or the
* first and third numbers to get a maximal rating sum of -3.
* For example, ratings = [-3, 2, 4, -1, -2, -5]..
*  Her maximal choices are [2, 4, -2] for a sum of 4.
* */
public class P3MaxSumInArray {

    public static void creator(){
        List<Integer> ratings = new ArrayList<>() ;


        ratings.add(-1);
        ratings.add(-2);
        ratings.add(-3);
        ratings.add(-4);
        ratings.add(-5);



        System.out.println(maxSumOfArray(ratings));


    }
    public static int maxSumOfArray(List<Integer> ratings){

        return maxSumInArray(0,ratings,false);
    }

    public static int maxSumInArray(int index, List<Integer> ratings, boolean lastSkip){

        if(index>ratings.size()-1){
            return 0;
        }

        if(lastSkip){
            return ratings.get(index) + maxSumInArray(index+1,ratings,false);
        }else{
            int currWithSkip = maxSumInArray(index+1,ratings,true);
            int currWithoutSkip = ratings.get(index) + maxSumInArray(index+1,ratings,true);
            return Math.max(currWithoutSkip,currWithSkip);
        }

    }
}
