package interfacefactory;

import java.util.ArrayList;

//所有的产品都必须实现这个共同的接口
//这样一来，使用这些产品的类就可以引用这个接口，而不是具体类
public abstract class Pizza {
	String name;
	Dough dough;
	Sauce sauce;
	Cheese cheese;

	abstract void prepare();

	void bake() {
		System.out.println("烘烤");
	}

	void cut() {
		System.out.println("切片");
	}

	void box() {
		System.out.println("打包");
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
