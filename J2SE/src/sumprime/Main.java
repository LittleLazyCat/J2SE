package sumprime;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public int sumPrime(int n,int m)//求素数的和
	{
		Map<Integer,Integer> sp = new HashMap<Integer,Integer>();
		sp.put(1, 2);
		boolean flag;
		int sum = 0,count =2;
		for(int x=3;x<=1500;x++)
		{
			flag = true;
			for(int i=2;i<x;i++)
			{
				if(x%i==0)
				{
					flag = false;
					break;
				}
			}
			if(flag)
			{
				sp.put(count, x);
				count++;
			}
		}
		for(;n<=m;n++)
		{
			sum+=sp.get(n);
		}
		return sum;
	}
	public static void main(String[] args) {
		Scanner in =new Scanner(System.in);
		int first = in.nextInt();//开始的位置
		int second = in.nextInt();//结束的位置
		in.close();
		System.out.println(new Main().sumPrime(first, second));
		
	}

}
