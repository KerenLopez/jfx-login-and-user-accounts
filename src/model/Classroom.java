package model;
import java.util.ArrayList;

public class Classroom {
		
	private ArrayList<UserAccount> accounts;

	public Classroom() {
		accounts = new ArrayList<UserAccount>();
	}
	
	public boolean findUserAccount(String name, String password){
		boolean find = false;
		for(int k=0;k<accounts.size() && !find;k++){
			if(accounts.get(k).getName().equalsIgnoreCase(name)&& accounts.get(k).getPassword().equalsIgnoreCase(password)){
				find = true;
			}
		} return find;
	}
	
	public void addNewUserAccount(String name, String password, String urlPhoto, String gender, ArrayList<String> careers, String birthday, String browser) {
		accounts.add(new UserAccount(name,password,urlPhoto,gender,careers,birthday,browser));
	}

	public ArrayList<UserAccount> getAccounts() {
		return accounts;
	}

	public void setAccounts(ArrayList<UserAccount> accounts) {
		this.accounts = accounts;
	}
}
