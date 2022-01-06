package leetCode;

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

public class Q13V4 {
	// 评论区秀儿写法
	public static int romanToInt(String s) {
		s = s.replace("IV", "a");
		s = s.replace("IX", "b");
		s = s.replace("XL", "c");
		s = s.replace("XC", "d");
		s = s.replace("CD", "e");
		s = s.replace("CM", "f");

		int result = 0;
		for (int i = 0; i < s.length(); i++) {
			result += which(s.charAt(i));
		}
		return result;
	}

	public static int which(char ch) {
		switch (ch) {
		case 'I':
			return 1;
		case 'V':
			return 5;
		case 'X':
			return 10;
		case 'L':
			return 50;
		case 'C':
			return 100;
		case 'D':
			return 500;
		case 'M':
			return 1000;
		case 'a':
			return 4;
		case 'b':
			return 9;
		case 'c':
			return 40;
		case 'd':
			return 90;
		case 'e':
			return 400;
		case 'f':
			return 900;
		}
		return 0;
	}

	public static void main(String[] args) {
		System.out.println(romanToInt("III")); // 3
		System.out.println(romanToInt("IV")); // 4
		System.out.println(romanToInt("IX")); // 9
		System.out.println(romanToInt("LVIII")); // 58
		System.out.println(romanToInt("MCMXCIV")); // 1994
	}
}
