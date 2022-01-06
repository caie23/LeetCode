package leetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/* 示例 1：
 * 输入：s = "PAYPALISHIRING", numRows = 3
 * 输出："PAHNAPLSIIGYIR"
 * 解释：
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 
 * 示例 2：
 * 输入：s = "PAYPALISHIRING", numRows = 4
 * 输出："PINALSIGYAHRPI"
 * 解释：
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * 
 * 示例 3：
 * 输入：s = "A", numRows = 1
 * 输出："A"
 * */

public class Q6V1 {
	// 智障题解
	public static String convert(String s, int numRows) {
		int len = s.length();
		if (numRows == 1 || numRows >= len)
			return s;

		List<String> indices = new ArrayList<>();
		int cyc = 2 * (numRows - 1);

		for (int k = 0; k < numRows; k++) {
			// k-th row
			int i = k;
			indices.add(Character.toString(s.charAt(i)));
			int inc1 = cyc - 2 * k;
			int inc2 = 2 * k;
			while (i + inc1 < len) {
				i += inc1;
				if (inc1 != 0)
					indices.add(Character.toString(s.charAt(i)));

				if (!(i + inc2 < len))
					break;
				i += inc2;
				if (inc2 != 0)
					indices.add(Character.toString(s.charAt(i)));
			}
		}

		return indices.stream().collect(Collectors.joining());
	}

	public static void main(String[] args) {
		System.out.println(convert("PAYPALISHIRING", 3)); // PAHNAPLSIIGYIR
		System.out.println(convert("PAYPALISHIRING", 4)); // PINALSIGYAHRPI
		System.out.println(convert("A", 1)); // A
		System.out.println(convert("AB", 1)); // AB
		System.out.println(convert("AB", 2)); // AB
		System.out.println(convert("PAYPAL", 3)); // PAAPLY
		System.out.println(convert("PAYPAL", 4)); // PALYAP
	}
}
