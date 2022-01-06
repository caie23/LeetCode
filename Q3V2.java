package leetCode;

import java.util.HashSet;
import java.util.Set;

/* 示例 1:
 * 输入: s = "abcabcbb"
 * 输出: 3 "abcdabcde" "aabb"
 * 
 * 示例 2:
 * 输入: s = "bbbbb"
 * 输出: 1
 * 
 * 示例 3:
 * 输入: s = "pwwkew"
 * 输出: 3
 * 
 * 示例 4:
 * 输入: s = ""
 * 输出: 0 
 * 
 * 示例 5:
 * 输入: s = " "
 * 输出: 1
 * 
 * 示例 6:
 * 输入: s = "dvdf"
 * 输出: 3
 * */

public class Q3V2 {
	// 官方题解，没怎么看懂
	public static int lengthOfLongestSubstring(String s) {
		// 哈希集合，记录每个字符是否出现过
		Set<Character> occ = new HashSet<Character>();
		int n = s.length();
		// 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
		int rk = -1, ans = 0;
		for (int i = 0; i < n; ++i) {
			if (i != 0) {
				// 左指针向右移动一格，移除一个字符
				occ.remove(s.charAt(i - 1));
			}
			while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
				// 不断地移动右指针
				occ.add(s.charAt(rk + 1));
				++rk;
			}
			// 第 i 到 rk 个字符是一个极长的无重复字符子串
			ans = Math.max(ans, rk - i + 1);
		}
		return ans;
	}

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("abcabcbb"));
		System.out.println(lengthOfLongestSubstring("bbbbb"));
		System.out.println(lengthOfLongestSubstring("pwwkew"));
		System.out.println(lengthOfLongestSubstring(""));
		System.out.println(lengthOfLongestSubstring(" "));
		System.out.println(lengthOfLongestSubstring("dvdf"));
	}
}
