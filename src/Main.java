import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Hashtable;

public class Main {
    public static final String PATH_MIX_DOWNS = "Get later - mix downs";
    public static final String PATH_STEMS = "Get later - stems";
    public static final String PATH_TEMP = "C:/Users/Patri/Desktop/Code Projects/MaddHattPatt-BlenderTools";

    public static void main(String[] args) throws Exception {
        Song test = new Song();
        ArrayList<Song> exampleList = new ArrayList<>();
        exampleList.add(new Song());
        exampleList.add(new Song());
        exampleList.add(new Song());

        exampleList.get(0).songName = "This is a different name";
        String export = "[";
        for (int id = 0; id < exampleList.size(); id++) {
            export += exampleList.get(id).toExportHashTable();
            export += ", ";
        }

        System.out.println(export);

        // Path dir = Paths.get(PATH_TEMP);
        // Files.walk(dir).forEach(path -> showFile(path.toFile()));
    }

    public static void showFile(File file) {
        if (file.isDirectory()) {
            System.out.println(("Directory: " + file.getAbsolutePath()));
        } else {
            System.out.println(("File: " + file.getAbsolutePath()));
        }
    }

}