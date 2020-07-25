package prg.array;

/*
Given an array of integers, return indices of the two numbers such that they add up to a specific target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.

Given nums = [2, 7, 11, 15], target = 9,
Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].

*/

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    /*
        complexity O(n^2)
     */
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }

        }
        throw new IllegalArgumentException("No two sum solution.");
    }

    /*
        complexity O(2n) => O(n)
     */
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> cache = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            cache.put(nums[i], i);
        }

        for (int i = 0; i < nums.length ; i++) {
            int compliment = target - nums[i] ;
            if ( cache.containsKey(compliment) && compliment != nums[i])
                return new int [] { i, cache.get(compliment) };

        }
        throw new IllegalArgumentException("No two sum solution.");
    }

    /*
        complexity O(n)
     */
    public int[] twoSum3(int[] nums, int target) {
        Map<Integer, Integer> cache = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            cache.put(nums[i], i);
            int compliment = target - nums[i] ;
            if ( cache.containsKey(compliment) && compliment != nums[i])
                return new int [] { cache.get(compliment),i };
        }

        throw new IllegalArgumentException("No two sum solution.");
    }

    public static void main(String[] args) {
        int[] input1 = {8, 2, 1, 3};
        int[] input2 = {2, 3, 1, 4};
        int[] input3 = {5, -1, 1, 3};
        int[] input4 = {6, 4, 0, 3};
        int[] input5 = {0, 2, 1, 4};

        TwoSum test = new TwoSum();

        int[] out = test.twoSum3(input2, 4);
        System.out.println(Arrays.asList(out[0], out[1]));
    }
}
