package controllers;

import javax.validation.Valid;

import models.CreateGroup;
import play.mvc.Controller;

public class Groups extends Controller {

	public static void index() {
		String email = session.get("email");
		CreateGroup createGroup = CreateGroup.find("byEmail", email).first();
		renderArgs.put("groups", createGroup);
		render();
	}
	
	/**
	 * Method that creates Group
	 * @param createGroup
	 */
	public static void createGroup(@Valid CreateGroup createGroup) {
		try {
			String email = session.get("email");
			createGroup.setEmail(email);
			System.out.println("email " + createGroup.getEmail());
			// saving Group details
			createGroup.create();
			
			flash.success("Group "+ createGroup.getNameOfGroup()+ " created Successfully", createGroup);
			session.put("groups", createGroup);
			renderArgs.put("groups", createGroup);
		} catch (Exception e) {
			flash.error(" Failed to create Group "+ createGroup.getNameOfGroup()+ ". Something went wrong.", createGroup);
			e.printStackTrace();
			renderJSON("{\"error\": true, \"message\": \"Creating group failed! Something went wrong.\"}");
		}
		Groups.index();
	}
	
	/**
	 * Method that returns result for available searched groups
	 * @param createGroup
	 */
	public static void searchForGroup(@Valid CreateGroup createGroup){
		System.out.println("Object searchForGroup " + createGroup);
		System.out.println("Name of Group " + createGroup.getNameOfGroup());
		System.out.println("studyDepartment " + createGroup.getStudyDepartment());
		System.out.println("mustHaveSkills " + createGroup.getMustHaveSkills());
		System.out.println("preferredSkills " + createGroup.getPreferredSkills());
	}
}
