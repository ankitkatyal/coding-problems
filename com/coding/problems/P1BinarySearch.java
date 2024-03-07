package com.coding.problems;

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


        public  void creator(){

            int[] arr = new int[5];
            arr[0] = 1;
            arr[1] = 3;
            arr[2] = 9;
            arr[3] = 10;
            arr[4] = 12;
            int result = binarySearch(arr, 9);

            System.out.println(result);

        }
        public static int binarySearch(int[] nums, int target) {
            // TODO: Write - Your - Code

            for(int i=0;i<nums.length;i++){
                if(nums[i]==target){
                    return i;
                }
            }
            return -1;
        }

}
