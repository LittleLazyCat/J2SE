package entity;

import java.util.Date;

public class Users {
	private String username;//�û���
	private Date birthday;//��������
	private String gender;//�Ա�
	private String[] favourites;//����
	private boolean flag;//�Ƿ����Э��
	public Users()
	{
		
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String[] getFavourites() {
		return favourites;
	}
	public void setFavourites(String[] favourites) {
		this.favourites = favourites;
	}
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
}
