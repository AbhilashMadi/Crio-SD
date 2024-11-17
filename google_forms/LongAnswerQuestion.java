package google_forms;

public class LongAnswerQuestion  extends  Question{
    public LongAnswerQuestion(String questionText){
        super(questionText);
    }

    @Override
    public boolean acceptResponse(String response){
        return response != null;
    }
}