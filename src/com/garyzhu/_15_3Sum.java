package com.garyzhu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * <p/>
 * Note: The solution set must not contain duplicate triplets.
 * <p/>
 * For example, given array S = [-1, 0, 1, 2, -1, -4],
 * <p/>
 * A solution set is:
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 */
public class _15_3Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int i, j, k;
        List<List<Integer>> ret = new ArrayList<>();
        for (i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            j = i + 1;
            k = nums.length - 1;

            while (j < k) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    j++;
                    continue;
                }
                if (nums[i] + nums[j] + nums[k] == 0) {
                    List<Integer> tuple = new ArrayList<>();
                    tuple.add(nums[i]);
                    tuple.add(nums[j]);
                    tuple.add(nums[k]);
                    ret.add(tuple);
                    j++;
                    k--;
                } else if (nums[i] + nums[j] + nums[k] < 0) {
                    j++;
                } else {
                    k--;
                }
            }

        }
        return ret;
    }
}
