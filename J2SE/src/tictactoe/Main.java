package tictactoe;

import java.util.Scanner;

public class Main {
	public String getWiner(int[][] q) {
		int numofX = 0; // ͳ��1�ĸ���
		int numofO = 0; // ͳ��0�ĸ���
		boolean flag = true; // �����ж��Ƿ��Ѿ����˻�ʤ

		// �ж�������û���˻�ʤ
		for (int i = 0; i < q.length; i++) {
			for (int j = 0; j < q.length; j++) {
				if (q[i][j] == 1) {
					numofX++;
				} else {
					numofO++;
				}
			}
			if (numofX == q.length || numofO == q.length) {
				flag = false;
				break;
			} else {
				numofX = 0;
				numofO = 0;
			}
		}
		if (flag) { // ����û�м����ж�������û���˻�ʤ
			numofX = 0;
			numofO = 0;
			for (int i = 0; i < q.length; i++) {
				for (int j = 0; j < q.length; j++) {
					if (q[j][i] == 1) {
						numofX++;
					} else {
						numofO++;
					}
				}
				if (numofX == q.length || numofO == q.length) {
					flag = false;
					break;
				} else {
					numofX = 0;
					numofO = 0;
				}
			}
		}
		if (flag) { // �����ж�û���˻�ʤ����һ���ж϶Խ�������û���˻�ʤ
			numofX = 0;
			numofO = 0;
			for (int i = 0; i < q.length; i++) {
				if (q[i][i] == 1) {
					numofX++;
				} else {
					numofO++;
				}
			}
			if (numofX == q.length || numofO == q.length) {
				flag = false;
			}
		}
		if (flag) { // �У����Լ��Խ��߶�û���˻�ʤ����һ���жϷ��Խ�������û���˻�ʤ
			numofX = 0;
			numofO = 0;
			for (int i = 0; i < q.length; i++) {
				if (q[i][q.length - 1 - i] == 1) {
					numofX++;
				} else {
					numofO++;
				}
			}

		}
		if (numofX == q.length) {
			return "X";
		} else if (numofO == q.length) {
			return "O";
		} else {

			return "NIL";
		}

	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = Integer.parseInt(in.nextLine());
		int[][] jzq = new int[n][n];		//��һ��n*n������
		int i = 0;
		String line;		//line���ڻ��ÿһ������ 
		while (i != jzq.length) {

			line = in.nextLine();
			String[] qz = line.split(" ");

			for (int j = 0; j < jzq.length; j++) {
				jzq[i][j] = Integer.parseInt(qz[j]);		//������������
			}

			i++;

		}

		in.close();
		System.out.println(new Main().getWiner(jzq));
	}

}
