package leetCode;

/* 输入：x = 121
 * 输出：true
 * 
 * 输入：x = -121
 * 输出：false
 * 解释：从左向右读, 为 -121 。 从右向左读, 为 121- ，因此它不是一个回文数
 * 
 * 输入：x = 10
 * 输出：false
 * 解释：从右向左读, 为 01 。因此它不是一个回文数
 * 
 * 输入：x = -101
 * 输出：false
 * */

public class Q9 {
	public static boolean isPalindrome(int x) {
		if (x < 0)
			return false;
		if (x == 0)
			return true;

		int original = x;
		int reversed = 0;
		while (x > 0) {
			reversed = reversed * 10 + x % 10;
			x /= 10;
		}
		return original == reversed;
	}

	public static void main(String[] args) {
		System.out.println(isPalindrome(121)); // true
		System.out.println(isPalindrome(-121)); // false
		System.out.println(isPalindrome(10)); // false
		System.out.println(isPalindrome(-101)); // false
	}
}
