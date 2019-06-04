import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

public class Util {
	
public static ArrayList<Salesman> readSalesman(String pathToFile) throws IOException{
		
		
		
		ArrayList<Salesman> list = new ArrayList<>();
		try {
		    FileReader reader = new FileReader(pathToFile);
		    JSONTokener tokener = new JSONTokener(reader);
		    JSONObject obj = new JSONObject(tokener);
		    
		    JSONArray jsArr = new JSONArray();
		    jsArr = obj.getJSONArray("Data");
		    String tempName;
		    int tempTotalSales;
		    int tempSalesPeriod;
		    float tempExperienceMultiplier;
		    
		    for (int i=0;i<jsArr.length();i++) {
		    	
		    	
		    	tempName = jsArr.getJSONObject(i).getString("name");
		    	tempTotalSales = jsArr.getJSONObject(i).getInt("totalSales");
		    	tempSalesPeriod = jsArr.getJSONObject(i).getInt("salesPeriod");
		    	tempExperienceMultiplier = jsArr.getJSONObject(i).getFloat("experienceMultiplier");
		    	list.add(new Salesman(tempName,tempTotalSales,tempSalesPeriod,tempExperienceMultiplier));
		    		
			}
		    
	    
		    
		    
		} catch (IOException e) {
		    e.printStackTrace();
		}
		return list;
	}
public static ReportDef readReportDef(String pathToFile) throws IOException{
	
	
	
	ReportDef reportDef = null;
	try {
	    FileReader reader = new FileReader(pathToFile);
	    JSONTokener tokener = new JSONTokener(reader);
	    JSONObject obj = new JSONObject(tokener);
	    
	    int tempTopPerformersThreshold;
	    boolean tempUseExprienceMultiplier;
	    int tempPeriodLimit;
	    
	    tempTopPerformersThreshold = obj.getInt("topPerformersThreshold");
	    tempUseExprienceMultiplier = obj.getBoolean("useExprienceMultiplier");
	    tempPeriodLimit = obj.getInt("periodLimit");
	    reportDef= new ReportDef(tempTopPerformersThreshold, tempUseExprienceMultiplier, tempPeriodLimit);
	        
	    
	} catch (IOException e) {
	    e.printStackTrace();
	}
	return reportDef;
}

public static void setScores(ArrayList<Salesman> smlist,boolean check) {
	if (check) {
		for (int i = 0; i < smlist.size(); i++) {
			float tempScore = (float)(smlist.get(i).getTotalSales())/smlist.get(i).getSalesPeriod()*smlist.get(i).getExperienceMultiplier();
			smlist.get(i).setScore(tempScore);
		}
	}
	for (int i = 0; i < smlist.size(); i++) {
		float tempScore = (float)smlist.get(i).getTotalSales()/smlist.get(i).getSalesPeriod();
		smlist.get(i).setScore(tempScore);
		System.out.println(tempScore);
	}
}


public static void writeInCSV(ArrayList<Salesman> salesmanList, ReportDef reportDefinition) throws IOException {
	int period = reportDefinition.getPeriodLimit();
	
	FileWriter fw = new FileWriter("test.txt");
	fw.write("Name, Score");
	
	//sort salesman by score
	Comparator<Salesman> compareByScore = (Salesman o1, Salesman o2) -> Float.compare(o2.getScore(), o1.getScore());
	Collections.sort(salesmanList, compareByScore);
	
	
	//write only top X percent of salesmen, which period is equal or less than period limit in report definition in csv file
	for(int i=0;i<salesmanList.size()*reportDefinition.getTopPerformersThreshold()/100;i++) {
		if(salesmanList.get(i).getSalesPeriod()>period) {
			salesmanList.remove(i);
		}
		fw.write("\n" + salesmanList.get(i).getName() + ", " + salesmanList.get(i).getScore());
		
	}
	
	fw.close();
}

}
