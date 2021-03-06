package additionofpolynomial;
//多项式加法

/*
* 输入样例：
6 2
5 3
3 12
1 6
0 20
6 2
5 3
2 12
1 6
0 20

输出样例：
4x6+6x5+12x3+12x2+12x+40
*/

import java.util.Iterator;
import java.util.Map;
import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {

	public String getDjf(Map<Integer, Integer> t) {
		// 第一种方法
		// 使用entrySet()方法生成一个由Map.entry对象组成的Set,
		// 而Map.entry对象包括了每个元素的"键"和"值".这样就可以用iterator了
		Iterator it = t.entrySet().iterator();
		String s2 = new String();
		while (it.hasNext()) {
			// entry的输出结果如key0=value0等
			Map.Entry entry = (Map.Entry) it.next();
			Integer key = (Integer) entry.getKey();// 获得幂
			Integer value = (Integer) entry.getValue();// 获得系数
			// 判断幂是不是为0，如果为0，则该项是常数项
			if (!"0".equals(key.toString())) {
				// 判断系数是否为负数和式子长度，如果为负数并且式子长度大于1，则需要去掉式子中最后一个加号
				if (value < 0 && s2.length() > 1) {
					s2 = s2.substring(0, s2.length() - 1);

				}
				// 如果系数不为0且幂不为1
				if (!"0".equals(value.toString()) && !"1".equals(key.toString())) {
					if ("1".equals(value.toString())) {
						s2 += ("x" + key.toString() + "+");
					} else {
						s2 += (value.toString() + "x" + key.toString() + "+");
					}

				} // 如果幂为1
				else if ("1".equals(key.toString())) {
					// 如果系数为1
					if ("1".equals(value.toString())) {
						s2 += ("x" + "+");
					} else {
						s2 += (value.toString() + "x" + "+");
					}

				}

			} // 以下是幂为0，常数项
			else {

				if (value < 0) {
					s2 = s2.substring(0, s2.length() - 1);
				}
				s2 += value.toString();
			}
			// 输出键值对
			// System.out.println(entry);
			// System.out.println(key);
			// System.out.println(value);

		}
		return s2;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int count = 2;
		// 下面这个TreeMap实现了降序排列
		Map<Integer, Integer> tree = new TreeMap<Integer, Integer>(new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});
		int first = 0, second = 0;
		String[] s;
		tree.put(0, 0);
		while (count > 0) {
			s = in.nextLine().split(" ");
			// 判断一行上是一个数字还是两个数字
			if (s.length == 2) {
				first = Integer.parseInt(s[0]);
				if (first == 0) {
					count--;
				}

				second = Integer.parseInt(s[1]);

			} else {
				first = Integer.parseInt(s[0]);
				if (first == 0) {
					count--;
				}
				second = 0;
			}
			// 判断该次幂是否已经出现过，若出现过则提取出系数，并求和
			if (tree.containsKey(first)) {
				second += tree.get(first);
			}
			// 放入TreeMap中
			tree.put(first, second);

		}
		in.close();
		System.out.println(new Main().getDjf(tree));
	}

}
