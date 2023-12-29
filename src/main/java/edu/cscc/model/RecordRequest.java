package edu.cscc.model;


public class RecordRequest {
	public RecordRequest() {}
	
	public RecordRequest(String title, String album, String label, int releaseYear, String recordSize, int trackAmount, boolean damaged ) {
		this.title = title;
		this.album = album;
		this.label = label;
		this.releaseYear = releaseYear;
		this.recordSize = recordSize;
		this.trackAmount = trackAmount;
		this.damaged = damaged;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	public String getRecordSize() {
		return recordSize;
	}

	public void setRecordSize(String recordSize) {
		this.recordSize = recordSize;
	}

	public int getTrackAmount() {
		return trackAmount;
	}

	public void setTrackAmount(int trackAmount) {
		this.trackAmount = trackAmount;
	}
	public boolean isDamaged() {
		return damaged;
	}

	public void setdamaged(boolean damaged) {
		this.damaged = damaged;
	}

	public String title;	
	public String album;
	public String label;
	public int releaseYear;
	public String recordSize;
	public int trackAmount;
	public boolean damaged;	

}
