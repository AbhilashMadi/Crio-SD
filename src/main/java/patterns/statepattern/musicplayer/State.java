package patterns.statepattern.musicplayer;

public interface State {
    void play();
    void pause();
    void nextTrack();
    void prevTrack();
    void stop();
}
