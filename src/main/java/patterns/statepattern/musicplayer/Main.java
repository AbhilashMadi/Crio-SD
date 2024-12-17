package patterns.statepattern.musicplayer;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        PlayList myPlaylist = new PlayList("myPlaylist");
        myPlaylist.addTrack(new Track("Song 1", "Artist A"));
        myPlaylist.addTrack(new Track("Song 2", "Artist B"));
        myPlaylist.addTrack(new Track("Song 3", "Artist C"));

        MusicPlayer player = new MusicPlayer(myPlaylist);

        player.selectTrack(myPlaylist.getTracks().getFirst()); // Select the first track

        // Test play, pause, and state switching
        player.play();
        player.pause();

        // Select and play a specific track
        player.selectTrack(myPlaylist.getTracks().get(1));
        player.play();

        // Navigate through tracks
        player.nextTrack();
        player.prevTrack();

        // Stop playback
        player.stop();
    }
}
