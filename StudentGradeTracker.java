import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeTracker {

    public void GradeInut() {
        ArrayList<String> studentsName = new ArrayList<>();
        ArrayList<Double> studentsGrade = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of students:");
        int numberOfStudents = scanner.nextInt();

        for (int i = 0; i < numberOfStudents; i++) {
            System.out.println("Enter the name of student " + (i + 1) + ":");
            String name = scanner.next();
            studentsName.add(name);

            System.out.println("Enter the grade of student " + (i + 1) + ":");
            Double grade = scanner.nextDouble();
            studentsGrade.add(grade);
        }
        
        System.out.println("Successfully Updated the Grade");

        scanner.close();

    }

    public  Double AverageGrade(ArrayList<Double> studentsGrade) {
        if (studentsGrade.isEmpty()) {
            System.out.println("No Data Found");
            return 0.0;
        }
        double sum = 0;
        for (Double grade : studentsGrade) {
            sum += grade;
        }
        return sum / studentsGrade.size();
    }

    public void HighestGrade(ArrayList<Double> grade, ArrayList<String> name) {
        if (grade.isEmpty()) {
            System.out.println("No Data Found");
            return;
        }
        double studentGrade = grade.get(0);
        String stundentName = name.get(0);

        for (int i = 0; i < grade.size(); i++) {
            if (studentGrade < grade.get(i+1)) {
                studentGrade = grade.get(i+1);
                stundentName = name.get(i+1);
            }
        }

        System.out.println("Student Name->" + stundentName);
        System.out.println("Grade->" + studentGrade);
    }

    public void LowestGrade(ArrayList<Double> grade, ArrayList<String> name) {
        if (grade.isEmpty()) {
            System.out.println("No Data Found");
            return;
        }
        double studentGrade = grade.get(0);
        String stundentName = name.get(0);

        for (int i = 0; i < grade.size(); i++) {
            if (studentGrade > grade.get(i+1)) {
                studentGrade = grade.get(i+1);
                stundentName = name.get(i+1);
            }
        }

        System.out.println("Student Name->" + stundentName);
        System.out.println("Grade->" + studentGrade);
    }

    public static void main(String[] args) {
        while (true) { 
            System.out.println("1. Input Students Grade");
            System.out.println("2. Show All Student Result");
            System.out.println("3. Show Highest Student Result");
            System.out.println("4. Show Lowest Student Result");
            System.out.println("5. Show Average Result");
            System.out.println("6. Exit");

            Scanner scanner = new Scanner(System.in);
            System.out.print("");
            System.out.println("Enter Option-> ");
            int option = scanner.nextInt();
            
            if (option == 1) {
                StudentGradeTracker gradeTracker = new StudentGradeTracker();
                gradeTracker.GradeInut();
            } else if (option == 2) {

            } else if (option == 3) {
                // Show highest student result
            } else if (option == 4) {
                // Show lowest student result
            } else if (option == 5) {
                // Show average result
            } else if (option == 6) {
                System.out.println("Exiting...");
                break;
            }
        }
    }
}
