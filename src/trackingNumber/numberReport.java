package trackingNumber;

import java.util.*;

class TrackingNumberReport {
	private String caseName;
	private List<TrackingNumber> trackingNumberList;
	
	
	public TrackingNumberReport(String case_name) {
		this.caseName = case_name;
		this.trackingNumberList = new ArrayList<TrackingNumber>();
	}
	
	public List<String> returnReport() {
		List<String> finalList = new ArrayList<String>();
		for(TrackingNumber t : trackingNumberList){
			if (!t.isDeleted()) {
		    	finalList.add(t.findStringFromTrackingNumber());
			}
		}
		Collections.sort(finalList);
		finalList.add(0,caseName);
		return finalList;
	}
	
	public void generateTuple(String tuple) {
		
		String tupleArray[] = tuple.split(" ");
		int low = Integer.parseInt(tupleArray[0]);
		int high = Integer.parseInt(tupleArray[1]);
		char statusCode = tupleArray[2].charAt(0);
		char transferCode = tupleArray[3].charAt(0);
		
		TrackingNumber tN = new TrackingNumber(low,high,statusCode,transferCode);
		checkRangeAndStatus(tN);
	}
	
	private void checkRangeAndStatus(TrackingNumber tN) {
		List<TrackingNumber> mutatedList = new ArrayList<TrackingNumber>();
		for(TrackingNumber t : trackingNumberList){
			if (tN.isDeleted()) {
				break;
			} else if(!t.isDeleted()) {
				mutatedList.addAll(tN.compare(t));
			}
		}
		if (mutatedList != null) {
			for(TrackingNumber newTN : mutatedList) {
				checkRangeAndStatus(newTN);
			}
			trackingNumberList.removeAll(mutatedList);
			trackingNumberList.addAll(mutatedList);
		}
		if (!tN.isDeleted() && !trackingNumberList.contains(tN)) {
			trackingNumberList.add(tN);
		}	
	}
}
