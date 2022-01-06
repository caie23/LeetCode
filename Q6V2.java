package leetCode;

import java.util.ArrayList;
import java.util.List;

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

public class Q6V2 {
	// 官方题解
	public static String convert(String s, int numRows) {
		if (numRows == 1)
			return s;

		List<StringBuilder> rows = new ArrayList<>();
		for (int i = 0; i < Math.min(numRows, s.length()); i++)
			rows.add(new StringBuilder());

		int curRow = 0;
		boolean goingDown = false;

		for (char c : s.toCharArray()) {
			rows.get(curRow).append(c);
			if (curRow == 0 || curRow == numRows - 1)
				goingDown = !goingDown;
			curRow += goingDown ? 1 : -1;
		}

		StringBuilder result = new StringBuilder();
		for (StringBuilder row : rows)
			result.append(row);

		return result.toString();
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
