package com.tyss.musicapp.dao;

import java.util.List;

import com.tyss.musicapp.dto.MusicDto;

public interface MusicDAO {
	public boolean createMusic(MusicDto music);
	public boolean updateMusic(MusicDto music);
	public boolean deleteMusic(int songId);
	public List<MusicDto> showAllSong();
	public MusicDto palyRandomSong();
	public MusicDto playParticularSong(String songTitle);
}
