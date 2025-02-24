import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Admin extends User implements AdminInterface, java.io.Serializable {
    static ArrayList<Student> masterRegistry = new ArrayList<>();

    public Admin() {
        super();
        this.user = "admin";
        this.pass = "admin001";
    }

    public ArrayList<Student> getMasterRegistry() {
        return masterRegistry;
    }

    @Override
    public void setUsername(String username) {
        this.user = username;
    }

    @Override
    public void createCourse() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter the course name: ");
        this.courseName = in.readLine();

        System.out.println("Enter the course ID: ");
        this.courseID = in.readLine();

        System.out.println("Enter the maximum number of students that can register: ");
        String mS = in.readLine();
        int maxStudents = Integer.parseInt(mS);

        System.out.println("Enter the current number of students that are registered: ");
        String cS = in.readLine();
        int currentStudents = Integer.parseInt(cS);

        System.out.println("Enter the department's name: ");
        this.departmentName = in.readLine();

        System.out.println("Enter the course section number: ");
        String cSN = in.readLine();
        int courseSection = Integer.parseInt(cSN);

        Course c = new Course(this.courseName, this.courseID, maxStudents, currentStudents, this.departmentName,
                courseSection);
        courseList.add(c);

        System.out.println("The new course " + courseName + " has been successfully added!");
    }

    @Override
    public void deleteCourse() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter the course name to be deleted: ");
        String courseName = in.readLine();

        boolean found = false;
        for (int i = 0; i < courseList.size(); i++) {
            if (courseList.get(i).getCourseName().equals(courseName)) {
                courseList.remove(i);
                System.out.println("The course " + courseName + " has been successfully removed!");
                found = true;
                break;
            }
        }
        
        if (!found) {
            System.out.println("Oops! We are unable to find that course, let's try again!");
        }
    }

    @Override
    public void editCourse() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter '1' to change a course's department.");
        System.out.println("Enter '2' to change a course's location.");
        String option = in.readLine();
        System.out.println("Enter the name of the course you would like to edit: ");
        String courseName = in.readLine();

        if (option.equals("1")) {
            System.out.println("Enter the new department's name: ");
            String departmentName = in.readLine();
            for (int i = 0; i < courseList.size(); i++) {
                if (courseList.get(i).getCourseName().equals(courseName)) {
                    courseList.get(i).setDepartmentName(departmentName);
                    System.out.println("Course department name has been successfully edited to: " + departmentName);
                    System.out.println("");
                }
            }
        }
    }

    @Override
    public void displayACourse() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter the course ID: ");
        String courseID = in.readLine();
        for (int i = 0; i < courseList.size(); i++) {
            if (courseList.get(i).getCourseID().equals(courseID)) {
                courseList.get(i).print();
            }
        }
    }

    @Override
    public void registerStudent() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter the new student's first name: ");
        String firstName = in.readLine();
        System.out.println("Enter the new student's last name: ");
        String lastName = in.readLine();

        Student newStudent = new Student(firstName, lastName);
        masterRegistry.add(newStudent);
        System.out.println("New student has been successfully added!");
        System.out.println(" ");
    }

    @Override
    public void adminViewAllCourses() {
        for (int i = 0; i < courseList.size(); i++) {
            courseList.get(i).print();
        }
    }

    @Override
    public ArrayList<Course> viewFullCourses() {
        ArrayList<Course> returnCourses = new ArrayList<Course>();
        for (int i = 0; i < courseList.size(); i++) {
            if (courseList.get(i).getCurrentStudents() == courseList.get(i).getMaxStudents()) {
                courseList.get(i).print();
                returnCourses.add(courseList.get(i));
            }
        }
        return returnCourses;
    }

    @Override
    public void viewRegisteredStudents() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter the course's name: ");
        String courseName = in.readLine();

        for (int i = 0; i < courseList.size(); i++) {
            if (courseList.get(i).getCourseName().equals(courseName)) {
                for (int j = 0; j < studentList.size(); j++) {
                    String firstName = courseList.get(i).getStudentList().get(j).getFirstName();
                    String lastName = courseList.get(i).getStudentList().get(j).getLastName();
                    System.out.println("Registered Students for " + courseName);
                    System.out.print("* " + firstName + " " + lastName);
                }
            }
        }
    }

    @Override
    public void writeToFileFullCourses() {
        String fileName = "text.txt";

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName))) {
            for (int i = 0; i < viewFullCourses().size(); i++) {
                String text = viewFullCourses().get(i).print();
                bufferedWriter.write(text);
                bufferedWriter.newLine();
            }
        } catch (IOException ex) {
            System.out.println("Error writing file '" + fileName + "'");
            ex.printStackTrace();
        }
    }

    @Override
    public void viewAllStudentCourses() throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void sortCourses() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

