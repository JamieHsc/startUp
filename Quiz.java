import java.util.ArrayList;
import java.util.Scanner;

public class Quiz {

    private ArrayList<Question> questions;

    public Quiz() {
        questions = new ArrayList<>();
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        int correct = 0;
        for (Question q : questions) {
            System.out.println("Quiz: " + q.getQuestion());
            String[] choices = q.getChoices();
            for (int i = 0; i < choices.length; i++) {
                System.out.println((i + 1) + ". " + choices[i]);
            }
            System.out.print("Enter your answer: ");
            int answer = sc.nextInt();
            if (answer == (q.getAnswerIndex() + 1)) {
                //System.out.println("Correct!");
                correct++;
            } else {
                // System.out.println("Wrong.");
            }
        }
        System.out.println("------------------------------------------------");
        System.out.println("score: " + correct + " out of " + questions.size() );
    }
}

