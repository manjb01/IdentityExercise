package webUtility;


import org.apache.commons.io.FileUtils;

import javax.activation.MimetypesFileTypeMap;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ReadFiles {

    LogFileMessage log = new LogFileMessage();


    public List<File> readFilesFromDirectory(String folderPath) {
        List<File> filesInFolder = new ArrayList<>();
        try {
            filesInFolder = Files.walk(Paths.get(folderPath))
                    .filter(Files::isRegularFile)
                    .map(Path::toFile)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            log.error("On Reading file from Directory");
            log.printStackTrace(e);
        }
        log.displayMesage("Total File size: " + filesInFolder.size() + " ,in Directory " + folderPath);
        return filesInFolder;
    }


    public List<File> readFilesFromDirectory(String[] filetypes, String dir_location) throws IOException {
        log.displayMesage("Search for the supported file type");
        //find the given extension file types in the directory and returns files information
        List<File> files;
        File dir = new File(dir_location);
        files = (List<File>) FileUtils.listFiles(dir, filetypes, true);
        return files;
    }

    public void displayFileinfo(List<File> files) {

        System.out.println("Total number of files found:  " + files.size());
        files.forEach(file -> {

            log.displayMesage("###########################################");

            log.displayMesage("file name:  " + file.getName());
            log.displayMesage("file mime type:  " + MimetypesFileTypeMap.getDefaultFileTypeMap().getContentType(file));

            log.displayMesage("file size:  " + file.length());
        });
    }

}
