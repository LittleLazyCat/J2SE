package foxnrabbit.animal;

import java.util.ArrayList;

import foxnrabbit.field.Location;

public abstract class Animal {
	private int ageLimit;//�������ƣ������ͻ���
	private int breedableAge;//�������䣬�ﵽ�������伴������
	private int age;//����
	private boolean isAlive = true;//�Ƿ񻹻���
	
	public Animal(int ageLimit, int breedableAge) {
		this.ageLimit = ageLimit;
		this.breedableAge = breedableAge;
	}
	
	protected int getAge() {
		return age;
	}
	//�����
	protected double getAgePercent() {
		return (double)age/ageLimit;
	}
	
	public abstract Animal breed();
//	�����������������ƾ�����
	public void grow() {
		age++;
		if ( age >= ageLimit ) {
			die();
		}
	}
	//����
	public void die() {
		isAlive = false;
	}
	//�ж��Ƿ����
	public boolean isAlive() { 
		return isAlive; 
	}
//	�ж��Ƿ��������
	public boolean isBreedable() {
		return age >= breedableAge;
	}
//	�ƶ�
	public Location move(Location[] freeAdj) {
		Location ret = null;
//		�ж��Ƿ��п����ƶ���λ�ã��Լ�ֻ�������С��0.02ʱ�����ƶ�
		if ( freeAdj.length>0 && Math.random() < 0.02 ) {
//			����ƶ�����Χĳһ��
			ret = freeAdj[(int)(Math.random()*freeAdj.length)];
		}
		return ret;
	}
	
	@Override
	public String toString() {
		return ""+age+":"+(isAlive?"live":"dead");
	}
//	��
	public Animal feed(ArrayList<Animal> neighbour) {
		return null;
	}
//	������������
	protected void longerLife(int inc) {
		ageLimit += inc;
	}
}
