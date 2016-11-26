package fraction;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Fraction {
	private int a;
	private int b;

	public Fraction() {

	}

	public Fraction(int up, int down) {
		this.a = up;
		this.b = down;

	}

	// ������ܱ���Щ������
	List<Integer> divide(int n) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i <= n; i++) {
			if (n % i == 0) {
				list.add(i);
			}
		}
		return list;
	}

	// ����
	Fraction simplification(Fraction r) {
//		�õ����Լ��
		List<Integer> list_a = r.divide(r.a);
		List<Integer> list_b = r.divide(r.b);
		int tmp_a, tmp_b = 1;
		Iterator<Integer> it_a = list_a.iterator();
		Iterator<Integer> it_b;
		while (it_a.hasNext()) {
			it_b = list_b.iterator();
			tmp_a = it_a.next();
			while (it_b.hasNext()) {
				if (tmp_a == it_b.next()) {
					tmp_b = tmp_a;
				}
			}
		}
		r.a = r.a / tmp_b;
		r.b= r.b / tmp_b;
		return r;
	}

	// ת��Ϊdouble
	double toDouble() {
		return 0.0;
	}

	// �����������
	Fraction plus(Fraction r) {
//		a/b + c/d = (a*d+c*b)/(b*d)
		Fraction tmp_r = new Fraction();
		tmp_r.a = r.a*b + r.b*a;
		tmp_r.b = r.b*b;
		r= new Fraction().simplification(tmp_r);
		return tmp_r;
	}

	// �����������
	Fraction multiply(Fraction r) {
//		(a/b) * (c/d) = (a*c)/(b*d)
		Fraction tmp_r = new Fraction();
		tmp_r.a = r.a*a;
		tmp_r.b = r.b*b;
		r=new Fraction().simplification(tmp_r);
		return tmp_r;
	}

	// ��ӡ���
	void print() {
		if(a==b)
		{
			System.out.println("1");
		}
		else{
			new Fraction().simplification(this);
			System.out.println(a+"/"+b);
		}
		
	}


}
