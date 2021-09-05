package model;

import java.io.Serializable;
import java.util.ArrayList;

public class UserAccount implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	private String userName;
	private String password;
	private String profilePhoto;
	private String gender;
	private ArrayList<String> careers;
	private String birthday;
	private String browser;
	private static int userCounter;
	private final int id;
	
	public UserAccount() {
		this.id = ++UserAccount.userCounter;
	}
	
	public UserAccount(String userName, String password, String profilePhoto, String gender, ArrayList<String> careers, String birthday, String browser) {
		this();
		this.userName = userName;
		this.password = password;
		this.profilePhoto = profilePhoto;
		this.gender = gender;
		this.careers = careers;
		this.birthday = birthday;
		this.browser = browser;
	}
	
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getProfilePhoto() {
		return profilePhoto;
	}

	public void setProfilePhoto(String profilePhoto) {
		this.profilePhoto = profilePhoto;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public ArrayList<String> getCareers() {
		return careers;
	}

	public void setCareers(ArrayList<String> careers) {
		this.careers = careers;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getBrowser() {
		return browser;
	}

	public void setBrowser(String browser) {
		this.browser = browser;
	}

	public int getId() {
		return id;
	}
	

	
}
