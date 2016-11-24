package gpsdata;

import java.util.Scanner;

public class Main {

	// public String[] getBJT(String[] s)
	// {
	//
	// }
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		String s;
		char c, d;
		int hour = 0, minute = 0, second = 0;
		int BJT, UTC;
		do {
			s = in.nextLine();
			if (s.startsWith("$GPRMC")) {
				// System.out.println(123);
				int index = 2;
				c = s.charAt(1);
				while (s.charAt(index) != '*') {
					d = s.charAt(index++);
					c ^= d;
				}
				int tem = Integer.parseInt(s.substring(s.indexOf('*') + 1), 16);
				// System.out.println(s.substring(s.indexOf('*')+1));
				// System.out.println(tem);
				// System.out.println(((int)c)%65536);
				if (tem == ((int) c) % 65536) {
					char status;
					String subs1, subs2;
					subs1 = s.substring(s.indexOf(',') + 1);
					subs2 = subs1.substring(subs1.indexOf(',') + 1);
					status = subs2.charAt(0);
					if (status == 'A') {
						UTC = Integer.parseInt(subs1.substring(0, subs1.indexOf('.')));
						hour = UTC / 10000;
						UTC %= 10000;
						minute = UTC / 100;
						second = UTC % 100;
						hour = hour + 8;
						if (hour > 24) {
							hour -= 24;
						}
						BJT = second + minute * 100 + hour * 10000;
					}
				}
			}
		} while (!s.equals("END"));
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
		System.out.println();
	}
}
