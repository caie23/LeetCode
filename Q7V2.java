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

public class Q7V2 {
	// 检查溢出的方法仅限Java语言，C++不行
	public static int reverse(int x) {
		int res = 0;
		while (x != 0) {
			int tmp = res * 10 + x % 10;
			if (tmp / 10 != res) { // 溢出!!!
				return 0;
			}
			res = tmp;
			x /= 10;
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(reverse(-123));
		System.out.println(reverse(1534236469));

	}
}
