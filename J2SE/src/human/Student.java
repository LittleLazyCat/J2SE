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
		//选择排序
		for(int i =0;i<len;i++)
		{	
			int min = i;
			stu = s[i];
			for(int j=i+1;j<len;j++)
			{
				//每次都找到出生年最大的那个，交换
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
			    new Student ("林楚金",1989 ,"男"),
			    new Student ("诸葛亮",1981,"男"),
			    new Student ("迈克杰克逊",1958 ,"男"),
			    new Student ("乔丹",1963 ,"男"),
			    new Student ("拿破仑",1769 ,"男"),
			      new Student ("苍井空",1983,"女")};
		new Student().stuSort(student);
		for(int i=0;i<student.length;i++)
		{
			System.out.println(student[i]);
		}
	}

}
