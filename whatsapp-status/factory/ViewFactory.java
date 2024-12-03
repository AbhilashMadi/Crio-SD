package factory;

import constants.MediaType;
import entities.ImageView;
import entities.TextView;
import entities.VideoView;
import entities.View;

public class ViewFactory {
    public static View getView(MediaType type, String content) {
        View view = switch (type) {
            case IMAGE -> new ImageView();
            case VIDEO -> new VideoView();
            case TEXT -> new TextView();
            default -> throw new IllegalArgumentException("Unsupported MediaType");
        };

        view.setContent(content);
        return view;
    }
}
