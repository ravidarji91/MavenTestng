package skyselect_Maven.skyselect_Maven;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class data_read {
	
	@DataProvider(name="dataPrv")
	public Object[][] DataMethod(){
		
		return new Object[][] {{"value1"},{"Test Two"} };
		
		
	}	
	@Test (dataProvider = "dataPrv")
	public void Testtrial(String values) {
		System.out.println("This is new values" +values);
		
	}
	
//	public List<String[]> readCSV(String filePath) throws IOException {
//    List<String[]> records = new ArrayList<>();
//    
//    try (FileReader reader = new FileReader(filePath);
//         CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withHeader())) {
//         
//        for (CSVRecord csvRecord : csvParser) {
//            // Convert each record to an array of strings
//            String[] recordArray = new String[csvRecord.size()];
//            for (int i = 0; i < csvRecord.size(); i++) {
//                recordArray[i] = csvRecord.get(i);
//            }
//            records.add(recordArray);
//        }
//    }
//    return records;
//}

}
