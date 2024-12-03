package entities;

import java.util.Objects;

public class VideoView implements View{
    private String content;

    @Override
    public void displayMedia(){
        System.out.println("Displaying video: " + content);
    }

    @Override
    public void setContent(String content){
        this.content = content;
    }

    @Override
    public String getContent(){
        return content;
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        VideoView others = (VideoView) obj;
        return Objects.equals(content, others.content);
    }

    @Override
    public int hashCode(){
        return Objects.hash(content);
    }
}
