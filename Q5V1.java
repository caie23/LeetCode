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

public class Q5V1 {

	public static boolean isPalindrome(String s) {
		for (int i = 0; i < s.length() / 2; i++) {
			if (s.charAt(i) != s.charAt(s.length() - 1 - i))
				return false;
		}
		return true;
	}

	public static String longestPalindrome(String s) {
		String result = "";

		for (int i = 0; i < s.length(); i++) { // 左边界
			for (int j = i; j < s.length(); j++) { // 右边界
				if (isPalindrome(s.substring(i, j + 1)) && (j - i + 1) > result.length())
					result = s.substring(i, j + 1);
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
