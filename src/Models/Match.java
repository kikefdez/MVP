package Models;

public class Match {
    private Team team_A;
    private Team team_B;

    public Team getTeam_A() { return team_A; }
    public void setTeam_A(Team team_A) { this.team_A = team_A; }
    public Team getTeam_B() { return team_B; }
    public void setTeam_B(Team team_B) { this.team_B = team_B; }

    public Match(){
        team_A = new Team();
        team_B = new Team();
    }

    public boolean validatePlayer(String nick) {
        return team_A.validatePlayer(nick) && team_B.validatePlayer(nick);
    }

    public void determinateWinner(){
        if(team_A.getScore() > team_B.getScore())
            team_A.setAsWinner();
        else
            team_B.setAsWinner();
    }

}
