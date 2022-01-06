package leetCode;

import java.util.HashMap;
import java.util.Map;

/* 输入：s = "42"
 * 输出：42
 * 
 * 输入：s = "   -42"
 * 输出：-42
 * 
 * 输入：s = "4193 with words"
 * 输出：4193
 * 
 * 输入：s = "words and 987"
 * 输出：0
 * 
 * 输入：s = "-91283472332"
 * 输出：-2147483648 
 * */

public class Q8 {
	// 用if else太复杂，本题需要用到自动机
	// 官方题解
	public static int myAtoi(String s) {
		Automaton automaton = new Automaton();
		int length = s.length();
		for (int i = 0; i < length; ++i) { // i++ works too (?
			automaton.process(s.charAt(i));
		}
		return (int) (automaton.sign * automaton.ans);
	}

	public static void main(String[] args) {
		System.out.println(myAtoi("42")); // 42
		System.out.println(myAtoi("    -42")); // -42
		System.out.println(myAtoi("4193 with words")); // 4193
		System.out.println(myAtoi("words and 987")); // 0
		System.out.println(myAtoi("-91283472332")); // -2147483648
		System.out.println(myAtoi("+1")); // 1
		System.out.println(myAtoi("+-12")); // 0
	}
}

class Automaton {
	public int sign = 1; // 若无符号默认为正
	public long ans = 0;
	private String state = "start"; // 初始状态
	private Map<String, String[]> table = new HashMap<String, String[]>() {
		{ // 存储所有状态
			put("start", new String[] { "start", "signed", "in_number", "end" });
			put("signed", new String[] { "end", "end", "in_number", "end" });
			put("in_number", new String[] { "end", "end", "in_number", "end" });
			put("end", new String[] { "end", "end", "end", "end" });
		}
	};

	public void process(char c) {
		// 根据当前状态和当前字符更新状态
		state = table.get(state)[get_col(c)];
		if ("in_number".equals(state)) { // 每读取一个数字字符，更新结果
			ans = ans * 10 + c - '0'; // 利用ascii差值得到数字字符的数值
			ans = sign == 1 ? Math.min(ans, (long) Integer.MAX_VALUE) : Math.min(ans, -(long) Integer.MIN_VALUE);
			// result为最终结果的绝对值，根据sign决定result最大为2^31还是2^31-1
		} else if ("signed".equals(state)) { // 更新符号
			sign = c == '+' ? 1 : -1;
		}
	}

	private int get_col(char c) {
		if (c == ' ')
			return 0;
		if (c == '+' || c == '-')
			return 1;
		if (Character.isDigit(c))
			return 2;
		return 3;
	}
}
