package gpsdata;

import java.util.Scanner;

public class Main {

	
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		String s;		//保存读取到的GPS数据
		char c, d;		//c为异或的前一个，d为异或的后一个
		int hour = 0, minute = 0, second = 0;
		
		do {
			s = in.nextLine();
			//判断读入数据是否以$GPRMC开头
			if (s.startsWith("$GPRMC")) {
				
				int index = 2;
				c = s.charAt(1);
				while (s.charAt(index) != '*') {
					d = s.charAt(index++);	//首先index=2，取出数据后index++
					c ^= d;		//char类型可以自动转换为int型
				}
				int tem = Integer.parseInt(s.substring(s.indexOf('*') + 1), 16);//将最后的数转换为16进制的数
				// System.out.println(s.substring(s.indexOf('*')+1));
				// System.out.println(tem);
				// System.out.println(((int)c)%65536);
				//判断该数与之前计算所得结果是否相等
				if (tem == ((int) c) % 65536) {
					char status;
					String subs1, subs2;
					subs1 = s.substring(s.indexOf(',') + 1);
					subs2 = subs1.substring(subs1.indexOf(',') + 1);
					status = subs2.charAt(0);
					if (status == 'A') {
						//将UTC时间转换成BJT时间
						//取得UTC时间
						int  UTC;
						UTC = Integer.parseInt(subs1.substring(0, subs1.indexOf('.')));
						hour = UTC / 10000;
						UTC %= 10000;
						minute = UTC / 100;
						second = UTC % 100;
						hour = hour + 8;
						if (hour > 24) {
							hour -= 24;
						}
//						int BJT = second + minute * 100 + hour * 10000;
					}
				}
			}
		} while (!"END".equals(s));
		if (hour > 9) {
			System.out.print(hour + ":");
		} else {
			System.out.print("0" + hour + ":");
		}
		if (minute > 9) {
			System.out.print(minute + ":");
		} else {
			System.out.print("0" + minute + ":");
		}
		if (second > 9) {
			System.out.print(second);
		} else {
			System.out.print("0" + second);
		}
		in.close();
		System.out.println();
	}
}
