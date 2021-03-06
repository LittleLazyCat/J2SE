package decompositionqualityfactor;

//题目内容：
//每个非素数（合数）都可以写成几个素数（也可称为质数）相乘的形式，这几个素数就都叫做这个合数的质因数。比如，6可以被分解为2x3，而24可以被分解为2x2x2x3。
//现在，你的程序要读入一个[2,100000]范围内的整数，然后输出它的质因数分解式；当读到的就是素数时，输出它本身。
//
//输入格式:
//一个整数，范围在[2,100000]内。
//
//输出格式：
//形如：
//n=axbxcxd
//或
//n=n
//所有的符号之间都没有空格，x是小写字母x。
//
//输入样例：
//18
//
//输出样例：
//18=2x3x3

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {

	// 判断一个数是否为素数
	public boolean isPrime(int num) {
		boolean flag = true;
		if (num != 2 && num != 1) {
			for (int i = 2; i <= (num / 2); i++) {
				if (num % i == 0) {// 如果求余为0，则说明该数不是素数
					flag = false;
				}
			}
		}

		return flag;
	}

	// 得到该数最小的公约数
	public int getPrime(int num) {
		int result = 2;
		if (num != 2) {
			for (int i = 2; i <= (num / 2); i++) {
				if (num % i == 0) {// 得到最小的那个能整除该数的数
					result = i;
					break;
				}
			}
		}
		return result;
	}

	// 分解质因数
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
			result += Integer.toString(tmp3) + "x";//将各个素数组合起来
			tmp2 = tmp2 / tmp3;
		}
		return result + Integer.toString(tmp2);//添加上最后一个素数
	}

	public static void main(String[] args) {
		// 用来测试
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
