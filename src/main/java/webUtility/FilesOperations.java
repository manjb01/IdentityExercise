package webUtility;

import flow.VehicleDetails;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FilesOperations {
    LogFileMessage log = new LogFileMessage();

    public List<VehicleDetails> getVechileDetailsFromExcellFile(File filePath) {
        List<VehicleDetails> vehicleDetails = new ArrayList<>();
        XSSFWorkbook myWorkBook = null;
        try {
            List<String> cellsData = new ArrayList<>();
            myWorkBook = new XSSFWorkbook(new FileInputStream(filePath));
            XSSFSheet mysheet = myWorkBook.getSheetAt(0);
            mysheet.forEach(row -> {
                if (row.getRowNum() > 0) {
                    row.forEach(cell -> {
                                cellsData.add(cell.toString());
                            }
                    );
                    vehicleDetails.add(new VehicleDetails(cellsData.get(0), cellsData.get(1), cellsData.get(2)));
                }
            });
        } catch (FileNotFoundException e) {
            log.printStackTrace(e);
        } catch (IOException e) {
            log.printStackTrace(e);
        }
        return vehicleDetails;
    }

    //    This method is for reading CSV files
    public List<VehicleDetails> readCSVFile(File filePath) {
        String fileName = filePath.getAbsolutePath().toString();
        List<String> eachLine = new ArrayList<>();
        List<VehicleDetails> vehicleList = new ArrayList<>();
        int count = 0;
        try (Stream<String> lines = Files.lines(Paths.get(fileName))) {
            List<List<String>> values = lines.map(line -> Arrays.asList(line.split(","))).collect(Collectors.toList());
            values.forEach(value -> eachLine.add(value.toString()));

            for (List<String> obj : values) {

                if (count > 0)
                    vehicleList.add(new VehicleDetails(obj.get(0).toString(), obj.get(1).toString(), obj.get(2).toString()));
                count = 1;
            }
        } catch (IOException e) {
                log.printStackTrace(e);
        }
        return vehicleList;
    }


}
