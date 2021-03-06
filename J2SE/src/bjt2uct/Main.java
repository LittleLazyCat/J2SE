package bjt2uct;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in =new Scanner(System.in);
		try
		{
			Integer bjt = in.nextInt();
			int l = bjt.toString().length();
			System.out.println(new Main().b2u(bjt,l));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		in.close();
	}
	
	public int b2u(int t,int l)
	{
		int uct = 0,hour,minute;
		if(l==4)
		{
			hour = t/100;
			minute = t-(hour*100);
			hour -=8;
			uct = hour*100+minute;
		}else if(l==3)
		{
			hour = t/100;
			minute = t-(hour*100);
			if(hour>=8)
			{
				hour -=8;
				uct = hour*100+minute;
			}
			else if(hour <8)
			{
				hour = hour-8 +24;
				uct = hour*100+minute;
			}
		}else if(l<=2)
		{
			uct = 1600+t;
		}
		return uct;
	}

}
