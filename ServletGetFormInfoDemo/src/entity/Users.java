package entity;

import java.util.Date;

public class Users {
	private String username;//用户名
	private Date birthday;//出生日期
	private String gender;//性别
	private String[] favourites;//爱好
	private boolean flag;//是否接受协议
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
