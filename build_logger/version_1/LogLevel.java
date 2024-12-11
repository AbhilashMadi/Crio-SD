package build_logger.version_1;

public enum LogLevel {
    DEBUG(1),
    INFO(2),
    WARNING(3),
    ERROR(4),
    CRITICAL(5);

    private final int code;
    LogLevel(int code){
        this.code = code;
    }

    public int getCode(){
        return code;
    }

    @Override
    public String toString(){
        return this.name();
    }
}
