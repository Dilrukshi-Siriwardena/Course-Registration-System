import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Student extends User implements StudentInterface, java.io.Serializable {

    public Student(String firstName, String lastName) {
        super(firstName, lastName);
    }

    @Override
    public void studentViewAllCourses() {
        for (int i = 0; i < courseList.size(); i++) {
            // prints out the courses within the course list
            courseList.get(i).studentPrint();
        }
    }

    @Override
    public void viewAvailableCourses() {
        for (int i = 0; i < courseList.size(); i++) {
            if (courseList.get(i).getCurrentStudents() != courseList.get(i).getMaxStudents()) {
                courseList.get(i).studentPrint();
            }
        }
    }

    @Override
    public void registerToCourse() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter the course name: ");
        String courseName = in.readLine();
        System.out.println("Enter the course section ID: ");
        String courseID = in.readLine();
        System.out.println("Enter your first name: ");
        String firstName = in.readLine();
        System.out.println("Enter your last name: ");
        String lastName = in.readLine();

        for (int i = 0; i < courseList.size(); i++) {
            if (courseList.get(i).getCourseName().equals(courseName) && courseList.get(i).getCourseID().equals(courseID)) {
                // Avoid adding duplicate students
                boolean alreadyRegistered = false;
                for (Student s : courseList.get(i).studentList) {
                    if (s.getFirstName().equals(firstName) && s.getLastName().equals(lastName)) {
                        alreadyRegistered = true;
                        break;
                    }
                }

                if (!alreadyRegistered) {
                    Student student = new Student(firstName, lastName);
                    courseList.get(i).studentList.add(student);
                    System.out.println("You have been successfully added to the course!");
                } else {
                    System.out.println("You are already registered for this course.");
                }
            }
        }
    }

    @Override
    public void withdrawFromCourse() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter the course name: ");
        String courseName = in.readLine();
        System.out.println("Enter your first name: ");
        String firstName = in.readLine();
        System.out.println("Enter your last name: ");
        String lastName = in.readLine();

        for (int i = 0; i < courseList.size(); i++) {
            if (courseList.get(i).getCourseName().equals(courseName)) {
                boolean studentFound = false;
                for (int j = 0; j < courseList.get(i).studentList.size(); j++) {
                    Student s = courseList.get(i).studentList.get(j);
                    if (s.getFirstName().equals(firstName) && s.getLastName().equals(lastName)) {
                        courseList.get(i).studentList.remove(s);
                        System.out.println("You have been successfully removed from the course!");
                        studentFound = true;
                        break;
                    }
                }

                if (!studentFound) {
                    System.out.println("You are not registered for this course.");
                }
            }
        }
    }

    @Override
    public void viewAllRegisteredCourses() {
        System.out.println("Courses you are registered for:");
        for (int i = 0; i < courseList.size(); i++) {
            for (int j = 0; j < courseList.get(i).studentList.size(); j++) {
                if (courseList.get(i).studentList.get(j).equals(this)) { // 'this' refers to the current Student object
                    System.out.println(courseList.get(i).getCourseName());
                }
            }
        }
    }
}
