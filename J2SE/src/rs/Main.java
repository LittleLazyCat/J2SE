package rs;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in =new Scanner(System.in);
		try
		{
			int i = in.nextInt();
			System.out.println(new Main().rs(i));
			
		}catch(Exception e){
			
			e.printStackTrace();
		}
		in.close();
	}
	public String rs(int i)
	{
		int first,end;
		first = i/10-1;
		end = i%10-1;
		String[] r ={"unreadable.","barely readable, occasional words distinguishable.","readable with considerable difficulty.","readable with practically no difficulty.","perfectly readable."};
		String[] s ={"Faint signals, barely perceptible, ","Very weak signals, ","Weak signals, ","Fair signals, ","Fairly good signals, ","Good signals, ","Moderately strong signals, ","Strong signals, ","Extremely strong signals, "};
		
		return s[end]+r[first];
	}

}
