package skyselect_Maven.skyselect_Maven;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.Test;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

public class data_read {
	 public static Iterator<Object[]> readCSVData(String filePath) throws Exception {
	        Reader reader = new FileReader(filePath);
	        Iterable<CSVRecord> records = CSVFormat.DEFAULT
	                .withFirstRecordAsHeader()
	                .parse(reader);
	       // int currentIndex = 0;

	        List<Object[]> data = new ArrayList<>();
	        for (CSVRecord record : records) {
	            String username = record.get("username");
	            String password = record.get("password");
	            data.add(new Object[]{username, password});
	        }

	        return data.iterator();
	    }
   
}

