package leetCode;

import java.util.HashMap;
import java.util.Map;

/* 罗马数字转整数
 * 
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 
 * */

public class Q13V1 {
	public static int romanToInt(String s) {
		// create map
		int[] number = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
		String[] roman = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < number.length; i++)
			map.put(roman[i], number[i]);

		int result = 0;
		int i = 0;
		while (i < s.length()) {
			if (i + 1 < s.length() && map.containsKey(s.substring(i, i + 2))) {
				result += map.get(s.substring(i, i + 2));
				i += 2;
			} else {
				result += map.get(s.substring(i, i + 1));
				i++;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(romanToInt("III")); // 3
		System.out.println(romanToInt("IV")); // 4
		System.out.println(romanToInt("IX")); // 9
		System.out.println(romanToInt("LVIII")); // 58
		System.out.println(romanToInt("MCMXCIV")); // 1994
	}
}
