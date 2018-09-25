package Models;

import java.util.HashMap;

public class Tournament {
    private HashMap<String, Player> ranking;

    public Tournament(){
        ranking = new HashMap<>();
        System.out.println("WELCOME TO TUCAN TOURNAMENT");
    }

    public void loadMatch (Match match) {
        for(Player player : match.getTeam_A().getPlayers()){
            if(ranking.containsKey(player.getNick())) {
                Player auxPlayer = ranking.get(player.getNick());
                player.setScore(player.getScore() + auxPlayer.getScore());
            }

            ranking.put(player.getNick(), player);
        }

        for(Player player : match.getTeam_B().getPlayers()){
            if(ranking.containsKey(player.getNick())) {
                Player auxPlayer = ranking.get(player.getNick());
                player.setScore(player.getScore() + auxPlayer.getScore());
            }

            ranking.put(player.getNick(), player);
        }
    }
    public Player obtainMVP() {
        Player player = new Player();

        for( HashMap.Entry entry : ranking.entrySet()) {
            Player pivotPlayer = (Player) entry.getValue();
            if(player.getScore() < pivotPlayer.getScore()) {
                player = pivotPlayer;
            }
        }
        return player;
    }
}
