package leetCode;

/* 10. 正则表达式匹配
 * 输入：s = "aa" p = "a"
 * 输出：false
 * 解释："a" 无法匹配 "aa" 整个字符串
 * 
 * 输入：s = "aa" p = "a*"
 * 输出：true
 * 解释：因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 * 
 * 输入：s = "ab" p = ".*"
 * 输出：true
 * 解释：".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 * 
 * 输入：s = "aab" p = "c*a*b"
 * 输出：true
 * 解释：因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
 * 
 * 输入：s = "mississippi" p = "mis*is*p*."
 * 输出：false
 * */

public class Q10 {
	// 官方题解 + 注释
	public static boolean isMatch(String s, String p) {
		int m = s.length();
		int n = p.length();

		// 用二维布尔组可以记录每一步的结果，后一个*可以跳过前一步unmatched的两个字符
		boolean[][] f = new boolean[m + 1][n + 1];
		f[0][0] = true;
		for (int i = 0; i <= m; ++i) { // 遍历字符串
			for (int j = 1; j <= n; ++j) { // 遍历字符规律
				if (p.charAt(j - 1) == '*') { // pattern[j-1] is '*'
					if (matches(s, p, i, j - 1))
						f[i][j] = f[i][j - 2] || f[i - 1][j];
					else
						f[i][j] = f[i][j - 2];
				} else { // pattern[j-1] is not '*' (but can be '.')
					if (matches(s, p, i, j))
						f[i][j] = f[i - 1][j - 1];
				}
			}
		}
		return f[m][n];
	}

	public static boolean matches(String s, String p, int i, int j) {
		if (i == 0)
			return false;
		if (p.charAt(j - 1) == '.')
			return true;
		return s.charAt(i - 1) == p.charAt(j - 1);
	}

	public static void main(String[] args) {
		System.out.println(isMatch("aa", "a")); // false
		System.out.println(isMatch("aa", "a*")); // true
		System.out.println(isMatch("ab", ".*")); // true
		System.out.println(isMatch("aab", "c*a*b")); // true
		System.out.println(isMatch("mississippi", "mis*is*p*.")); // false
	}
}
