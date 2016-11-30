package foxnrabbit.animal;

import java.util.ArrayList;

import foxnrabbit.field.Location;

public abstract class Animal {
	private int ageLimit;//年龄限制，超过就会死
	private int breedableAge;//生育年龄，达到生育年龄即可生育
	private int age;//年龄
	private boolean isAlive = true;//是否还活着
	
	public Animal(int ageLimit, int breedableAge) {
		this.ageLimit = ageLimit;
		this.breedableAge = breedableAge;
	}
	
	protected int getAge() {
		return age;
	}
	//年龄比
	protected double getAgePercent() {
		return (double)age/ageLimit;
	}
	
	public abstract Animal breed();
//	年龄增长，超过限制就死亡
	public void grow() {
		age++;
		if ( age >= ageLimit ) {
			die();
		}
	}
	//死亡
	public void die() {
		isAlive = false;
	}
	//判断是否活着
	public boolean isAlive() { 
		return isAlive; 
	}
//	判断是否可以生育
	public boolean isBreedable() {
		return age >= breedableAge;
	}
//	移动
	public Location move(Location[] freeAdj) {
		Location ret = null;
//		判断是否有可以移动的位置，以及只有随机数小于0.02时可以移动
		if ( freeAdj.length>0 && Math.random() < 0.02 ) {
//			随机移动到周围某一格
			ret = freeAdj[(int)(Math.random()*freeAdj.length)];
		}
		return ret;
	}
	
	@Override
	public String toString() {
		return ""+age+":"+(isAlive?"live":"dead");
	}
//	吃
	public Animal feed(ArrayList<Animal> neighbour) {
		return null;
	}
//	增长年龄限制
	protected void longerLife(int inc) {
		ageLimit += inc;
	}
}
