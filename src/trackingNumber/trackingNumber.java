package trackingNumber;

import java.util.*;

import trackingNumber.Range.Relation;

class TrackingNumber {
	private char statusCode;
	private char transferCode;
	private Range TrackingNumberRange;
	private boolean deleted;
	
	public TrackingNumber(int low, int high, char status_code, char transfer_code) {
		this.statusCode = status_code;
		this.transferCode = transfer_code;
		TrackingNumberRange = new Range(low, high);
		this.deleted = false;
	}
	
	public String findStringFromTrackingNumber(){
		return TrackingNumberRange.getLo() + " "+TrackingNumberRange.getHi() + " "+this.statusCode + " "+this.transferCode;
	}
	
	public List<TrackingNumber> compare(TrackingNumber anotherTrackingNumber) 
	{
		List<TrackingNumber> newTrackingNumberRows = new ArrayList<TrackingNumber>();
		
		Relation relation  = this.TrackingNumberRange.classify(anotherTrackingNumber.getR());
		if(relation==Relation.SAME)
		{
			anotherTrackingNumber.setDeleted(true);
			//newTrackingNumberRows.add(this);
		}
		else if(relation==Relation.SUPERSET)
		{
			anotherTrackingNumber.setDeleted(true);
			//newTrackingNumberRows.add(new TrackingNumber(this.TrackingNumberRange.getLo(), anotherTrackingNumber.getR().getLo()-1, this.statusCode, this.transferCode));
			//newTrackingNumberRows.add(anotherTrackingNumber);
			//newTrackingNumberRows.add(new TrackingNumber(anotherTrackingNumber.getR().getHi()+1, this.TrackingNumberRange.getHi(), this.statusCode, this.transferCode));
			
		}
		else if (relation==Relation.SUBSET)
		{
			if (this.statusCode == anotherTrackingNumber.statusCode && this.transferCode == anotherTrackingNumber.transferCode) {
				this.setDeleted(true);
			} else {
				this.setDeleted(true);
				anotherTrackingNumber.setDeleted(true);
				newTrackingNumberRows.add(new TrackingNumber(anotherTrackingNumber.getR().getLo(), this.getR().getLo()-1, anotherTrackingNumber.statusCode, anotherTrackingNumber.transferCode));
				newTrackingNumberRows.add(new TrackingNumber(this.getR().getLo(), this.getR().getHi(), this.statusCode, this.transferCode));
				newTrackingNumberRows.add(new TrackingNumber(this.getR().getHi()+1, anotherTrackingNumber.getR().getHi(), anotherTrackingNumber.statusCode, anotherTrackingNumber.transferCode));
			}
			//newTrackingNumberRows.add(anotherTrackingNumber);
		}
		else if(relation == Relation.LESSOVERLAP)
		{
			this.setDeleted(true);
			anotherTrackingNumber.setDeleted(true);
			//newTrackingNumberRows.add(anotherTrackingNumber);
			newTrackingNumberRows.add(new TrackingNumber(this.getR().getLo(), this.getR().getHi(), this.statusCode, this.transferCode));
			newTrackingNumberRows.add(new TrackingNumber(this.getR().getHi()+1, anotherTrackingNumber.getR().getHi(), anotherTrackingNumber.statusCode, anotherTrackingNumber.transferCode));
			
		}
		else if(relation==Relation.MOREOVERLAP)
		{
			this.setDeleted(true);
			anotherTrackingNumber.setDeleted(true);
			//newTrackingNumberRows.add(anotherTrackingNumber);
			newTrackingNumberRows.add(new TrackingNumber(anotherTrackingNumber.getR().getLo(), this.getR().getLo()-1, anotherTrackingNumber.statusCode, anotherTrackingNumber.transferCode));
			newTrackingNumberRows.add(new TrackingNumber(this.getR().getLo(), this.getR().getHi(), this.statusCode, this.transferCode));
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
		return TrackingNumberRange;
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
