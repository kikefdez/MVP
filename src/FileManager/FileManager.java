package FileManager;

import Exceptions.FolderNotFoundException;
import Exceptions.SportNotFoundException;
import Sports.SportEnum;
import Sports.SportInterface;
import javafx.util.Pair;

import java.io.*;
import java.util.ArrayList;

public class FileManager {
    private static final String path_folder = "src/Resources/";

    public File[] getFilesPath() throws FolderNotFoundException {
        try {
            File folder = new File(path_folder);
            if(folder.listFiles().length == 0)
                throw new FolderNotFoundException(this.getClass().getCanonicalName() + " - The folder [" + path_folder + "] is empty");
            return folder.listFiles();
        } catch (Exception e) {
            throw new FolderNotFoundException(this.getClass().getCanonicalName() + " - The folder [" + path_folder + "] is not found");
        }
    }
    public Pair<SportInterface, ArrayList<String>> readResumenFile(File file) throws FileNotFoundException, SportNotFoundException {
        try{
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

            String sportName = bufferedReader.readLine();

            SportInterface sportInterface = null;
            try{
                sportInterface = (SportEnum.valueOf(sportName)).getSport();
            } catch (Exception e) {
                throw new SportNotFoundException(this.getClass().getCanonicalName() + " - The sport in resume doesn't exist");
            }


            String line = "";
            ArrayList<String> lines = new ArrayList<>();

            while((line = bufferedReader.readLine()) != null) {
                lines.add(line);
            }

            return new Pair<>(sportInterface, lines);

        } catch (IOException e) {
            throw new FileNotFoundException(this.getClass().getCanonicalName() + " - Error during file reading: " + e.getMessage());
        }
    }
}
