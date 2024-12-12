package smart_home.exception;

public class UnknownFanSpeedException extends Exception{
    public UnknownFanSpeedException(Integer fanSpeed){
        super("Cannot possible to set fan speed to : " + fanSpeed.toString());
    }
}
