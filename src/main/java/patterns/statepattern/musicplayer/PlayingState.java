package patterns.statepattern.musicplayer;

public class PlayingState implements State {
    private final MusicPlayer player;

    public PlayingState(MusicPlayer player) {
        this.player = player;
    }

    @Override
    public void play(){
        System.out.println("Player is already playing: " + player.getCurrentTrack().getTitle() + " by " + player.getCurrentTrack().getArtist());
    }

    @Override
    public void pause(){
        player.setCurrentState(PlayerState.PAUSED);
        System.out.println("Paused: " + player.getCurrentTrack().getTitle() + " by " + player.getCurrentTrack().getArtist());
    }

    @Override
    public void nextTrack(){
        int currInd = player.getTracks().indexOf(player.getCurrentTrack());

        if(currInd != -1 && currInd < player.getTracks().size() - 1){
            player.setCurrentTrack(player.getTracks().get(currInd + 1));
            player.setCurrentState(PlayerState.PLAYING);
            System.out.println("Playing: " + player.getCurrentTrack().getTitle() + " by " + player.getCurrentTrack().getArtist());
        }else{
            System.out.println("No next track available.");
        }
    }

    @Override
    public void prevTrack(){
        int currInd = player.getTracks().indexOf(player.getCurrentTrack());

        if(currInd > 0){
            player.setCurrentTrack(player.getTracks().get(currInd - 1));
            player.setCurrentState(PlayerState.PLAYING);
            System.out.println("Playing: " + player.getCurrentTrack().getTitle() + " by " + player.getCurrentTrack().getArtist());
        }else{
            System.out.println("No previous track available.");
        }
    }

    @Override
    public void stop(){
        player.setCurrentState(PlayerState.IDLE);
        System.out.println("Stopping the player");
    }
}
