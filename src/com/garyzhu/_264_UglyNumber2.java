package com.garyzhu;

/**
 * Write a program to find the n-th ugly number.
 * <p/>
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
 * <p/>
 * Note that 1 is typically treated as an ugly number.
 * L1, L2, L3
 * Uk+1:
 */
 // 动态规划
public class _264_UglyNumber2 {
    public int nthUglyNumber(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int[] uglyNums = new int[n];
        uglyNums[0] = 1;
        int p2 = 0, p3 = 0, p5 = 0;
        for (int i = 1; i < n; i++) {
            uglyNums[i] = Math.min(uglyNums[p2] * 2, Math.min(uglyNums[p3] * 3, uglyNums[p5] * 5));
            if (uglyNums[i] == uglyNums[p2] * 2) {
                p2++;
            }
            if (uglyNums[i] == uglyNums[p3] * 3) {
                p3++;
            }
            if (uglyNums[i] == uglyNums[p5] * 5) {
                p5++;
            }
        }

        return uglyNums[n - 1];
    }
}
