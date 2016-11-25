package decompositionqualityfactor;

//��Ŀ���ݣ�
//ÿ����������������������д�ɼ���������Ҳ�ɳ�Ϊ��������˵���ʽ���⼸�������Ͷ�������������������������磬6���Ա��ֽ�Ϊ2x3����24���Ա��ֽ�Ϊ2x2x2x3��
//���ڣ���ĳ���Ҫ����һ��[2,100000]��Χ�ڵ�������Ȼ����������������ֽ�ʽ���������ľ�������ʱ�������������
//
//�����ʽ:
//һ����������Χ��[2,100000]�ڡ�
//
//�����ʽ��
//���磺
//n=axbxcxd
//��
//n=n
//���еķ���֮�䶼û�пո�x��Сд��ĸx��
//
//����������
//18
//
//���������
//18=2x3x3

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {

	// �ж�һ�����Ƿ�Ϊ����
	public boolean isPrime(int num) {
		boolean flag = true;
		if (num != 2 && num != 1) {
			for (int i = 2; i <= (num / 2); i++) {
				if (num % i == 0) {// �������Ϊ0����˵��������������
					flag = false;
				}
			}
		}

		return flag;
	}

	// �õ�������С�Ĺ�Լ��
	public int getPrime(int num) {
		int result = 2;
		if (num != 2) {
			for (int i = 2; i <= (num / 2); i++) {
				if (num % i == 0) {// �õ���С���Ǹ���������������
					result = i;
					break;
				}
			}
		}
		return result;
	}

	// �ֽ�������
	public String getResult(int num) {
		Main m = new Main();
		List<Integer> list = new ArrayList<Integer>();
		int tmp;
		int tmp2 = num;
		if (m.isPrime(num)) {
			return Integer.toString(num);
		} else {
			while (!m.isPrime(num)) {
				tmp = m.getPrime(num);
				list.add(tmp);
				num = num / tmp;
			}
		}
		Iterator<Integer> it = list.iterator();
		String result = "";
		int tmp3;
		while (it.hasNext()) {
			tmp3 = it.next();
			result += Integer.toString(tmp3) + "x";//�����������������
			tmp2 = tmp2 / tmp3;
		}
		return result + Integer.toString(tmp2);//���������һ������
	}

	public static void main(String[] args) {
		// ��������
		// for(int i=2;i<20;i++)
		// {
		// System.out.println(i+"="+new Main().getResult(i));
		// }

		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		System.out.println(num + "=" + new Main().getResult(num));
		in.close();
	}

}