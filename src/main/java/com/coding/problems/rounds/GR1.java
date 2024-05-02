package com.coding.problems.rounds;

// you can also use imports, for example:
// import java.util.*;
import java.util.*;
// Global Relay Interview Question
public class GR1 {

    public static boolean containsPythagoras(final Collection<Integer> numbers) {
        List<Integer> list = new ArrayList<Integer>();

        if (numbers == null) {
            return false;
        }

        Set<Integer> squares = new HashSet<Integer>();

        for(Integer i:numbers){
            squares.add(i*i);
            list.add(i);
        }


        for(int i=0;i<list.size();i++){
            int num1 = list.get(i);
            for(int j=i+1;j<list.size();j++){
                int num2 = list.get(j);
                boolean result = checkPythoGorasTriplet(squares,num1*num1,num2*num2);
                if (result) {
                    return true;
                }
            }
        }

        return false;

    }

    public static boolean checkPythoGorasTriplet(final Set<Integer> squares,final int num1,final int num2){
        int sum = num1 + num2 ;
        return squares.contains(sum);

    }


}
