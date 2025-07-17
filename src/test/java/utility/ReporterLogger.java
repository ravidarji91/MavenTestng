package utility;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.Reporter;

public class ReporterLogger {

    private static BufferedWriter writer;

    public static void startLogging() {
        try {
            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            File logFile = new File("logs/ExecutionLog_" + timeStamp + ".txt");
            logFile.getParentFile().mkdirs(); // Create directories if they don't exist
            writer = new BufferedWriter(new FileWriter(logFile, true));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void log(String message) {
        String timestamped = "[" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "] " + message;

        // Log to TestNG's Reporter
        Reporter.log(timestamped, true);

        // Also log to external file
        try {
            writer.write(timestamped);
            writer.newLine();
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void stopLogging() {
        try {
            if (writer != null) writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}