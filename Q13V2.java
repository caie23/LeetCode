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

public class Q13V2 {
	public static int romanToInt(String s) {
		// 官方题解：模拟
		Map<Character, Integer> map = new HashMap<Character, Integer>() {
			{
				put('I', 1);
				put('V', 5);
				put('X', 10);
				put('L', 50);
				put('C', 100);
				put('D', 500);
				put('M', 1000);
			}
		};

		int len = s.length();
		int result = 0;
		for (int i = 0; i < len; i++) {
			if (i + 1 < len && map.get(s.charAt(i)) < map.get(s.charAt(i + 1)))
				result -= map.get(s.charAt(i));
			else
				result += map.get(s.charAt(i));
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
