package leetCode;

import java.util.Arrays;

public class Q1 {
	public static int[] twoSum(int[] nums, int target) {
		int len = nums.length;
		for (int i = 0; i < len; i++) {
			for (int j = i + 1; j < len; j++) {
				if (nums[i] + nums[j] == target) {
					int[] result = { i, j };
					return result;
				}
			}
		}
		int[] empty = {};
		return empty;
	}

	public static void main(String[] args) {
		int[] nums = { 2, 7, 11, 15 };
		System.out.println(Arrays.toString(twoSum(nums, 9)));
	}
}
