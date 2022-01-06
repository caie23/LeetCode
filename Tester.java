package leetCode;

import java.util.HashMap;
import java.util.Map;

public class Tester {
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>() {
			{
				put("I", 0);
				put("V", 0);
				put("X", 0);
				put("L", 0);
				put("C", 0);
				put("D", 0);
				put("M", 0);
			}
		};
		map.put("I", 1);
		map.put("I", map.get("I") + 1);
		System.out.println(map);
	}
}
