import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeTracker {
    static ArrayList<String> studentsName = new ArrayList<>();
    static ArrayList<Double> studentsGrade = new ArrayList<>();

    public void GradeInput(Scanner scanner) {
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

        for (int i = 1; i < grade.size(); i++) {
            if (studentGrade < grade.get(i)) {
                studentGrade = grade.get(i);
                stundentName = name.get(i);
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

        for (int i = 1; i < grade.size(); i++) {
            if (studentGrade > grade.get(i)) {
                studentGrade = grade.get(i);
                stundentName = name.get(i);
            }
        }

        System.out.println("Student Name->" + stundentName);
        System.out.println("Grade->" + studentGrade);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentGradeTracker gradeTracker = new StudentGradeTracker();
        while (true) { 
            System.out.println("1. Input Students Grade");
            System.out.println("2. Show All Student Result");
            System.out.println("3. Show Highest Student Result");
            System.out.println("4. Show Lowest Student Result");
            System.out.println("5. Show Average Result");
            System.out.println("6. Exit");

            System.out.print("");
            System.out.println("Enter Option-> ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid option. Please enter a number.");
                scanner.next();
                continue;
            }
            int option = scanner.nextInt();
            
            if (option == 1) {
                gradeTracker.GradeInput(scanner);
            } else if (option == 2) {
                if (studentsName.isEmpty()) {
                    System.out.println("No Data Found");
                    continue;
                }
                System.out.println("Student Name\tGrade");
                for (int i = 0; i < studentsName.size(); i++) {
                    System.out.println(studentsName.get(i) + "\t" + "\t" + "\t" + studentsGrade.get(i));
                }
            } else if (option == 3) {
                gradeTracker.HighestGrade(studentsGrade, studentsName);
            } else if (option == 4) {
                gradeTracker.LowestGrade(studentsGrade, studentsName);
            } else if (option == 5) {
                Double average = gradeTracker.AverageGrade(studentsGrade);
                System.out.println("Average Grade->" + average);
            } else if (option == 6) {
                System.out.println("Exiting...");
                break;
            }
        }
        scanner.close();
    }
}
