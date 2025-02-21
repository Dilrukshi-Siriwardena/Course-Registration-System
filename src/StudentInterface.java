/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

import java.io.IOException;
import java.util.ArrayList;

public interface StudentInterface {
	public void studentViewAllCourses();
	public void viewAvailableCourses();
	public void registerToCourse() throws IOException;
	public void withdrawFromCourse() throws IOException;
	public void viewAllRegisteredCourses();
}
