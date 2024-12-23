package com.api.models.request;

public class ProfileRequest {

	private String firstname;
	private String lastname;
	private String email;
	private String mobilenumber;

	public ProfileRequest(String firstname, String lastname, String email, String mobilenumber) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.mobilenumber = mobilenumber;
	}

	@Override
	public String toString() {
		return "ProfileRequest [firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
				+ ", mobilenumber=" + mobilenumber + "]";
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobilenumber() {
		return mobilenumber;
	}

	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}

	public static class Builder {
		private String firstname;
		private String lastname;
		private String email;
		private String mobilenumber;

		public Builder firstname(String firstname) {
			this.firstname = firstname;
			return this;
		}

		public Builder lastname(String lastname) {
			this.lastname = lastname;
			return this;
		}

		public Builder email(String email) {
			this.email = email;
			return this;
		}
		
		public Builder mobilenumber(String mobilenumber) {
			this.mobilenumber = mobilenumber;
			return this;
		}
		
		public ProfileRequest build() {
			ProfileRequest  profileRequest = new ProfileRequest(firstname, lastname, email, mobilenumber);
			return profileRequest;
		}			

	}

}
