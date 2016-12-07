package factory;

import java.util.ArrayList;
//���еĲ�Ʒ������ʵ�������ͬ�Ľӿ�
//����һ����ʹ����Щ��Ʒ����Ϳ�����������ӿڣ������Ǿ�����
public abstract class Pizza {
	String name;
	String dough;
	String sauce;
	ArrayList toppings = new ArrayList();
	
	void prepare(){
		System.out.println("Preparing "+name);
		System.out.println("Tossing dough");
		System.out.println("Adding sauce");
		for(int i=0;i<toppings.size();i++)
		{
			System.out.print("    "+toppings.get(i));
		}
		System.out.println();
	}
	void bake(){
		System.out.println("�濾");
	}
	void cut(){
		System.out.println("��Ƭ");
	}
	void box(){
		System.out.println("���");
	}
	public String getName(){
		return name;
	}
}