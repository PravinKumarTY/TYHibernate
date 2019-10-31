package com.tyss.musicapp.testapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import com.tyss.musicapp.dao.MusicDAO;
import com.tyss.musicapp.dao.MusicDaoImpl;
import com.tyss.musicapp.dto.MusicDto;

public class MusicTestClass {

	public static void main(String[] args) {
		MusicDAO musicDao=new MusicDaoImpl();
		try {
			BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
			String continueOperation=null;
			do {
				System.out.println("Press 1 for Play songs");
				System.out.println("Press 2 for Search a song");
				System.out.println("Press 3 for Show All the songs");
				System.out.println("Press 4 for Perform operation for song");
				int choice=Integer.parseInt(input.readLine());
				switch (choice) {
				case 1:
					System.out.println("Press A for Play All Song");
					System.out.println("Press B for Play Random Song");
					System.out.println("Press C for Play Particular Song");
					char choiceForPlay=input.readLine().charAt(0);
					switch (choiceForPlay) {
					case 'A':
						List<MusicDto> musicList=musicDao.showAllSong();
						for(MusicDto music:musicList) {
							System.out.println("Song Id."+music.getSongId());
							System.out.println("Song Title.."+music.getSongTitle());
							System.out.println("Album name.."+music.getAlbumName());
							System.out.println("Artist name.."+music.getArtistName());
							System.out.println("***********");
						}
						break;
					case 'B':
						MusicDto randomMusic=musicDao.palyRandomSong();
						System.out.println("Song Id..:"+randomMusic.getSongId()+", Song Title..:"+randomMusic.getSongTitle()+", Album Name..:"+randomMusic.getAlbumName()+" and Artist name.:"+randomMusic.getArtistName());
						break;
					case 'C':
						System.out.println("Enter Song title to play.");
						MusicDto particularSong=musicDao.playParticularSong(input.readLine());
						System.out.println("Song Id..:"+particularSong.getSongId()+", Song Title..:"+particularSong.getSongTitle()+", Album Name..:"+particularSong.getAlbumName()+" and Artist name.:"+particularSong.getArtistName());
						break;
					default:
						System.out.println("Invalid Choice");
						break;
					}
					break;
				case 2:
					System.out.println("Enter Song title to search.");
					MusicDto particularSong=musicDao.playParticularSong(input.readLine());
					System.out.println("Song Id..:"+particularSong.getSongId()+", Song Title..:"+particularSong.getSongTitle()+", Album Name..:"+particularSong.getAlbumName()+" and Artist name.:"+particularSong.getArtistName());
					break;
				case 3:
					List<MusicDto> musicList=musicDao.showAllSong();
					for(MusicDto music:musicList) {
						System.out.println("Song Id."+music.getSongId());
						System.out.println("Song Title.."+music.getSongTitle());
						System.out.println("Album name.."+music.getAlbumName());
						System.out.println("Artist name.."+music.getArtistName());
						System.out.println("*********");
					}
					break;
				case 4:
					System.out.println("Press A for Insert a Song");
					System.out.println("Press B for Update a Song");
					System.out.println("Press C for Delete a Song");
					char choiceOperation=input.readLine().charAt(0);
					MusicDto music=new MusicDto();
					switch (choiceOperation){
					case 'A':
						System.out.println("Enter Song Id.");
						music.setSongId(Integer.parseInt(input.readLine()));
						System.out.println("Enter Song Title.");
						music.setSongTitle(input.readLine());
						System.out.println("Enter Album name.");
						music.setAlbumName(input.readLine());
						System.out.println("Enter Artist name.");
						music.setArtistName(input.readLine());
						System.out.println("Enter Song Location.");
						music.setSongLocation(input.readLine());
						System.out.println("Enter Song Description.");
						music.setDescription(input.readLine());
						boolean createMusic=musicDao.createMusic(music);
						if(createMusic) {
							System.out.println("Song Created");
						}else {
							System.out.println("Song Not Created");
						}
						break;
					case 'B':
						System.out.println("Enter Song Id.");
						music.setSongId(Integer.parseInt(input.readLine()));
						System.out.println("Enter New Song Title");
						music.setSongTitle(input.readLine());
						System.out.println("Enter New Artist name");
						music.setArtistName(input.readLine());
						boolean updateMusic=musicDao.updateMusic(music);
						if(updateMusic) {
							System.out.println("Song Updated.");
						}else {
							System.out.println("Song not Updated.");
						}
						break;
					case 'C':
						System.out.println("Enter Song Id to Delete.");
						boolean deleteMusic=musicDao.deleteMusic(Integer.parseInt(input.readLine()));
						if(deleteMusic) {
							System.out.println("Song deleted..");
						}else {
							System.out.println("Song not found..");
						}	
						break;
					default:
						System.out.println("Invalid Choice");
						break;
					}
					break;
				default:
					System.out.println("Invalid Option.");
					break;
				}

				System.out.println("Press Y for continue and Press N for Exit");
				continueOperation=input.readLine();
				if(continueOperation.charAt(0)=='N') {
					break;
				}
			}while(continueOperation.charAt(0)=='Y'||continueOperation.charAt(0)=='y');
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
}
