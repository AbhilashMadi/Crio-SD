package patterns.statepattern.musicplayer;

import java.util.UUID;

public class Track {
    private final String title;
    private final String artist;
    String trackId;

    public Track(String title, String artist) {
        this.title = title;
        this.artist = artist;
        this.trackId = UUID.randomUUID().toString();
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }
}
