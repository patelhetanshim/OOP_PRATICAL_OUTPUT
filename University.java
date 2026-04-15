 import java.util.Scanner;

Universityss University {

    static String universityName;
    static int totalStudents = 0;

    // Static block
    static {
        System.out.println("Static block executed");
    }

    // Instance block
    {
        totalStudents++;
        System.out.println("Instance block executed");
    }

    String studentName;

    University(String name) {
        studentName = name;
        System.out.println("Constructor executed for " + studentName);
    }

    static void getTotalStudents() {
        System.out.println("Total Students: " + totalStudents);
    }
}


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter University Name: ");
        University.universityName = sc.nextLine();

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine();

        University[] u = new University[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter student name: ");
            String name = sc.nextLine();
            u[i] = new University(name);
        }

        System.out.println("\nUniversity Name: " + University.universityName);
        University.getTotalStudents();
    }

    

