package build_logger.version_1;

public class EmailHandler implements LogHandler{
    @Override
    public void publish(LogRecord record){
        System.out.println("Email sent: " + record);
    }
}
