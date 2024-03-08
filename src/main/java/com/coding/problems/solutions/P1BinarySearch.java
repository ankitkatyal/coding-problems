package com.coding.problems.solutions;

import java.util.logging.Level;
import java.util.logging.Logger;

/*

    Binary Search


    We are given an array of integers, nums,
    sorted in ascending order, and an integer value, target.
    If the target exists in the array, return its index.
    If the target does not exist, then return -1.
    The binary search divides the input array by half at every step.
    After every step, either we find the index we are looking for,
    or we discard half of the array.

    */



public class P1BinarySearch {

    private static final Logger LOGGER = Logger.getLogger(P1BinarySearch.class.getName());
    private P1BinarySearch(){

        }
        public static void creator(){

            int[] arr = new int[5];
            arr[0] = 1;
            arr[1] = 3;
            arr[2] = 9;
            arr[3] = 10;
            arr[4] = 12;
            int result = binarySearch(arr, 9);

            LOGGER.log(Level.INFO, ()-> String.format("Result: %s" , result));
        }
        public static int binarySearch(int[] nums, int target) {


        int i = 0;
        int j = nums.length -1;
            while(i<j){
                int mid = (i+j)/2;
                if(nums[mid]==target){
                    return mid;
                }else if(nums[mid]>target){
                    j = mid-1;
                }else{
                    i= mid +1;
                }
            }
            return -1;
        }

}
