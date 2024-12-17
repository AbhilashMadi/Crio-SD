package patterns.statepattern.musicplayer;

import java.util.List;

public class MusicPlayer {
    private Track currentTrack;
    private State currentState;
    private final PlayList playlist;

    public MusicPlayer(PlayList playlist) {
        currentState = new IdleState(this);
        currentTrack = null;
        this.playlist = playlist;
    }

    public void setCurrentTrack(Track track) {
        this.currentTrack = track;
    }

    public Track getCurrentTrack() {
        return currentTrack;
    }

    public void setCurrentState(PlayerState state) {
        switch (state) {
            case IDLE -> currentState = new IdleState(this);
            case PLAYING -> currentState = new PlayingState(this);
            case PAUSED -> currentState = new PausedState(this);
            default -> throw new IllegalArgumentException("Unknown state encountered");
        }
    }

    public void setCurrentState(State state) {
        this.currentState = state;
    }

    public List<Track> getTracks() {
        return playlist.getTracks();
    }

    public void play() {
        currentState.play();
    }

    public void pause() {
        currentState.pause();
    }

    public void nextTrack() {
        currentState.nextTrack();
    }

    public void prevTrack() {
        currentState.prevTrack();
    }

    public void stop() {
        currentState.stop();
    }

    public void selectTrack(Track track) {
        currentTrack = track;
    }
}
