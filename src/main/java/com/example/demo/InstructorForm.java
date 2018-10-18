package com.example.demo;

import java.io.Serializable;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class InstructorForm implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String firstName;
	
	private String lastName;
	
	@NotEmpty(message="空白は不可")
	@Email(message="メールアドレスを入力してください")
	@InstructorExists(message="そのメールはすでに存在します")
	private String email;
	
	@NotEmpty(message="空白は不可")
	private String youtubeChannel;
	
	private String hobby;
	
	public boolean isNewInstructor;
	
	private boolean validEmail;
	
	@AssertTrue(message="emailとyoutubeは同じにしてください")
	public boolean isValidEmail() {
		if(this.email == null) return false;//初回アクセス時に必要　無いとnull例外
		if(this.youtubeChannel == null) return false;
		
		if(this.email.equals(this.youtubeChannel)) {
			return true;
		}
		return false;
	}
	
	public InstructorForm() {
		//isNewInstructor = true;//新規の場合は新規投稿フォームを表示
	}

	public InstructorForm(String firstName, String lastName, String email, String youtubeChannel, String hobby, boolean isNewInstructor) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.youtubeChannel = youtubeChannel;
		this.hobby = hobby;
		this.isNewInstructor = isNewInstructor;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getYoutubeChannel() {
		return youtubeChannel;
	}

	public void setYoutubeChannel(String youtubeChannel) {
		this.youtubeChannel = youtubeChannel;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public boolean isNewInstructor() {
		return isNewInstructor;
	}

	public void setNewInstructor(boolean isNewInstructor) {
		this.isNewInstructor = isNewInstructor;
	}
	

	
	public void setValidEmail(boolean validEmail) {
		this.validEmail = validEmail;
	}
	
	

}
