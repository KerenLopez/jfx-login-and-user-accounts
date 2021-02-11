package model;

public class UserAccount {
	
	private String name;
	private String password;
	private String urlPhoto;
	private Gender gender;
	private Career career;
	private String birthday;
	private FavoriteBrowser browser;

	public UserAccount(String name, String password, String urlPhoto, Gender gender, Career career, String birthday,FavoriteBrowser browser) {
		this.name = name;
		this.password = password;
		this.urlPhoto = urlPhoto;
		this.gender = gender;
		this.career = career;
		this.birthday = birthday;
		this.browser = browser;
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

	public Career getCareer() {
		return career;
	}

	public void setCareer(Career career) {
		this.career = career;
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
