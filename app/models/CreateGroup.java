/**
 * 
 */
package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import play.data.validation.Required;
import play.db.jpa.Model;

/**
 * @author saroj-gautam
 *
 */

@Entity
@Table(name = "CreateGroup")
public class CreateGroup extends Model{

	@Required
	@Column(name = "nameOfGroup")
	private String nameOfGroup;
	
	@Required
	@Column(name = "purposeOfGroup")
	private String purposeOfGroup;
	
	@Required
	@Column(name = "studyDepartment")
	private String studyDepartment;
	
	@Required
	@Column(name = "description")
	private String description;
	
	@Required
	@Column(name = "mustHaveSkills")
	private String mustHaveSkills;
	
	@Required
	@Column(name = "preferredSkills")
	private String preferredSkills;
	
	@Required
	@Column(name = "weeklyTime")
	private String weeklyTime;
	
	@Column(name = "email")
	private String email;
	
	

	/**
	 * @param nameOfGroup
	 * @param purposeOfGroup
	 * @param studyDepartment
	 * @param description
	 * @param mustHaveSkills
	 * @param preferredSkills
	 * @param weeklyTime
	 */
	public CreateGroup(String nameOfGroup, String purposeOfGroup,
			String studyDepartment, String description, String mustHaveSkills,
			String preferredSkills, String weeklyTime, String email) {
		super();
		this.nameOfGroup = nameOfGroup;
		this.purposeOfGroup = purposeOfGroup;
		this.studyDepartment = studyDepartment;
		this.description = description;
		this.mustHaveSkills = mustHaveSkills;
		this.preferredSkills = preferredSkills;
		this.weeklyTime = weeklyTime;
		this.email = email;
	}

	/**
	 * @return the nameOfGroup
	 */
	public String getNameOfGroup() {
		return nameOfGroup;
	}

	/**
	 * @param nameOfGroup the nameOfGroup to set
	 */
	public void setNameOfGroup(String nameOfGroup) {
		this.nameOfGroup = nameOfGroup;
	}

	/**
	 * @return the purposeOfGroup
	 */
	public String getPurposeOfGroup() {
		return purposeOfGroup;
	}

	/**
	 * @param purposeOfGroup the purposeOfGroup to set
	 */
	public void setPurposeOfGroup(String purposeOfGroup) {
		this.purposeOfGroup = purposeOfGroup;
	}

	/**
	 * @return the studyDepartment
	 */
	public String getStudyDepartment() {
		return studyDepartment;
	}

	/**
	 * @param studyDepartment the studyDepartment to set
	 */
	public void setStudyDepartment(String studyDepartment) {
		this.studyDepartment = studyDepartment;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the mustHaveSkills
	 */
	public String getMustHaveSkills() {
		return mustHaveSkills;
	}

	/**
	 * @param mustHaveSkills the mustHaveSkills to set
	 */
	public void setMustHaveSkills(String mustHaveSkills) {
		this.mustHaveSkills = mustHaveSkills;
	}

	/**
	 * @return the preferredSkills
	 */
	public String getPreferredSkills() {
		return preferredSkills;
	}

	/**
	 * @param preferredSkills the preferredSkills to set
	 */
	public void setPreferredSkills(String preferredSkills) {
		this.preferredSkills = preferredSkills;
	}

	/**
	 * @return the weeklyTime
	 */
	public String getWeeklyTime() {
		return weeklyTime;
	}

	/**
	 * @param weeklyTime the weeklyTime to set
	 */
	public void setWeeklyTime(String weeklyTime) {
		this.weeklyTime = weeklyTime;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
}