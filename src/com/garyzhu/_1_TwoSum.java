package com.garyzhu;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * <p/>
 * You may assume that each input would have exactly one solution.
 * <p/>
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * <p/>
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 * UPDATE (2016/2/13):
 * The return format had been changed to zero-based indices. Please read the above updated description carefully.
 */
public class _1_TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> helper = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            helper.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            if (helper.containsKey(target - nums[i]) && (i != helper.get(target - nums[i]))) {
                return new int[] {i, helper.get(target - nums[i])};
            }
        }
        return null;
    }
}
