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

public class Q12V2 {
	public static String intToRoman(int num) {
		// 官方题解2：硬编码，时间较长
		// 枚举每一位各个数字（0～9）的罗马数字，根据每一位的具体数字在表中查找，然后拼接
		String[] THOUSANDS = { "", "M", "MM", "MMM" };
		String[] HUNDREDS = { "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" };
		String[] TENS = { "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" };
		String[] ONES = { "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" };

		int thousand = num / 1000; // 千位数
		int hundred = num % 1000 / 100; // 百位数
		int ten = num % 100 / 10; // 十位数
		int one = num % 10; // 个位数

		// 注意用StringBuilder的append比用+快很多
		StringBuilder result = new StringBuilder();
		result.append(THOUSANDS[thousand]).append(HUNDREDS[hundred]).append(TENS[ten]).append(ONES[one]);
		return result.toString();
//		return THOUSANDS[thousand] + HUNDREDS[hundred] + TENS[ten] + ONES[one];
	}

	public static void main(String[] args) {
		System.out.println(intToRoman(3)); // "III"
		System.out.println(intToRoman(4)); // "IV"
		System.out.println(intToRoman(9)); // "IX"
		System.out.println(intToRoman(10)); // "X"
		System.out.println(intToRoman(58)); // "LVIII" (L = 50, V = 5, III = 3)
		System.out.println(intToRoman(1994)); // "MCMXCIV" (M = 1000, CM = 900, XC = 90, IV = 4)
		System.out.println(intToRoman(3999)); // "MMMCMXCIX"
	}
}
