package tests;
import com.sun.org.glassfish.gmbal.Description;
import org.junit.Test;
import webUtility.ReadFiles;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class UnitTest {
	String dir_location = System.getProperty("user.dir") + "/src/test/resources/TestData/";

    @Description("Scan and display details of all file in a directory")
    @Test
    public void searchAndDisplayFileDetailsofAlltheFile() throws IOException {
        ReadFiles readFiles = new ReadFiles();
        List<File> file= readFiles.readFilesFromDirectory(dir_location);
        readFiles.displayFileinfo(file);
    }


    @Description("Scan and display certain supported mime type files in the directory")
    @Test
    public void displayVechileInfoFromAFile() throws IOException {
    	ReadFiles readFiles = new ReadFiles();
    	String[] file_types = {"xlsx","csv"};
        List<File> file= readFiles.readFilesFromDirectory(file_types,dir_location);
        readFiles.displayFileinfo(file);
        }


  
}
