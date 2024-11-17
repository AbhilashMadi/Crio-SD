package google_forms;

import java.util.Arrays;

public class SingleChoiceMCQ extends Question {
    private final String[] choices;

    public SingleChoiceMCQ(String questionText, String[] choices) {
        super(questionText);
        this.choices = choices;
    }

    public String[] getChoices() {
        return choices;
    }

    @Override
    public boolean acceptResponse(String response) {
        return Arrays.asList(choices).contains(response);
    }
}