package test;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
//		Scanner in =new Scanner(System.in);
//		String s=in.nextLine();
//		String[] array=s.split(" ");
//		for(int i=0;i<array.length-1;i++)
//		{
//			if(!"".equals(array[i]))
//			System.out.print(array[i].length()+" ");
//
//		}
//		in.close();
//		System.out.print(array[array.length-1].length()-1);
			Scanner in = new Scanner(System.in);
			int a = in.nextInt();
			int b = in.nextInt();
			int max =0;
			if(a>b)
				max=a;
			if (b>a) 
				max=b;
			System.out.print(max);
		in.close();
	}

}
