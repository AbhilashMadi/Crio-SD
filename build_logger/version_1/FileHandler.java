package build_logger.version_1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandler implements LogHandler {
    private final FileWriter fileWriter;

    public FileHandler(String filePath) throws IOException {
        this.fileWriter = new FileWriter(filePath);
    }

    @Override
    public void publish(LogRecord record) {
        try {
            this.fileWriter.write(record.toString() + "\n");
            this.fileWriter.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
