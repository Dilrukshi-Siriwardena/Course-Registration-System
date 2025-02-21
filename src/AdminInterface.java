/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

import java.io.IOException;
import java.util.ArrayList;

public interface AdminInterface {
	public void createCourse() throws IOException;
	public void deleteCourse() throws IOException;
	public void editCourse() throws IOException;
	public void displayACourse() throws IOException;
	public void registerStudent() throws IOException;
	public void adminViewAllCourses();
	public ArrayList<Course> viewFullCourses();
	public void viewRegisteredStudents() throws IOException;
	public void viewAllStudentCourses() throws IOException;
	public void sortCourses();
	public void writeToFileFullCourses();
}
