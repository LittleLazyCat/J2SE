package clock;

public class Display {
	
	private int value;//显示的值
	private int limit; //该值的限制
	public int getLimit() {
		return limit;
	}
	
	public Display(int v,int l)
	{
		this.value =v;
		this.limit=l;
	}
	public void increase()
	{
		value++;
		if(value == limit)
		{
			value =0;
		}
	}
	public int getValue()
	{
		return value;
	}
	public static void main(String[] args) {
		Display d =new Display(1,24);
		for(int i =0;i<100;i++)
		{
			
			d.getValue();
			d.increase();
		}
	}

}
