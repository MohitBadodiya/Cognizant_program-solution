
public class MVCPAtternExample{
    public static void main(String[] args) {
        // Create Model
        Student student = new Student("Aman", 121, "A");

        // Create View
        StudentView view = new StudentView();

        // Create Controller
        StudentController controller = new StudentController(student, view);

        // Display Initial Details
        controller.updateView();

        // Update Details
        controller.setStudentName("Rohan");
        controller.setStudentGrade("C");

        // Display Updated Details
        controller.updateView();
    }
}

//Model Class
class Student {
    private String name;
    private int id;
    private String grade;

    public Student(String name, int id, String grade) {
        this.name = name;
        this.id = id;
        this.grade = grade;
    }
    public String getName() {
         return name;
         }
    public int getId() {
         return id; 
        }
    public String getGrade() { 
        return grade;
     }
    public void setName(String name) {
         this.name = name;
         }
    public void setGrade(String grade) { 
        this.grade = grade; 
    }
}

// View Class
class StudentView {
    public void displayStudentDetails(String name, int id, String grade) {
        System.out.println("\nStudent Details:");
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Grade: " + grade);
    }
}

//Controller Class
class StudentController {
    private Student student;
    private StudentView view;

    public StudentController(Student student, StudentView view) {
        this.student = student;
        this.view = view;
    }

    public void setStudentName(String name) {
        student.setName(name);
    }

    public void setStudentGrade(String grade) {
        student.setGrade(grade);
    }

    public void updateView() {
        view.displayStudentDetails(student.getName(), student.getId(), student.getGrade());
    }
}
