package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Classroom {
	UserAccount userAccount;
	private List<UserAccount> userAccounts;
	private String FILE_SAVE_PATH = "data/UserAccountData.apo2";
	
	public Classroom() {
		userAccounts = new ArrayList<UserAccount>();
	}
	
	public void addUserAccount(String userName, String password, String profilePhoto, String gender, ArrayList<String> career, String birthday, String browser) {
		userAccounts.add(new UserAccount(userName, password, profilePhoto, gender, career, birthday, browser));
	}
	
	public List<UserAccount> getUserAccounts(){
		return userAccounts;
	}
	
	
	public void saveUserAccount() throws FileNotFoundException, IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_SAVE_PATH));
		oos.writeObject(userAccounts);
		oos.close();
	}
	
	@SuppressWarnings("unchecked")
	public void loadUserAccount() throws FileNotFoundException, IOException, ClassNotFoundException {
		File file = new File(FILE_SAVE_PATH);
		if(file.exists()) {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
		userAccounts = (List<UserAccount>) ois.readObject();
		ois.close();
		}
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

}
