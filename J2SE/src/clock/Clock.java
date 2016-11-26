package clock;

public class Clock {

	private Display Hour ;//Сʱ����
	private Display Minute ;//���Ӷ���
	private Display Second ;//�����
	
	public Clock(int hour,int minute,int second)
	{
		this.Hour=new Display(hour, 24);
		this.Minute = new Display(minute, 60);
		this.Second =new Display(second, 60);
	}
	public void tick()
	{	
		//����һ�� 
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
	//����һ��String��ֵ���ԡ�hh:mm:ss������ʽ��ʾ��ǰʱ�䡣����ÿ����ֵ��ռ����λ��������λʱ��0���硰00:01:22"��
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