import java.io.IOException;
import java.util.ArrayList;

public class MainClass {
	
	public static void main(String[] args) throws IOException {
		
		ArrayList<Salesman> salesmanList = null;
		try {
			String pathToFile = "JsonFiles\\data.json";
			salesmanList = Util.readSalesman(pathToFile);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ReportDef reportDef = null;
		try {
			String pathToFile = "JsonFiles\\reportDefinition.json";
			reportDef = Util.readReportDef(pathToFile);
			
			//System.out.println(reportDefList.get(0).getPeriodLimit());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		Util.setScores(salesmanList, reportDef.isUseExprienceMultiplier());
		Util.writeInCSV(salesmanList, reportDef);
		
		/*
			I used this data for testing
		 ,
		{
		"name": "John Smith",
		"totalSales": 254,
		"salesPeriod": 10,
		"experienceMultiplier": 0.5
		},
		{
		"name": "David Prowless",
		"totalSales": 358,
		"salesPeriod": 10,
		"experienceMultiplier": 0.5
		},
		{
		"name": "John Smith",
		"totalSales": 457,
		"salesPeriod": 12,
		"experienceMultiplier": 0.5
		},
		{
		"name": "David Prowless",
		"totalSales": 480,
		"salesPeriod": 10,
		"experienceMultiplier": 0.5
		},
		{
		"name": "John Smith",
		"totalSales": 250,
		"salesPeriod": 10,
		"experienceMultiplier": 0.5
		},
		{
		"name": "David Prowless",
		"totalSales": 350,
		"salesPeriod": 10,
		"experienceMultiplier": 0.5
		},
		{
		"name": "John Smith",
		"totalSales": 250,
		"salesPeriod": 10,
		"experienceMultiplier": 0.5
		},
		{
		"name": "David Prowless",
		"totalSales": 350,
		"salesPeriod": 10,
		"experienceMultiplier": 0.5
		},
		{
		"name": "John Smith",
		"totalSales": 250,
		"salesPeriod": 10,
		"experienceMultiplier": 0.5
		},
		{
		"name": "David Prowless",
		"totalSales": 350,
		"salesPeriod": 10,
		"experienceMultiplier": 0.5
		}
		 */
		
	}

}
