package numcharacteristicvalue;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String num =in.nextLine();
		char[] c = num.toCharArray();
		int count =0;
		
		for(int i=0;i<c.length;i++)
		{
			Character cr = c[(c.length-1-i)];
			Integer j = Integer.parseInt(cr.toString());
			if((i+1)%2!=0)
			{
				if(j%2!=0)
				{
					count+=Math.pow(2, i);
				}
			}
			else
			{
				if(j%2==0)
				{
					count+=Math.pow(2, i);
				}
			}
		}
		System.out.println(count);
		in.close();
		
	}

}
