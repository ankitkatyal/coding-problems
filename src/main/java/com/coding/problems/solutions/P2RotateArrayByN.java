package com.coding.problems.solutions;


import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/*

     We’re given an array of integers, nums. Rotate the array by n elements, where n is an integer:
     For positive values of n, perform a right rotation.
     For negative values of n, perform a left rotation.
     Make sure we make changes to the original array.


 */
public class P2RotateArrayByN {

    private P2RotateArrayByN(){

    }

    private static final Logger LOGGER = Logger.getLogger(P2RotateArrayByN.class.getName());
    public static void creator(){
        List<Integer> nums = new ArrayList<>() ;



        nums.add(1);
        nums.add(10);
        nums.add(100);
        nums.add(101);
        nums.add(111);
        nums.add(1222);
        nums.add(5);
        nums.add(123);
        nums.add(144);
        nums.add(13323);
        nums.add(1323);
        nums.add(1211);




        rotateArray(nums,-1);

        rotateArray(nums,2);


        rotateArray(nums,4);



    }


    static void rotateArray(List<Integer> nums, int n) {
        System.out.println();
        System.out.println("Before");

            nums.stream().forEach(i -> System.out.print(i+" , "));


        List<Integer> newNums = new ArrayList<>();
        if(n>0){
            int start = nums.size() -n;
            int end = start -1;
            while(start<nums.size()){
                newNums.add(nums.get(start));
                start++;
            }
            for (int i=0;i<=end;i++){
                newNums.add(nums.get(i));
            }
        }else{
            int start = -1*n;
            while(start<nums.size()){
                newNums.add(nums.get(start));
                start++;
            }
            for (int i=0;i<-1*n;i++){
                newNums.add(nums.get(i));
            }
        }
        System.out.println();
        System.out.println("After rotating by : "+n);

        newNums.stream().forEach(i -> System.out.print(i+" , "));
    }
}
