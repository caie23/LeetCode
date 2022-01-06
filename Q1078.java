package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 示例 1：
 * 输入：text = "alice is a good girl she is a good student", first = "a", second = "good"
 * 输出：["girl","student"]
 * 
 * 示例 2：
 * 输入：text = "we will we will rock you", first = "we", second = "will"
 * 输出：["we","rock"]
 * */

public class Q1078 {
	public static String[] findOcurrences(String text, String first, String second) {
		String[] words = text.split(" ");
		List<String> list = new ArrayList<>();

		for (int i = 0; i + 2 < words.length; i++) {
			if (words[i].equals(first) && words[i + 1].equals(second))
				list.add(words[i + 2]);
		}

		String[] result = new String[list.size()];
		for (int i = 0; i < list.size(); i++) {
			result[i] = list.get(i);
		}
		// 注意用stream可能会降低速度
//		String[] result = list.stream().toArray(String[]::new);
		return result;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(findOcurrences("alice is a good girl she is a good student", "a", "good")));
		System.out.println(Arrays.toString(findOcurrences("we will we will rock yo", "we", "will")));
		System.out.println(Arrays.toString(findOcurrences(
				"jkypmsxd jkypmsxd kcyxdfnoa jkypmsxd kcyxdfnoa jkypmsxd kcyxdfnoa kcyxdfnoa jkypmsxd kcyxdfnoa",
				"kcyxdfnoa", "jkypmsxd")));
	}
}
