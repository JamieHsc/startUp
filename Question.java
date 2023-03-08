public class Question {
    private String question;
    private String[] choices;
    private int answerIndex;

    public Question(String question, String[] choices, int answerIndex) {
        this.question = question;
        this.choices = choices;
        this.answerIndex = answerIndex;
    }

    public String getQuestion() {
        return this.question;
    }

    public String[] getChoices() {
        return this.choices;
    }

    public int getAnswerIndex() {
        return this.answerIndex;
    }

}
