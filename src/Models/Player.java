package Models;

public class Player {
    private String name;
    private String nick;
    private int score;

    private static final int winnerScore = 10;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getNick() { return nick; }
    public void setNick(String nick) { this.nick = nick; }
    public int getScore() { return score; }
    public void setScore(int score) { this.score = score; }

    public Player() {
        this.name = "";
        this.nick = "";
        this.score = 0;
    }

    public void addWinnerScore() {
        this.score += winnerScore;
    }

}
