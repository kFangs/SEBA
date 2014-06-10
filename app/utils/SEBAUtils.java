/**
 * 
 */
package utils;

import java.util.ArrayList;

/**
 * @author saroj-gautam
 *
 */
public class SEBAUtils {

	private ArrayList<String> semester = new ArrayList<String>();
	
	/**
	 * 
	 * @return Number of Semester
	 */
	public ArrayList<String> getNoOfSemester(){
		semester.add("I");
		semester.add("II");
		semester.add("III");
		semester.add("IV");
		semester.add("V");
		semester.add("VI");
		semester.add("VII");
		semester.add("VIII");
		return semester;
	}
}
