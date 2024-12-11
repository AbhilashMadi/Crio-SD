package build_logger.version_1;

public class ConsoleHandler implements LogHandler{
    @Override
    public void publish(LogRecord record){
        System.out.println(record);
    }
}
