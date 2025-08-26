class Student {
    private String name;
    private int age;

    public void setDetails(String studentName, int studentAge) {
        name = studentName;
        age = studentAge;
    }

    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

public class AccessSpecifierDemo {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.setDetails("Priya", 20);
        s1.displayDetails();
    }
}
