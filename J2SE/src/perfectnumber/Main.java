package perfectnumber;

//题目内容：

//一个正整数的因子是所有可以整除它的正整数。而一个数如果恰好等于除它本身外的因子之和，这个数就称为完数。例如6=1＋2＋3(6的因子是1,2,3)。
//
//现在，你要写一个程序，读入两个正整数n和m（1<=n<m<1000），输出[n,m]范围内所有的完数。
//
//提示：可以写一个函数来判断某个数是否是完数。
//
//输入格式:
//两个正整数，以空格分隔。
//
//输出格式：
//其间所有的完数，以空格分隔，最后一个数字后面没有空格。如果没有，则输出NIL（三个大写字母）。
//
//输入样例：
//1 10
//
//输出样例：
//6
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {
	//判断该数是否为完数
	public boolean isPerfectNum(int num) {
		boolean flag = false;
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 2; i <= num; i++) {
			if (num % i == 0) {
				list.add(i);//取得每一个能整除该数的数
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
	//将该范围内的完数拼接起来返回
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
		List<Integer> list = new ArrayList<Integer>();//用来存完数
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
