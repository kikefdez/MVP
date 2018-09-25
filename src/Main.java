import Exceptions.FolderNotFoundException;
import Exceptions.SportNotFoundException;
import FileManager.FileManager;
import Models.Match;
import Models.Player;
import Models.Tournament;
import Sports.SportInterface;
import javafx.util.Pair;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws FolderNotFoundException, FileNotFoundException, SportNotFoundException {
        Tournament tournament = new Tournament();

        try {
            FileManager fileManager = new FileManager();
            File[] files = fileManager.getFilesPath();

            for (File file : files) {
                Pair<SportInterface, ArrayList<String>> pair = fileManager.readResumenFile(file);

                SportInterface sportInterface = pair.getKey();
                ArrayList<String> resumeLines = pair.getValue();

                Match match = sportInterface.readLines(resumeLines);
                match.determinateWinner();

                tournament.loadMatch(match);
            }
            Player mvpPlayer = tournament.obtainMVP();

            System.out.println("The Most Valuable Player of Tucan Tournament is ....... " + mvpPlayer.getName() + " [" + mvpPlayer.getNick() + "] with a final score of " + mvpPlayer.getScore() + " points.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
