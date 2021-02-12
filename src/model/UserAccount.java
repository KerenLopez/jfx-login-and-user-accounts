package model;

import java.util.ArrayList;

public class UserAccount {
	
	private String name;
	private String password;
	private String urlPhoto;
	private Gender gender;
	private ArrayList<Career> careers;
	private String birthday;
	private FavoriteBrowser browser;

	public UserAccount(String name, String password, String urlPhoto, String gender, ArrayList<String> careers, String birthday, String browser) {
		this.name = name;
		this.password = password;
		this.urlPhoto = urlPhoto;
		this.birthday = birthday;
		if(gender.equals("male")) {
			this.gender = Gender.MALE;
		} else if(gender.equals("female")) {
			this.gender = Gender.FEMALE;
		}else {
			this.gender = Gender.OTHER;
		}
		if(browser.equals("Chrome")) {
			this.browser = FavoriteBrowser.CHROME;
		}else if(browser.equals("Opera")) {
			this.browser = FavoriteBrowser.OPERA;
		}else if(browser.equals("Edge")) {
			this.browser = FavoriteBrowser.EDGE;
		}else if(browser.equals("Firefox")) {
			this.browser = FavoriteBrowser.FIREFOX;
		}else {
			this.browser = FavoriteBrowser.SAFARI;
		}
		for(int k=0;k<careers.size();k++){
			if(careers.get(k).equals("SIS")){
				this.careers.add(Career.SOFTWARE_ENGINEERING);
			}else if(careers.get(k).equals("TEL")) {
				this.careers.add(Career.TELEMATIC_ENGINEERING);
			}else {
				this.careers.add(Career.INDUSTRIAL_ENGINEERING);
			}
		} 	
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUrlPhoto() {
		return urlPhoto;
	}

	public void setUrlPhoto(String urlPhoto) {
		this.urlPhoto = urlPhoto;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public ArrayList<Career> getCareers() {
		return careers;
	}

	public void setCareers(ArrayList<Career> careers) {
		this.careers = careers;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public FavoriteBrowser getBrowser() {
		return browser;
	}

	public void setBrowser(FavoriteBrowser browser) {
		this.browser = browser;
	}

}
