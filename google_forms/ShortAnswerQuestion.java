package google_forms;

public class ShortAnswerQuestion extends Question {
    private static final int MAX_RESPONSE_LENGTH = 30;

    public ShortAnswerQuestion(String questionText) {
        super(questionText);
    }

    @Override
    public boolean acceptResponse(String response) {
        return response.length() <= MAX_RESPONSE_LENGTH;
    }
}