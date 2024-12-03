package entities;

import java.util.Objects;

public class TextView implements View {
    private String content;

    @Override
    public void displayMedia() {
        System.out.println("Displaying text: " + content);
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TextView textView = (TextView) o;
        return Objects.equals(content, textView.content);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(content);
    }
}
