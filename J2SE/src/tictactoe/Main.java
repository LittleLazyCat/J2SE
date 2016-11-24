package tictactoe;

import java.util.Scanner;

public class Main {
	public String getWiner(int[][] q) {
		int numofX = 0; // 统计1的个数
		int numofO = 0; // 统计0的个数
		boolean flag = true; // 用于判断是否已经有人获胜

		// 判断行上有没有人获胜
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
		if (flag) { // 行上没有继续判断列上有没有人获胜
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
		if (flag) { // 行与列都没有人获胜，进一步判断对角线上有没有人获胜
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
		if (flag) { // 行，列以及对角线都没有人获胜，进一步判断反对角线上有没有人获胜
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
		int[][] jzq = new int[n][n];		//建一个n*n的棋盘
		int i = 0;
		String line;		//line用于获得每一行输入 
		while (i != jzq.length) {

			line = in.nextLine();
			String[] qz = line.split(" ");

			for (int j = 0; j < jzq.length; j++) {
				jzq[i][j] = Integer.parseInt(qz[j]);		//按个放入数组
			}

			i++;

		}

		in.close();
		System.out.println(new Main().getWiner(jzq));
	}

}
