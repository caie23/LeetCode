package leetCode;

/* 盛最多水的容器 
 * 
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49 
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * 
 * 输入：height = [1,1]
 * 输出：1
 * 
 * 输入：height = [4,3,2,1,4]
 * 输出：16
 * 
 * 输入：height = [1,2,1]
 * 输出：2
 * */

public class Q11 {
	// 当一种选择不可能再构成最优解时，就抛弃它来减小问题
	public static int maxArea(int[] height) {
		int max = 0;
		int i = 0, j = height.length - 1; // 双指针
		while (i < j) {
			int area = (j - i) * Math.min(height[j], height[i]);
			if (area > max)
				max = area;

			if (height[i] < height[j])
				i++;
			else
				j--;
		}
		return max;
	}

	public static void main(String[] args) {
		int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
//		int[] height = { 1, 1 };
//		int[] height = { 4, 3, 2, 1, 4 };
//		int[] height = { 1, 2, 1 };
		System.out.println(maxArea(height));
	}
}
