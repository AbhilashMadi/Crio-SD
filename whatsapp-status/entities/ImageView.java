package entities;

import java.util.Objects;

public class ImageView implements View {
    private String content;

    @Override
    public void displayMedia() {
        System.out.println("Displaying image: " + content);
    }

    @Override
    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String getContent() {
        return content;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ImageView other = (ImageView) obj;
        return Objects.equals(content, other.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(content);
    }
}
