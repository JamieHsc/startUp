import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;

class Question {
    String question;
    String[] choices;
    int correctAnswerIndex;

    Question(String question, String[] choices, int correctAnswerIndex) {
        this.question = question;
        this.choices = choices;
        this.correctAnswerIndex = correctAnswerIndex;
    }

    boolean isCorrectAnswer(int answerIndex) {
        return answerIndex == correctAnswerIndex;
    }
}

class Quiz {
    ArrayList<Question> questions;

    Quiz() {
        questions = new ArrayList<>();
    }

    void addQuestion(Question question) {
        questions.add(question);
    }

    int run() {
        Scanner sc = new Scanner(System.in);
        int score = 0;

        for (int i = 0; i < questions.size(); i++) {
            Question question = questions.get(i);

            System.out.println(question.question);
            for (int j = 0; j < question.choices.length; j++) {
                System.out.println((j + 1) + ". " + question.choices[j]);
            }

            System.out.print("Enter your answer: ");
            int answer = sc.nextInt();
            sc.nextLine();

            if (question.isCorrectAnswer(answer - 1)) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect. The correct answer was " + (question.correctAnswerIndex + 1));
            }
            System.out.println();
        }

        return score;
    }
}

public class StudyAid {
    static Quiz quiz;

    static void createQuestion() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the question: ");
        String question = sc.nextLine();

        System.out.println("Enter the choices (separated by commas):");
        String choicesLine = sc.nextLine();
        String[] choices = choicesLine.split(",");

        System.out.print("Enter the correct answer index: ");
        int correctAnswerIndex = sc.nextInt();
        sc.nextLine();

        quiz.addQuestion(new Question(question, choices, correctAnswerIndex - 1));
    }

    static void runQuiz() {
        int score = quiz.run();
        System.out.println("You got " + score + " out of " + quiz.questions.size() + " questions correct.");
    }

    static void saveQuiz() {
        try {
            FileOutputStream fileOut = new FileOutputStream("quiz.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(quiz);
            out.close();
            fileOut.close();
            System.out.println("Quiz saved to quiz.ser");
        } catch (IOException e) {
            e.printStackTrace();
        }



