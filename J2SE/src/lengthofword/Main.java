package lengthofword;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		String s=new Scanner(System.in).nextLine();
		String[] array=s.split(" ");
		for(int i=0;i<array.length-1;i++)
		{
			if(!"".equals(array[i]))
			System.out.print(array[i].length()+" ");

		}
		
		System.out.print(array[array.length-1].length()-1);
	}

}

