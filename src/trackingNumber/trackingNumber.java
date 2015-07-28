package TrackingNumber;

import java.util.*;

import trackingNumber.Range.Relation;

class TrackingNumber {
	private char statusCode;
	private char transferCode;
	private Range r;
	private boolean deleted;
	
	public TrackingNumber(int low, int high, char status_code, char transfer_code) {
		this.statusCode = status_code;
		this.transferCode = transfer_code;
		Range TrackingNumberRange = new Range(low, high);
		this.deleted = false;
	}
	
	public List<TrackingNumber> compare(TrackingNumber anotherTrackingNumber) 
	{
		List<TrackingNumber> newTrackingNumberRows = new ArrayList<TrackingNumber>();
		
		Relation relation  = this.r.classify(anotherTrackingNumber.getR());
		if(relation==Relation.SAME)
		{
			anotherTrackingNumber.setDeleted(true);
			newTrackingNumberRows.add(this);
		}
		return newTrackingNumberRows;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public Range getR() {
		return r;
	}

	public char getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(char statusCode) {
		this.statusCode = statusCode;
	}

	public char getTransferCode() {
		return transferCode;
	}

	public void setTransferCode(char transferCode) {
		this.transferCode = transferCode;
	}

	
}
