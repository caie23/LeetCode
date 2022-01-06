package leetCode;

/* 整数转罗马数字 
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

public class Q12V3 {
	public static String intToRoman(int num) {
		// 官方题解1：模拟手算
		int[] number = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
		String[] roman = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

		StringBuilder result = new StringBuilder();

		for (int i = 0; i < number.length; i++) {
			while (num >= number[i]) {
				result.append(roman[i]);
				num -= number[i];
			}
		}

		return result.toString();
	}

	public static void main(String[] args) {
		System.out.println(intToRoman(3)); // "III"
		System.out.println(intToRoman(4)); // "IV"
		System.out.println(intToRoman(9)); // "IX"
		System.out.println(intToRoman(10)); // "X"
		System.out.println(intToRoman(58)); // "LVIII" (L = 50, V = 5, III = 3)
		System.out.println(intToRoman(400)); // "CD"
		System.out.println(intToRoman(1994)); // "MCMXCIV" (M = 1000, CM = 900, XC = 90, IV = 4)
		System.out.println(intToRoman(3999)); // "MMMCMXCIX"
	}
}
