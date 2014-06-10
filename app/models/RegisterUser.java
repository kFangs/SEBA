package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import net.sf.oval.constraint.MinSize;
import play.data.validation.MaxSize;
import play.data.validation.Required;
import play.db.jpa.*;

@Entity
@Table(name = "RegisterUser")
public class RegisterUser extends Model {

	@Required
	@MaxSize(20)
	@Column(name = "firstName")
	private String firstName;

	@Required
	@MaxSize(20)
	@Column(name = "password")
	private String password;

	@Required
	@MaxSize(20)
	@Column(name = "repeatPassword")
	private String repeatPassword;

	@Required
	@MaxSize(20)
	@Column(name = "lastName")
	private String lastName;

	@Required
	@Column(name = "email")
	private String email;

	@Column(name = "sex")
	private String sex;
	
	@Column(name = "dateOfBirth")
	private String dateOfBirth;

	/**
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param activationKey
	 * @param activated
	 */
	public RegisterUser(String firstName, String lastName, String email,
			String password, String repeatPassword, String sex,
			String dateOfBirth) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.repeatPassword = password;
		this.email = email;
		this.sex = sex;
		this.dateOfBirth = dateOfBirth;
	}

	public static RegisterUser findByEmail(String email) {
		return find("email", email).first();
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the repeatPassword
	 */
	public String getRepeatPassword() {
		return repeatPassword;
	}

	/**
	 * @param repeatPassword
	 *            the repeatPassword to set
	 */
	public void setRepeatPassword(String repeatPassword) {
		this.repeatPassword = repeatPassword;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the activationKey
	 */
	public String getSex() {
		return sex;
	}

	/**
	 * @param activationKey
	 *            the activationKey to set
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}

	/**
	 * @return the dateOfBirth
	 */
	public String getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * @param dateOfBirth the dateOfBirth to set
	 */
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
}