package Sports;

import Exceptions.DuplicatePlayerException;
import Exceptions.FileFormatException;
import Models.Match;

import java.util.ArrayList;

public interface SportInterface {
    static final String resume_Separator = ";";

    Match readLines(ArrayList<String> resumeLines) throws FileFormatException, DuplicatePlayerException;
}
