package leetCode;

/* 示例 1：
 * 输入：x = 123
 * 输出：321
 * 
 * 示例 2：
 * 输入：x = -123
 * 输出：-321
 * 
 * 示例 3：
 * 输入：x = 120
 * 输出：21
 * 
 * 示例 4：
 * 输入：x = 0
 * 输出：0
 * */

public class Q7V3 {
	// 官方题解
	public static int reverse(int x) {
		int result = 0;
		while (x != 0) {
			// 要提前检查
			if (result < Integer.MIN_VALUE / 10 || result > Integer.MAX_VALUE / 10)
				return 0;
			result = result * 10 + x % 10;
			x /= 10;
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(reverse(-123)); // -321
		System.out.println(reverse(1534236469)); // 0
	}
}
