package human;

public class Student {
	String name;
	int Birth;
	String sex;
	public Student(){
		
	}
	public Student(String name, int birth, String sex) {
		super();
		this.name = name;
		Birth = birth;
		this.sex = sex;
	}

	
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", Birth=" + Birth + ", sex=" + sex + "]";
	}
	public Student[] stuSort(Student[] s)
	{
		Student stu = null;
		int len = s.length;
		//ѡ������
		for(int i =0;i<len;i++)
		{	
			int min = i;
			stu = s[i];
			for(int j=i+1;j<len;j++)
			{
				//ÿ�ζ��ҵ������������Ǹ�������
				if(s[j].Birth>stu.Birth)
				{
					stu = s[j];
					min = j;
				}
				
			}
			if(min!=i)
			{
				s[min] = s[i];
				s[i] = stu;
			}
		}
		return s;
	}
	public static void main(String[] args) {
		Student[] student={
			    new Student ("�ֳ���",1989 ,"��"),
			    new Student ("�����",1981,"��"),
			    new Student ("���˽ܿ�ѷ",1958 ,"��"),
			    new Student ("�ǵ�",1963 ,"��"),
			    new Student ("������",1769 ,"��"),
			      new Student ("�Ծ���",1983,"Ů")};
		new Student().stuSort(student);
		for(int i=0;i<student.length;i++)
		{
			System.out.println(student[i]);
		}
	}

}
