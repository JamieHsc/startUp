import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Quiz quiz = new Quiz();
        while (true) {
            System.out.println("------------------------------------------------");
            System.out.print("Enter a question : ");
            String question = sc.nextLine();
            if (question.equals("exit")) {
                System.out.println("------------------------------------------------");
                break;
            }
            System.out.println("------------------------------------------------");
            System.out.print("Enter choices : ");
            String[] choices = sc.nextLine().split(",");
            System.out.println("------------------------------------------------");
            System.out.print("Enter the correct answer (1-" + choices.length + "): ");
            int answerIndex = sc.nextInt() - 1;
            quiz.addQuestion(new Question(question, choices, answerIndex));
            sc.nextLine();
        }
        quiz.run();
    }
}
