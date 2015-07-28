package trackingNumber;

import java.util.*;

class trackingNumber {
	private char statusCode;
	private char transferCode;
	private Range r;
	private boolean deleted;
	
	public trackingNumber(int low, int high, char status_code, char transfer_code) {
		this.statusCode = status_code;
		this.transferCode = transfer_code;
		Range trackingNumberRange = new Range(low, high);
		this.deleted = false;
	}
	
	public List<trackingNumber> compare(trackingNumber anotherTrackingNumber) 
	{
		Range.Relation relation  = this.r.classify(anotherTrackingNumber.getR());
		return null;
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

	
}