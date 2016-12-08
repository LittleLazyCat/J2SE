package interfacefactory;

import java.util.ArrayList;

//���еĲ�Ʒ������ʵ�������ͬ�Ľӿ�
//����һ����ʹ����Щ��Ʒ����Ϳ�����������ӿڣ������Ǿ�����
public abstract class Pizza {
	String name;
	Dough dough;
	Sauce sauce;
	Cheese cheese;

	abstract void prepare();

	void bake() {
		System.out.println("�濾");
	}

	void cut() {
		System.out.println("��Ƭ");
	}

	void box() {
		System.out.println("���");
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
