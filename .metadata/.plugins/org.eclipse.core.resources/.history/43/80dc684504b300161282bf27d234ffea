package fahrenheit2centigrade;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in =new Scanner(System.in);
		try
		{
			int F = in.nextInt();
			int C =(int)((F-32)/(9/5.0));
			System.out.println(C);
			
		}
		catch (InputMismatchException ie) {
			System.out.println("请输入一个整数！");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
