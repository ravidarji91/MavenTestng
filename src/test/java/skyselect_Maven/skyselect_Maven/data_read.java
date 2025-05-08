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

	 public static Iterator<Object[]> readCSVData(String filePath, String... columns) throws Exception {
	        Reader reader = new FileReader(filePath);
	        Iterable<CSVRecord> records = CSVFormat.DEFAULT
	                .withFirstRecordAsHeader()
	                .parse(reader);

	        List<Object[]> data = new ArrayList<>();
	        for (CSVRecord record : records) {
	            List<String> row = new ArrayList<>();
	            for (String column : columns) {
	                row.add(record.get(column));  // Read each requested column
	            }
	            data.add(row.toArray(new String[0])); // Convert List to Array
	        }

	        return data.iterator();
	    }
	 
}

