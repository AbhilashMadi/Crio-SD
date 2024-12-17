package patterns.statepattern.musicplayer;

public class IdleState implements State {
    private final MusicPlayer player;

    public IdleState(MusicPlayer player) {
        this.player = player;
    }

    @Override
    public void play() {
        player.setCurrentState(PlayerState.PLAYING);
        System.out.println("Playing " + player.getCurrentTrack().getTitle() + " by " + player.getCurrentTrack().getArtist());
    }

    @Override
    public void pause() {
        System.out.println("Player is already in idle state");
    }

    @Override
    public void nextTrack() {
        System.out.println("Cannot change to the next song as no playlist is being used.");
    }

    @Override
    public void prevTrack() {
        System.out.println("Cannot change to the previous song as no playlist is being used.");
    }

    @Override
    public void stop() {
        System.out.println("Player is already in idle state");
    }
}
