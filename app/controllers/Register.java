/**
 * 
 */
package controllers;

/**
 * @author saroj-gautam
 *
 */

import models.RegisterUser;
import play.data.validation.Valid;
import play.mvc.Before;
import play.mvc.Controller;
import play.mvc.Scope.Flash;
import utils.GerogianCalender;
import utils.SEBAUtils;

public class Register extends Controller {
	
	@Before
    static void addUser() {
        RegisterUser user = connected();
        if(user != null) {
            renderArgs.put("user", user);
        }
    }
	
	static RegisterUser connected() {
        if(renderArgs.get("user") != null) {
            return renderArgs.get("user", RegisterUser.class);
        }
        String email = session.get("email");
        if(email != null) {
            return RegisterUser.find("byEmail", email).first();
        } 
        return null;
    }
	
	public static void register() {
		GerogianCalender calendar = new GerogianCalender();
		renderArgs.put("year", calendar.getYears());
		renderArgs.put("month", calendar.getMonths());
		renderArgs.put("day", calendar.getDays());
		render();
    }
	
	public static void index() {
        register();
    }
	
	/**
	 * A method that controls the login form
	 * @param username
	 * @param password
	 */
	public static void login(String email, String password) {
		RegisterUser registerUser = RegisterUser.find("byEmailAndPassword",email, password).first();
		if (registerUser != null) {
			session.put("email", registerUser.getEmail());
			flash.success("Welcome, " + registerUser.getFirstName(), registerUser);
			Profile.index();
		}
		flash.error("Login failed...Incorrect Username or Password" , registerUser);
		index();
	}
	
	/**
	 * 
	 * @param registerUser
	 */
	public static void registerUser(@Valid RegisterUser registerUser) {
		validation.required(registerUser.getRepeatPassword());
		validation.equals(registerUser.getRepeatPassword(), registerUser.getPassword()).message("Your password doesn't match");
        if(validation.hasErrors()) {
        	flash.error("Invalid username or password...", registerUser);
            render("@register", registerUser, registerUser.getRepeatPassword());
        }
        try {
        	// registering the user in the database
			registerUser.create();
			session.put("email", registerUser.getEmail());
	        flash.success("Welcome, " + registerUser.getFirstName());
		} catch (Exception e) {
			e.printStackTrace();
			renderJSON("{\"error\": true, \"message\": \"Registration failed! Something went wrong.\"}");
		}
		session.put("email", registerUser.getEmail());
		session.put("registerUser", registerUser);
        flash.success("Welcome, " + registerUser.getFirstName());
        Profile.completeProfile();
	}
}
