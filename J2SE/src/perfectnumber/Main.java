package perfectnumber;

//��Ŀ���ݣ�

//һ�������������������п���������������������һ�������ǡ�õ��ڳ��������������֮�ͣ�������ͳ�Ϊ����������6=1��2��3(6��������1,2,3)��
//
//���ڣ���Ҫдһ�����򣬶�������������n��m��1<=n<m<1000�������[n,m]��Χ�����е�������
//
//��ʾ������дһ���������ж�ĳ�����Ƿ���������
//
//�����ʽ:
//�������������Կո�ָ���
//
//�����ʽ��
//������е��������Կո�ָ������һ�����ֺ���û�пո����û�У������NIL��������д��ĸ����
//
//����������
//1 10
//
//���������
//6
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {
	//�жϸ����Ƿ�Ϊ����
	public boolean isPerfectNum(int num) {
		boolean flag = false;
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 2; i <= num; i++) {
			if (num % i == 0) {
				list.add(i);//ȡ��ÿһ����������������
			}
		}
		int sum = 1;
		Iterator<Integer> it = list.iterator();
		while (it.hasNext()) {
			sum += it.next();
		}
		if (sum == (2 * num)) {
			flag = true;
		}
		return flag;
	}
	//���÷�Χ�ڵ�����ƴ����������
	public String getResult(List<Integer> list) {
		Iterator<Integer> it = list.iterator();
		String result = "";

		while (it.hasNext()) {
			result += Integer.toString(it.next()) + " ";
		}

		return result.trim();

	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String[] s = in.nextLine().split(" ");
		boolean flag = false;
		List<Integer> list = new ArrayList<Integer>();//����������
		int n = Integer.parseInt(s[0]), m = Integer.parseInt(s[1]);
		Main main = new Main();
		for (; n <= m; n++) {
			if (main.isPerfectNum(n)) {
				list.add(n);
				flag = true;
			}
		}
		String result = "NIL";
		if (flag) {
			
			result = main.getResult(list);

		}
		System.out.println(result);
		in.close();
	}

}