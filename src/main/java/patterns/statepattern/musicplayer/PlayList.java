package patterns.statepattern.musicplayer;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PlayList {
    private final List<Track> tracks;
    final String name;
    final String playlistId;

    public PlayList(String name){
        this.name = name;
        this.tracks = new ArrayList<>();
        this.playlistId = UUID.randomUUID().toString();
    }

    public void addTrack(Track track){
        tracks.add(track);
    }

    public List<Track> getTracks(){
        return this.tracks;
    }
}
