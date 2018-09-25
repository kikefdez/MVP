package Sports;

import Exceptions.DuplicatePlayerException;
import Exceptions.FileFormatException;
import Models.Match;
import Models.Player;

import java.util.ArrayList;

public class Handball implements SportInterface {

    @Override
    public Match readLines(ArrayList<String> resumeLines) throws FileFormatException, DuplicatePlayerException {
        try {
            Match match = new Match();

            for (String line : resumeLines) {
                String[] values = line.split(resume_Separator);

                if (match.validatePlayer(values[1])) {
                    Player player = new Player();

                    int playerScore = 0;

                    switch (values[4]) {
                        case "G":
                            playerScore += 50 +
                                     5* Integer.parseInt(values[5]) +
                                    -2 * Integer.parseInt(values[6]);
                            break;
                        case "F":
                            playerScore += 20 +
                                     1 * Integer.parseInt(values[5]) +
                                    -1 * Integer.parseInt(values[6]);
                            break;
                    }

                    player.setName(values[0]);
                    player.setNick(values[1]);
                    player.setScore(playerScore);

                    if (values[3].equals("Team A")) {
                        match.getTeam_A().addPlayer(player);
                        match.getTeam_A().addScore(Integer.parseInt(values[5]));
                    } else {
                        match.getTeam_B().addPlayer(player);
                        match.getTeam_B().addScore(Integer.parseInt(values[5]));
                    }

                } else {
                    throw new DuplicatePlayerException(this.getClass().getCanonicalName() + " - The player " + values[2] + " [" + values[3] + "] has been detected as DUPLICATED");
                }
            }

            return match;
        } catch (DuplicatePlayerException e){
            throw new DuplicatePlayerException(e.getMessage());
        } catch (Exception e) {
            throw new FileFormatException(this.getClass().getCanonicalName() + " - This resume file doesn't have a correct format");
        }

    }
}
