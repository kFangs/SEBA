/**
 * 
 */
package utils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * @author saroj-gautam
 * 
 */
public class GerogianCalender {

	private ArrayList<String> listOfYear = new ArrayList<String>();

	private ArrayList<String> listOfMonth = new ArrayList<String>();

	private ArrayList<String> listOfDay = new ArrayList<String>();
	
	Calendar calendar;
	
	public GerogianCalender() {
		calendar = new GregorianCalendar();
	}

	/**
	 * 
	 * @return
	 */
	public ArrayList<String> getYears() {
		listOfYear.add("1942");
		listOfYear.add("1943");
		return listOfYear;
	}

	/**
	 * 
	 * @return
	 */
	public ArrayList<String> getMonths() {
		listOfMonth.add("January");
		listOfMonth.add("February");
		return listOfMonth;
	}
	
	/**
	 * 
	 * @return
	 */
	public ArrayList<String> getDays() {
		listOfDay.add("01");
		listOfDay.add("02");
		return listOfDay;
	}
}
