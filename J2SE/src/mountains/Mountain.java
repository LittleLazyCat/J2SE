package mountains;

public class Mountain {
	public String name;
	public int height;
	public Mountain(String name, int height) {
		super();
		this.name = name;
		this.height = height;
	}
	@Override
	public String toString() {
		return name +" "+ height ;
	}
	
}
