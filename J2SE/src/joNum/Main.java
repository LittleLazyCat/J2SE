package joNum;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in =new Scanner(System.in);
		List<Integer> list = new ArrayList<Integer>();
		int i=in.nextInt();
		while(i!=-1)
		{
			list.add(i);
			i=in.nextInt();
		}
		in.close();
		Main n =new Main();
		System.out.println(n.oddNum(list)+" "+n.evenNum(list));
	}
	//求奇数个数
	public int oddNum(List<Integer> l)
	{
		int num = 0;
		Iterator<Integer> i =l.iterator();
		while(i.hasNext())
		{
			if(i.next()%2!=0)
			{
				num++;
			}
		}
		return num;
	}
	//求偶数个数
	public int evenNum(List<Integer> l)
	{
		int num = 0;
		Iterator<Integer> i =l.iterator();
		while(i.hasNext())
		{
			if(i.next()%2==0)
			{
				num++;
			}
		}
		return num;
	}
}
