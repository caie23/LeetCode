package leetCode;

import java.util.ArrayList;
import java.util.List;

/* 示例 1:
 * 输入: s = "abcabcbb"
 * 输出: 3 
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 
 * 示例 2:
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 
 * 示例 3:
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
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
 * 输入：s = "dvdf"
 * 输出：3 
 * */

public class Q3V1 {
	public static int lengthOfLongestSubstring(String s) {
		if (s.equals(""))
			return 0;

		List<Integer> alllength = new ArrayList<>();

		String current = "";
		for (int i = 0; i < s.length(); i++) {
			if (current.indexOf(s.charAt(i)) < 0) {
				// character is not in the substring
				current += s.charAt(i);
			} else {
				// repeat character in substring
				alllength.add(current.length());
				if (current.indexOf(s.charAt(i)) == current.length() - 1)
					current = "";
				else
					current = current.substring(current.indexOf(s.charAt(i)) + 1, current.length());
				// NOTE the endIndex of substring() is exclusive
				current += s.charAt(i);
			}
		}
		alllength.add(current.length());

		return alllength.stream().mapToInt(Integer::intValue).max().getAsInt();
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
