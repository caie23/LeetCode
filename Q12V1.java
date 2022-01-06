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

public class Q12V1 {
	public static StringBuilder build(int digit, StringBuilder result, String one, String five, String ten) {
		if (digit == 9)
			result.append(one).append(ten);
		else if (digit > 4) {
			result.append(five);
			for (int i = 0; i < digit % 5; i++)
				result.append(one);
		} else if (digit == 4)
			result.append(one).append(five);
		else {
			for (int i = 0; i < digit; i++)
				result.append(one);
		}
		return result;
	}

	public static String intToRoman(int num) {
		StringBuilder result = new StringBuilder();

		for (int i = 0; i < num / 1000; i++)
			result.append("M");

		int hundred = num % 1000 / 100;
		result = build(hundred, result, "C", "D", "M");

		int ten = num % 100 / 10;
		result = build(ten, result, "X", "L", "C");

		int one = num % 10;
		result = build(one, result, "I", "V", "X");

		return result.toString();
	}

	public static void main(String[] args) {
		System.out.println(intToRoman(3)); // "III"
		System.out.println(intToRoman(4)); // "IV"
		System.out.println(intToRoman(9)); // "IX"
		System.out.println(intToRoman(58)); // "LVIII" (L = 50, V = 5, III = 3)
		System.out.println(intToRoman(1994)); // "MCMXCIV" (M = 1000, CM = 900, XC = 90, IV = 4)
		System.out.println(intToRoman(3999)); // "MMMCMXCIX"
	}
}
