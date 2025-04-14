package com.test.TestRailManager;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

import com.gurock.testrail.APIClient;
import com.gurock.testrail.APIException;

public class TestrailManager {
	
	public static String Test_Run_ID= "4805";	
	public static  String Test_RAIL_USERNAME= "ravi@skyselect.com";//"developer@skyselect.com"//;//
	public static  String Test_RAIL_Password= "Test@123";//"0S3i7lK1mpAzOig7Ctr9-L7Qxty8K6u8gJFML3V4J";//"vrNasBHdHQEV87,ZcfmRVYx93sJAhTv."//"Test@1234";
	public static  String Test_RAIL_ENGINE_URL= "https://skyselect.testrail.io/";
	
	public static final int TEST_CASE_PASS_STATUS= 1;
	public static final int TEST_CASE_FAIL_STATUS= 5;
	
	public static void addResultForTestCase(String testcaseId, int status, String error) {
		String testRunID = Test_Run_ID;
		
		APIClient client= new APIClient(Test_RAIL_ENGINE_URL);
		client.setUser(Test_RAIL_USERNAME);
		client.setPassword(Test_RAIL_Password);
		
		Map<String, Object> data= new HashMap<String, Object>();
		data.put("status_id",status);
		data.put("comment","This is From Automation Code"+error);
		
		try {
			client.sendPost("add_result_for_case/"+ testRunID +"/"+testcaseId, data);
		} catch (MalformedURLException e) {			
			e.printStackTrace();
		} catch (IOException e) {			
			e.printStackTrace();
		} catch (APIException e) {			
			e.printStackTrace();
		}
		
		
	}
	
	
			

}
