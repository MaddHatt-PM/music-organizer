import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class Song {
    public String songName;
    public String artistName;
    public ArrayList<String> tags;

    public String mixdownPath;
    public String stemFolderPath;
    public ArrayList<String> stemPaths;

    public Song(String importData) {
        // 1. Convert string to hashtable
        // 2. Assign all matched values to values
    }

    public Song() {
        songName = "songName Example";
        artistName = "artistName Example";
        tags =  new ArrayList<>();
        tags.add("hip");
        tags.add("lofi");

        mixdownPath = "mixdown path but not actually a path";
        stemFolderPath = "stem paths but not really";
        stemPaths = new ArrayList<>();
        stemPaths.add("test data A");
        stemPaths.add("test data B");
        stemPaths.add("test data C");
        stemPaths.add("test data D");
    }

    public Song(Path mixdownPath) {
        this.mixdownPath = mixdownPath.toAbsolutePath().toString();
    }

    public Song(Path mixdownPath, Path stemFolderPath) {
        this.mixdownPath = mixdownPath.toAbsolutePath().toString();
        this.addStemsFolder(stemFolderPath);
    }

    public void addStemsFolder(Path stemFolderPath) {
        this.stemFolderPath = stemFolderPath.toAbsolutePath().toString();

        File[] stems = stemFolderPath.toFile().listFiles();
        for (int i = 0; i < stems.length; i++) {
            if (stems[i].isFile() == true) {
                stemPaths.add(stems[i].getAbsolutePath());
            }
        }
    }

    public String toExportHashTable() {

        Hashtable<String, String> container = new Hashtable<String, String>();
        container.put("songName", songName);
        container.put("artistName", artistName);
        container.put("tags", tags.toString());
        container.put("mixdownPath", mixdownPath);
        container.put("stemFolderPath", stemFolderPath);
        container.put("stemPaths", stemPaths.toString());

        return container.toString();
    }
}