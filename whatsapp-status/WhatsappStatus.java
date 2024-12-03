import constants.MediaType;
import entities.View;
import factory.ViewFactory;

import java.util.ArrayList;
import java.util.List;

public class WhatsappStatus {
    private List<View> statuses;

    public WhatsappStatus() {
        this.statuses = new ArrayList<>();
    }

    public void publishStatus(MediaType type, String content) {
        View view = ViewFactory.getView(type, content);
        this.statuses.add(view);

        view.displayMedia();
    }

    public void removeStatus(MediaType type, String content) {
        System.out.println("Before removal: " + statuses.size());
        boolean removed = statuses.remove(ViewFactory.getView(type, content));
        System.out.println("After removal: " + statuses.size());

        if (removed) {
            System.out.printf("Removed status:\nType: %s\nContent: %s\n", type, content);
        } else {
            throw new RuntimeException("Status not found: type = " + type + ", content = " + content);
        }
    }

    public static void main(String[] args) {
        WhatsappStatus status = new WhatsappStatus();

        status.publishStatus(MediaType.IMAGE, "photo.png");
        status.publishStatus(MediaType.VIDEO, "video.mp4");
        status.publishStatus(MediaType.TEXT, "text goes here");

        status.removeStatus(MediaType.TEXT, "text goes here");
    }
}
