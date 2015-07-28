package trackingNumber;

import java.util.*;

public class numberReport {
	private String caseName;
	private List<trackingNumber> trackingNumberList;
	
	
	public numberReport(String case_name) {
		this.caseName = case_name;
		this.trackingNumberList = new ArrayList<trackingNumber>();
	}
	
	public List<String> returnReport() {
		List<String> finalList = new ArrayList<String>();
		finalList.add(0,caseName);
		for(trackingNumber t : trackingNumberList){
		    finalList.add(t.findStringFromTrackingNumber());
		}
		return finalList;
	}
	
	public void generateTuple(String tuple) {
		
		String tupleArray[] = tuple.split(" ");
		int low = Integer.parseInt(tupleArray[0]);
		int high = Integer.parseInt(tupleArray[1]);
		char statusCode = tupleArray[2].charAt(0);
		char transferCode = tupleArray[3].charAt(0);
		
		trackingNumber tN = new trackingNumber(low,high,statusCode,transferCode);
		trackingNumberList.add(tN);
		for(trackingNumber t : trackingNumberList){
			if(!t.isDeleted()){
				if(tN.compare(t)!=null)		
			trackingNumberList.addAll(tN.compare(t));
			}
		}
		
	}
	
}
