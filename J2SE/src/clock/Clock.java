package clock;

public class Clock {

	private Display Hour ;//小时对象
	private Display Minute ;//分钟对象
	private Display Second ;//秒对象
	
	public Clock(int hour,int minute,int second)
	{
		this.Hour=new Display(hour, 24);
		this.Minute = new Display(minute, 60);
		this.Second =new Display(second, 60);
	}
	public void tick()
	{	
		//增加一秒 
		Second.increase();
		if(Second.getValue() ==0)
		{
			Minute.increase();
			if(Minute.getValue() == 0)
			{
				Hour.increase();
			}
		}
	}
	//返回一个String的值，以“hh:mm:ss“的形式表示当前时间。这里每个数值都占据两位，不足两位时补0。如“00:01:22"。
	@Override
	public String toString()
	{
		int h,m,s;
		String H,M,S;
		h=Hour.getValue();
		m=Minute.getValue();
		s=Second.getValue();
		if(h<10)
		{
			H="0"+Integer.toString(h);
		}
		else
		{
			H=Integer.toString(h);
		}
		if(s<10)
		{
			S="0"+Integer.toString(s);
		}
		else
		{
			S=Integer.toString(s);
		}
		if(m<10)
		{
			M="0"+Integer.toString(m);
		}
		else
		{
			M=Integer.toString(m);
		}
		return H+":"+M+":"+S;
	}
	

}
