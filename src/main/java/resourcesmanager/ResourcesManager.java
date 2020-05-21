package resourcesmanager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.nio.file.Paths;

public class ResourcesManager {
    static Logger logger = LogManager.getLogger();
    public static void deleteTrashPdf() {
        String files;
        File file = new File(Paths.get("").toAbsolutePath().toString() + File.separator +
                "src/main/resources/");
        File[] listOfFiles = file.listFiles();
        assert listOfFiles != null;
        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                files = listOfFiles[i].getName();
                if (!files.equalsIgnoreCase("log4j2.xml")) {
                    if (!files.equalsIgnoreCase("capa.jpg")) {
                        if (!files.equalsIgnoreCase("testng.xml")) {
                            boolean issuccess = new File(listOfFiles[i].toString()).delete();
                            logger.info("Deletion Success " + issuccess);
                        }
                    }
                }
            }
        }
    }
}
