package leetCode;

import java.util.Stack;

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

public class Q7V1 {
	// 我的解法，用栈（其实不用
	public static int reverse(int x) {
		Stack<Integer> stack = new Stack<>();

		boolean isNegative = false;
		if (x < 0) {
			isNegative = true;
			x *= -1;
		}

		// 用栈存储从个位开始的数字
		while (x > 0) {
			int mod = x % 10;
			stack.push(mod);
			x = (x - mod) / 10;
		}

		int result = 0;
		int multiplier = 1;
		// 从栈取出，依次乘1，10，100...
		while (!stack.isEmpty()) {
			result += stack.pop() * multiplier;

			// stack.peek() * multiplier * 10 + result > 2^31 - 1
			if (!stack.isEmpty() && isNegative == false
					&& stack.peek() * multiplier > (Math.pow(2, 31) - 1 - result) / 10)
				return 0;
			else if (!stack.isEmpty() && isNegative == true
					&& stack.peek() * multiplier > (Math.pow(2, 31) - result) / 10)
				return 0;
			multiplier *= 10;
		}

		if (isNegative == true)
			result *= -1;
		return result;
	}

	public static void main(String[] args) {
		System.out.println(reverse(-123));
		System.out.println(reverse(1534236469));

	}
}
