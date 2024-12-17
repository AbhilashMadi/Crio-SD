package patterns.statepattern.musicplayer;

class PausedState implements State {
    private final MusicPlayer player;

    public PausedState(MusicPlayer player) {
        this.player = player;
    }

    @Override
    public void play() {
        player.setCurrentState(PlayerState.PLAYING);
        System.out.println("Resuming playback: " + player.getCurrentTrack().getTitle() + " by " + player.getCurrentTrack().getArtist());
    }

    @Override
    public void pause() {
        System.out.println("Player is already in paused state");
    }

    @Override
    public void nextTrack() {
        int currentIndex = player.getTracks().indexOf(player.getCurrentTrack());

        if (currentIndex != -1 && currentIndex < player.getTracks().size() - 1) {
            player.setCurrentTrack(player.getTracks().get(currentIndex + 1));
            player.setCurrentState(PlayerState.PLAYING);
            System.out.println("Playing: " + player.getCurrentTrack().getTitle() + " by " + player.getCurrentTrack().getArtist());
        } else {
            System.out.println("No next track available.");
        }
    }

    @Override
    public void prevTrack() {
        int currentIndex = player.getTracks().indexOf(player.getCurrentTrack());

        if (currentIndex > 0) {
            player.setCurrentTrack(player.getTracks().get(currentIndex - 1));
            player.setCurrentState(PlayerState.PLAYING);
            System.out.println("Playing: " + player.getCurrentTrack().getTitle() + " by " + player.getCurrentTrack().getArtist());
        } else {
            System.out.println("No previous track available.");
        }

    }

    @Override
    public void stop() {
        player.setCurrentState(PlayerState.IDLE);
        System.out.println("Stopping the player");
    }
}