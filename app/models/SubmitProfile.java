/**
 * 
 */
package models;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import play.db.jpa.Model;

/**
 * @author saroj-gautam
 *
 */

@Entity
@Table(name = "SubmitProfile")

public class SubmitProfile extends Model {
	
	@Column(name = "firstName")
	private String firstName;
	
	@Column(name = "lastName")
	private String lastName;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "studyProgram")
	private String studyProgram;
	
	@Column(name = "university")
	private String university;
	
	@Column(name = "semester")
	private String semester;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "skills")
	private String skills ;
	
	@Column(name = "courses")
	private String courses;
	
	@Column(name = "projects")
	private String projects;
	
	@Column(name = "details")
	private String details;
	
	@Column(name = "helpRequired")
	private String helpRequired;

	/**
	 * @param studyProgram
	 * @param university
	 * @param semester
	 * @param city
	 * @param skills
	 * @param courses
	 * @param projects
	 */
	public SubmitProfile(String firstName, String lastName, String email, String studyProgram, String university,
			String semester, String city, String skills,
			String courses, String projects, String helpReString, String details) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.studyProgram = studyProgram;
		this.university = university;
		this.semester = semester;
		this.city = city;
		this.skills = skills;
		this.courses = courses;
		this.projects = projects;
		this.details = details;
		this.helpRequired = helpReString;
	}
	
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
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
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	/**
	 * @return the studyProgram
	 */
	public String getStudyProgram() {
		return studyProgram;
	}

	/**
	 * @param studyProgram the studyProgram to set
	 */
	public void setStudyProgram(String studyProgram) {
		this.studyProgram = studyProgram;
	}

	/**
	 * @return the university
	 */
	public String getUniversity() {
		return university;
	}

	/**
	 * @param university the university to set
	 */
	public void setUniversity(String university) {
		this.university = university;
	}

	/**
	 * @return the semester
	 */
	public String getSemester() {
		return semester;
	}

	/**
	 * @param semester the semester to set
	 */
	public void setSemester(String semester) {
		this.semester = semester;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the skills
	 */
	public String getSkills() {
		return skills;
	}

	/**
	 * @param skills the skills to set
	 */
	public void setSkills(String skills) {
		this.skills = skills;
	}

	/**
	 * @return the courses
	 */
	public String getCourses() {
		return courses;
	}

	/**
	 * @param courses the courses to set
	 */
	public void setCourses(String courses) {
		this.courses = courses;
	}

	/**
	 * @return the projects
	 */
	public String getProjects() {
		return projects;
	}

	/**
	 * @param projects the projects to set
	 */
	public void setProjects(String projects) {
		this.projects = projects;
	}

	/**
	 * @return the details
	 */
	public String getDetails() {
		return details;
	}

	/**
	 * @param details the details to set
	 */
	public void setDetails(String details) {
		this.details = details;
	}

	/**
	 * @return the helpRequired
	 */
	public String getHelpRequired() {
		return helpRequired;
	}

	/**
	 * @param helpRequired the helpRequired to set
	 */
	public void setHelpRequired(String helpRequired) {
		this.helpRequired = helpRequired;
	}
}