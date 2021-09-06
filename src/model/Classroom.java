package model;

import java.util.ArrayList;
import java.util.List;


public class Classroom {
	public UserAccount userAccount;
	private List<UserAccount> userAccounts;
	
	public Classroom() {
		userAccounts = new ArrayList<UserAccount>();
	}
	
	public void addUserAccount(String userName, String password, String profilePhoto, String gender, ArrayList<String> career, String birthday, String browser) {
		userAccounts.add(new UserAccount(userName, password, profilePhoto, gender, career, birthday, browser));
	}
	
	public List<UserAccount> getUserAccounts(){
		return userAccounts;
	}
	
	
	public boolean checkAccount(String user, String password) {
		boolean check = false;
		for(int i=0; (i<getUserAccounts().size())&&(check==false);i++) {
			if(
					(user.equals(userAccounts.get(i).getUserName()))&&
					(password.equals(userAccounts.get(i).getPassword()))) {
				
				check = true;
			}
		}
		return check;
	}
	
	
	public boolean putPicture(String user, String password, String absolutePath) {
		boolean check = false;
		for(int i=0; (i<getUserAccounts().size())&&(check==false);i++) {
			if(
					(user.equals(userAccounts.get(i).getUserName()))&&
					(password.equals(userAccounts.get(i).getPassword()))&&
					(absolutePath.equals(userAccounts.get(i).getProfilePhoto()))
					) {
				check = true;
			}
		}
		return check;
	}
	
	
	public String putInfo(String user, String password) {
		boolean check = false;
		for(int i=0; (i<getUserAccounts().size())&&(check==false);i++) {
			if(
					(user.equals(userAccounts.get(i).getUserName()))&&
					(password.equals(userAccounts.get(i).getPassword()))
					) {
				check = true;
			}
		}
		return user;
	}

}
