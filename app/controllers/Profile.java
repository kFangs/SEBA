/**
 * 
 */
package controllers;

import java.util.ArrayList;

import javax.validation.Valid;

import com.sun.xml.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import models.RegisterUser;
import models.SubmitProfile;
import play.mvc.Before;
import play.mvc.Controller;
import utils.SEBAUtils;

/**
 * @author saroj-gautam
 * 
 */
public class Profile extends Controller {
	
	private static ArrayList<String> courses = new ArrayList<String>();
	private static ArrayList<String> skills = new ArrayList<String>();
	private static ArrayList<String> projects = new ArrayList<String>();
	private static ArrayList<String> helpRequired = new ArrayList<String>();

	/**
	 * Checks if User is connected or not
	 * @return
	 */
	static SubmitProfile connected() {
		String email = session.get("email");
		if (email != null) {
			return SubmitProfile.find("byEmail", email).first();
		}
		return null;
	}

	/**
	 * Redirects User to the index page
	 */
	public static void index() {
		SubmitProfile user = connected();
		if (user != null) {
			System.out.println("In index page.. Object...." + user);
			System.out.println("In index page..FirstName.." + user.getFirstName());
			renderArgs.put("profileUser", user);
			renderArgs.put("courses", courses);
			renderArgs.put("skills", skills);
			renderArgs.put("projects", projects);
			renderArgs.put("helpRequired", helpRequired);
		}
		render();
	}

	/**
	 * Redirects user to profile completion page
	 */
	public static void completeProfile() {
		System.out.println("Inside completeProfile....");
		SEBAUtils utils = new SEBAUtils();
		renderArgs.put("semester", utils.getNoOfSemester());
		String email = session.get("email");
		System.out.println("Email in completion profile " + email);
		RegisterUser registerUser = RegisterUser.find("byEmail", email).first();
		System.out.println("register user in Profile page " + registerUser);
		renderArgs.put("registerUser", registerUser);
		render();
	}
	
	/**
	 * Redirects user to edit profile page
	 */
	public static void editProfile(){
		System.out.println("Inside completeProfile....");
		SEBAUtils utils = new SEBAUtils();
		renderArgs.put("semester", utils.getNoOfSemester());
		String profileEmail = session.get("email");
		SubmitProfile submitProfile = SubmitProfile.find("byEmail", profileEmail).first();
		System.out.println("Submit profile object while editing profile ... " + submitProfile);
		renderArgs.put("submitProfile", submitProfile);
		render();
	}

	/**
	 * Method that handles data required for Profile Completion
	 * 
	 * @param submitProfile
	 */
	public static void submitProfile(@Valid SubmitProfile submitProfile) {
		System.out.println("Inside submitProfile......");
		validation.required(submitProfile.getEmail());
		if (validation.hasErrors()) {
			// render("@profile", submitProfile, submitProfile.getEmail());
		}
		try {
			// saving profile for users
			submitProfile.create();
			session.put("email", submitProfile.getEmail());
			session.put("profileUser", submitProfile);
			renderArgs.put("profileUser", submitProfile);
			
			getCourses(submitProfile.getEmail());
			getSkills(submitProfile.getEmail());
			getProjects(submitProfile.getEmail());
			getHelpRequired(submitProfile.getEmail());
			
		} catch (Exception e) {
			e.printStackTrace();
			renderJSON("{\"error\": true, \"message\": \"Completing Profile failed! Something went wrong.\"}");
		}
		Profile.index();
	}
	
	/**
	 * Controls the edit Form data and updates the form
	 * @param submitProfile
	 */
	public static void editProfileData(@Valid SubmitProfile submitProfile){
		System.out.println("Inside editProfile......");
		try {
			String email = session.get("email");
			System.out.println("Email..." + email);
			SubmitProfile sProfile = SubmitProfile.find("byEmail", email).first();
			System.out.println("Email from form " + sProfile.getEmail());
			// updating the Object 
			submitProfile.save();
			SubmitProfile saProfile = SubmitProfile.find("byEmail", email).first();
			System.out.println("Fetching name from database " + saProfile.getFirstName());
		} catch (Exception e) {
			e.printStackTrace();
			renderJSON("{\"error\": true, \"message\": \"Completing Profile failed! Something went wrong.\"}");
		}
		Profile.index();
	}
	
	/**
	 * 
	 * @param email
	 * @return
	 */
	private static ArrayList<String> getCourses(String email){
		if (email != null) {
			SubmitProfile profile =  SubmitProfile.find("byEmail", email).first();
			String fullCourses = profile.getCourses();
			String []allCourses = fullCourses.split(",");
			for(String course : allCourses){
				courses.add(course);
			}
		}
		return courses;
	}
	
	/**
	 * 
	 * @param email
	 * @return
	 */
	private static ArrayList<String> getSkills(String email){
		if(email != null){
			SubmitProfile profile = SubmitProfile.find("byEmail", email).first();
			String mySkills = profile.getSkills();
			String []allSkills = mySkills.split(",");
			for(String skill : allSkills){
				skills.add(skill);
			}
		}
		return skills;
	}
	
	/**
	 * 
	 * @param email
	 * @return
	 */
	private static ArrayList<String> getProjects(String email){
		if(email != null){
			SubmitProfile profile = SubmitProfile.find("byEmail", email).first();
			String myProjects = profile.getProjects();
			String []myProject = myProjects.split(",");
			for(String project : myProject){
				projects.add(project);
			}
		}
		return projects;
	}
	
	/**
	 * 
	 * @param email
	 * @return
	 */
	private static ArrayList<String> getHelpRequired(String email){
		if(email != null){
			SubmitProfile profile = SubmitProfile.find("byEmail", email).first();
			String requiredHelp = profile.getHelpRequired();
			String []arrayRequiredHelp = requiredHelp.split(",");
			for(String help : arrayRequiredHelp){
				helpRequired.add(help);
			}
		}
		return helpRequired;
	}
}