package com.tyss.musicapp.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Song_Info")
public class MusicDto {
	@Id
	@Column
	private int songId;
	@Column
	private String albumName;
	@Column
	private String songTitle;
	@Column
	private String artistName;
	@Column
	private String songLocation;
	@Column
	private String description;
	public int getSongId() {
		return songId;
	}
	public void setSongId(int songId) {
		this.songId = songId;
	}
	public String getAlbumName() {
		return albumName;
	}
	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}
	public String getSongTitle() {
		return songTitle;
	}
	public void setSongTitle(String songTitle) {
		this.songTitle = songTitle;
	}
	public String getArtistName() {
		return artistName;
	}
	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}
	public String getSongLocation() {
		return songLocation;
	}
	public void setSongLocation(String songLocation) {
		this.songLocation = songLocation;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
