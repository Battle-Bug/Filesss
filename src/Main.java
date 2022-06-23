import java.io.File;
import java.io.FilenameFilter;
import java.util.Objects;

public class Main {

    public static void main(String[] args) {
        Maker maker = new Maker();
        File mainDirectory = new File("C://Games");
        File srcDir = new File(mainDirectory, "src");
        File resDir = new File(mainDirectory, "res");
        File saveGamesDir = new File(mainDirectory, "savegames");
        File tempDir = new File(mainDirectory, "temp");
        maker.createDir(srcDir);
        maker.createDir(resDir);
        maker.createDir(saveGamesDir);
        maker.createDir(tempDir);
        File mainDir = new File(srcDir, "main");
        File testDir = new File(srcDir, "test");
        maker.createDir(mainDir);
        maker.createDir(testDir);
        File mainFile = new File(mainDir, "Main.java");
        File utilsFile = new File(mainDir, "Utils.java");
        maker.createFile(mainFile);
        maker.createFile(utilsFile);
        File drawablesDir = new File(resDir, "drawables");
        File vectorsDir = new File(resDir, "vectors");
        File iconsDir = new File(resDir, "icons");
        maker.createDir(drawablesDir);
        maker.createDir(vectorsDir);
        maker.createDir(iconsDir);
        File tempFile = new File(tempDir, "temp.txt");
        maker.createFile(tempFile);
        maker.getLogs(tempFile);

        GameProgress gp1 = new GameProgress(100, 1, 20, 2.0);
        GameProgress gp2 = new GameProgress(150, 3, 25, 2.5);
        GameProgress gp3 = new GameProgress(175, 2, 26, 3.1);
        File save1 = new File(saveGamesDir, "save_1.dat");
        File save2 = new File(saveGamesDir, "save_2.dat");
        File save3 = new File(saveGamesDir, "save_3.dat");

        maker.saveGame(save1, gp1);
        maker.saveGame(save2, gp2);
        maker.saveGame(save3, gp3);
        maker.getLogs(tempFile);


        File zipArch = new File(saveGamesDir, "saves.zip");
        maker.zipSaves(zipArch, save1, save2, save3);
        maker.deleteFile(save1);
        maker.deleteFile(save2);
        maker.deleteFile(save3);
        maker.getLogs(tempFile);

        maker.unZipSaves(zipArch);
        FilenameFilter filenameFilter = (dir, name) -> name.endsWith("dat");
        for (File file : saveGamesDir.listFiles(filenameFilter)) {
            System.out.println(maker.readFile(file));
        }

        maker.getLogs(tempFile);

    }

}