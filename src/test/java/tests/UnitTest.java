package tests;
import com.sun.org.glassfish.gmbal.Description;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import webUtility.ReadFiles;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class UnitTest {
	String dir_location = System.getProperty("user.dir") + "/src/test/resources/TestData/";
    Logger logger ;

    @Description("Scan and display details of all file in a directory and check that number of files is greater than 10")
    @Test
    public void searchAndDisplayFileDetailsofAlltheFile() throws IOException {
        ReadFiles readFiles = new ReadFiles();
        List<File> file= readFiles.readFilesFromDirectory(null,dir_location);
        Assert.assertTrue(file.size()>10);
        readFiles.displayFileinfo(file);
    }
    @Description("Scan and display certain supported mime type files in the directory")
    @Test
    public void displayVechileInfoFromAFilebyMimtype() throws IOException {
        ReadFiles readFiles = new ReadFiles();
        String[] mimType = {"text/CSV","application/vnd.ms-excel"};
        String[] fileType =readFiles.SearchForFileType(mimType);
        List<File> file= readFiles.readFilesFromDirectory(fileType,dir_location);
        readFiles.displayFileinfo(file);
    }
    @Description("Scan invalid mime type files in the directory")
    @Test(expected = java.lang.NullPointerException.class)
    public void testToVerifyInvalidMimtype() throws IOException {
        ReadFiles readFiles = new ReadFiles();
        String[] mimType = {"invalidinvalid"};
            String[] fileType = readFiles.SearchForFileType(mimType);
            List<File> file = readFiles.readFilesFromDirectory(fileType, dir_location);
            readFiles.displayFileinfo(file);
    }
}
