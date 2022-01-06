package leetCode;

/* 最长回文子串 palindromic
 * 示例 1：
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 
 * 示例 2：
 * 输入：s = "cbbd"
 * 输出："bb"
 * 
 * 示例 3：
 * 输入：s = "a"
 * 输出："a"
 * 
 * 示例 4：
 * 输入：s = "ac"
 * 输出："a"
 * 
 * 示例 5：
 * 输入：s = "bababd"
 * 输出："babab"
 * */

public class Q5V2 {

	public static boolean isPalindrome(char[] arr, int i, int j) {
		for (int k = i; k <= (j + i) / 2; k++) {
			if (arr[k] != arr[j - k + i])
				return false;
		}
		return true;
	}

	public static String longestPalindrome(String s) {
		char[] sarr = s.toCharArray();
		int max = 0;
		String result = "";
		int len = s.length();
		for (int i = 0; i < len; i++) { // 左边界
			for (int j = i; j < len; j++) { // 右边界
				if (j - i + 1 > max && isPalindrome(sarr, i, j)) {
					max = j - i;
					result = s.substring(i, j + 1);
				}
			}
		}

		return result;
	}

	public static void main(String[] args) {
		System.out.println(longestPalindrome("babad")); // bab
		System.out.println(longestPalindrome("cbbd")); // bb
		System.out.println(longestPalindrome("a")); // a
		System.out.println(longestPalindrome("ac")); // a
		System.out.println(longestPalindrome("bababd")); // babab
		System.out.println(longestPalindrome("ccc")); // ccc
		System.out.println(longestPalindrome("aaaa")); // aaaa
		System.out.println(longestPalindrome("sooos")); // sooos
		System.out.println(longestPalindrome("abbbba")); // abbbba
	}
}
