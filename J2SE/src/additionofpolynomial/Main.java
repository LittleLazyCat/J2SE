package additionofpolynomial;
//����ʽ�ӷ�

/*
* ����������
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

���������
4x6+6x5+12x3+12x2+12x+40
*/

import java.util.Iterator;
import java.util.Map;
import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {

	public String getDjf(Map<Integer, Integer> t) {
		// ��һ�ַ���
		// ʹ��entrySet()��������һ����Map.entry������ɵ�Set,
		// ��Map.entry���������ÿ��Ԫ�ص�"��"��"ֵ".�����Ϳ�����iterator��
		Iterator it = t.entrySet().iterator();
		String s2 = new String();
		while (it.hasNext()) {
			// entry����������key0=value0��
			Map.Entry entry = (Map.Entry) it.next();
			Integer key = (Integer) entry.getKey();// �����
			Integer value = (Integer) entry.getValue();// ���ϵ��
			// �ж����ǲ���Ϊ0�����Ϊ0��������ǳ�����
			if (!"0".equals(key.toString())) {
				// �ж�ϵ���Ƿ�Ϊ������ʽ�ӳ��ȣ����Ϊ��������ʽ�ӳ��ȴ���1������Ҫȥ��ʽ�������һ���Ӻ�
				if (value < 0 && s2.length() > 1) {
					s2 = s2.substring(0, s2.length() - 1);

				}
				// ���ϵ����Ϊ0���ݲ�Ϊ1
				if (!"0".equals(value.toString()) && !"1".equals(key.toString())) {
					if ("1".equals(value.toString())) {
						s2 += ("x" + key.toString() + "+");
					} else {
						s2 += (value.toString() + "x" + key.toString() + "+");
					}

				} // �����Ϊ1
				else if ("1".equals(key.toString())) {
					// ���ϵ��Ϊ1
					if ("1".equals(value.toString())) {
						s2 += ("x" + "+");
					} else {
						s2 += (value.toString() + "x" + "+");
					}

				}

			} // ��������Ϊ0��������
			else {

				if (value < 0) {
					s2 = s2.substring(0, s2.length() - 1);
				}
				s2 += value.toString();
			}
			// �����ֵ��
			// System.out.println(entry);
			// System.out.println(key);
			// System.out.println(value);

		}
		return s2;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int count = 2;
		// �������TreeMapʵ���˽�������
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
			// �ж�һ������һ�����ֻ�����������
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
			// �жϸô����Ƿ��Ѿ����ֹ��������ֹ�����ȡ��ϵ���������
			if (tree.containsKey(first)) {
				second += tree.get(first);
			}
			// ����TreeMap��
			tree.put(first, second);

		}
		in.close();
		System.out.println(new Main().getDjf(tree));
	}

}