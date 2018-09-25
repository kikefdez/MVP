package Models;

import java.util.ArrayList;

public class Team {
    private int score;
    private ArrayList<Player> players;

    public int getScore() { return score; }
    public void setScore(int score) { this.score = score; }
    public ArrayList<Player> getPlayers() { return players; }
    public void setPlayers(ArrayList<Player> players) { this.players = players; }

    public Team() {
        this.score = 0;
        this.players = new ArrayList<>();
    }

    public void setAsWinner(){
        for(Player player : players) {
            player.addWinnerScore();
        }
    }
    public boolean validatePlayer(String nick) {
        for(Player player : players) {
            if(player.getNick().equals(nick))
                return false;
        }
        return true;
    }
    public void addPlayer(Player player){
        players.add(player);
    }
    public void addScore(int score){
        this.score += score;
    }
}
