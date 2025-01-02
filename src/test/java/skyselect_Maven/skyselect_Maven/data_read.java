package skyselect_Maven.skyselect_Maven;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

public class data_read {
    @org.testng.annotations.DataProvider(name = "testData")
    public static Object[][] readCSV() throws IOException, CsvException {
        Object[][] data = null;
        try (CSVReader csvReader = new CSVReader(new FileReader("C:/ravi-skyselect/file_read/test_data.csv"))) {
            List<String[]> records = csvReader.readAll();
            data = new Object[records.size()][2];
            for (int i = 0; i < records.size(); i++) {
                data[i][0] = records.get(i)[0];
                data[i][1] = records.get(i)[1];
                data[i][2] = records.get(i)[2];
                
            }
        }
        return data;
    }
    
    @Test (dataProvider = "testData" )
    public void Test_read(String values) {
    	System.out.println("The Readable Data is "+ values);
    	
    }
}

