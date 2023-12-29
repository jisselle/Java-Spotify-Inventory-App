package edu.cscc.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
@Entity
public class Record {
	public Record() {}
	
	public Record(long id, String title, String artist, String label, int releaseYear, int trackAmount, String recordSize, boolean isDamaged) {
		this.id = id;
		this.title = title;
		this.artist = artist;
		this.label = label;
		this.releaseYear = releaseYear;
		this.trackAmount = trackAmount;
		this.recordSize = recordSize;
		this.isDamaged = isDamaged;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
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

	public int getTrackAmount() {
		return trackAmount;
	}

	public void setTrackAmount(int trackAmount) {
		this.trackAmount = trackAmount;
	}

	public String getRecordSize() {
		return recordSize;
	}

	public void setRecordSize(String recordSize) {
		this.recordSize = recordSize;
	}
	public boolean isDamaged() {
		return isDamaged;
	}

	public void setDamaged(boolean damaged) {
		this.isDamaged = damaged;
	}

	@Id
	@GeneratedValue(generator = "PROFILE_SEQ",strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name = "PROFILE_SEQ",allocationSize=1)
	public Long id;
	
	@Size(max=50, message="Please enter a title that is up to 50 characters in length.")
	@NotEmpty(message="Please enter a title.")
	public String title;
	
	@Size(max=40, message="Please enter a artist that is up to 40 characters in length.")
	@NotEmpty(message="Please enter a artist.")
	public String artist;
	
	@Size(max=40, message="Please enter a label that is up to 40 characters in length.")
	@NotEmpty(message="Please enter a label.")
	public String label;
	
	@Min(value = 1930, message = "Please enter a year released that is on or after 1930.")
	public int releaseYear;
	
	@Min(value = 1, message="Please enter a number of tracks that is between 1-20.")
	@Max(value = 20, message="Please enter a number of tracks that is between 1-20.")
	public int trackAmount;
	
	
	public String recordSize;
	public boolean isDamaged;
}
