package readnum;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;



public class Main {

	public String getReadNum(Integer n)
	{
		String num = n.toString();
		char[] c =num.toCharArray();
		num = "";
		Map<String,String> sp = new HashMap<String,String>();
		sp.put("-","fu ");
		sp.put("0","ling ");
		sp.put("1", "yi ");
		sp.put("2", "er ");
		sp.put("3", "san ");
		sp.put("4", "si ");
		sp.put("5", "wu ");
		sp.put("6", "liu ");
		sp.put("7", "qi ");
		sp.put("8", "ba ");
		sp.put("9", "jiu ");
		for(int i =0;i<c.length;i++)
		{
			Character cr = c[i];
			num +=sp.get(cr.toString());
		}
		
		return num.trim();//ȥ��ĩβ�Ŀո�
	}
	public static void main(String[] args) {
		
		Scanner in =new Scanner(System.in);
		System.out.println(new Main().getReadNum(in.nextInt()));
		in.close();
	}

}
