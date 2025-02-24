package google_forms;

public abstract class Question{
    private final String questionText;

    public Question(String questionText){
        this.questionText = questionText;
    }

    public String getQuestionText(){
        return questionText;
    }

    public abstract boolean acceptResponse(String response);
}