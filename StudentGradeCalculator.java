import java.util.Scanner;

public class StudentGradeCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input student's name
        System.out.print("Enter student's name: ");
        String studentName = scanner.nextLine();

        // Input number of subjects
        System.out.print("Enter the number of subjects: ");
        int numberOfSubjects = scanner.nextInt();

        // Array to store marks of each subject
        int[] marks = new int[numberOfSubjects];
        int totalMarks = 0;

        // Input marks for each subject
        for (int i = 0; i < numberOfSubjects; i++) {
            System.out.print("Enter marks for subject " + (i + 1) + ": ");
            marks[i] = scanner.nextInt();
            totalMarks += marks[i];
        }

        // Calculate average percentage
        double averagePercentage = (double) totalMarks / numberOfSubjects;

        // Calculate grade
        char grade;
        if (averagePercentage >= 90) {
            grade = 'A';
        } else if (averagePercentage >= 80) {
            grade = 'B';
        } else if (averagePercentage >= 70) {
            grade = 'C';
        } else if (averagePercentage >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }

        // Display the result
        System.out.println("\n--- Result ---");
        System.out.println("Student Name: " + studentName);
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage + "%");
        System.out.println("Grade: " + grade);

        scanner.close();
    }
}
