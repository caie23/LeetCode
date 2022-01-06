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

public class Q3V3 {
	public static int lengthOfLongestSubstring(String s) {

		Set<Character> substr = new HashSet<>();

		int result = 0;
		int currentlength = 0;

		// 双指针，第一个指向substr开始，第二个指向结束
		int i = 0, j = 0;
		while (i < s.length() && j < s.length()) {
			if (!substr.contains(s.charAt(j))) {
				substr.add(s.charAt(j));
				j++;
				currentlength = substr.size();
			} else {
				result = result > currentlength ? result : currentlength;
				substr.remove(s.charAt(i));
				i++;
				currentlength = j - i + 1;
			}
		}
		result = result > currentlength ? result : currentlength;

		return result;
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
