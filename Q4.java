package leetCode;

import java.util.ArrayList;
import java.util.List;

/*
 * 示例 1：
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * 
 * 示例 2：
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 * 
 * 示例 3：
 * 输入：nums1 = [0,0], nums2 = [0,0]
 * 输出：0.00000
 * 
 * 示例 4：
 * 输入：nums1 = [], nums2 = [1]
 * 输出：1.00000
 * 
 * 示例 5：
 * 输入：nums1 = [2], nums2 = []
 * 输出：2.00000
 * 
 * input: nums1 = [1], nums2 = [2]
 * output: 1.50000
 * 
 * 时间复杂度应该为 O(log (m+n)) */

class Q4 {
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int l1 = nums1.length;
		int l2 = nums2.length;
		int l = l1 + l2; // 合并后的总长度
		int m = l / 2; // 如果总长为奇数，m为合并后数组的中位数位置

		// 储存合并的数组
		List<Integer> merged = new ArrayList<>();

		// 如果nums1, nums2其中之一为空
		if (l1 == 0)
			if (l2 % 2 == 1) // 另一个长度为奇数
				return nums2[m];
			else // 另一个长度为偶数
				return (double) (nums2[m - 1] + nums2[m]) / 2;
		if (l2 == 0)
			if (l1 % 2 == 1)
				return nums1[m];
			else
				return (double) (nums1[m - 1] + nums1[m]) / 2;

		// 合并两个数组（同合并排序一个方法）
		int i = 0, j = 0;
		while (i < l1 && j < l2) {
			if (nums1[i] < nums2[j]) {
				merged.add(nums1[i]);
				i++;
			} else {
				merged.add(nums2[j]);
				j++;
			}
		}
		while (i < l1) {
			merged.add(nums1[i]);
			i++;
		}
		while (j < l2) {
			merged.add(nums2[j]);
			j++;
		}

		// 找合并后数组的中位数
		if (l == 0 || l % 2 == 1)
			return merged.get(m);
		else
			return (double) (merged.get(m - 1) + merged.get(m)) / 2;
	}

	public static void main(String[] args) {
		int[] nums1 = {};
		int[] nums2 = { 2, 3 };
		System.out.println(findMedianSortedArrays(nums1, nums2));
	}
}
