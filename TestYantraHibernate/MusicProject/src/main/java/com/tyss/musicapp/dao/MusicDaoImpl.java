package com.tyss.musicapp.dao;

import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.tyss.musicapp.dto.MusicDto;

public class MusicDaoImpl implements MusicDAO{
	EntityManagerFactory entityManagerFactory=null;
	EntityManager entityManager=null;
	EntityTransaction transaction=null;
	
    public MusicDaoImpl(){
    	entityManagerFactory=Persistence.createEntityManagerFactory("TestPersistence");
    	entityManager=entityManagerFactory.createEntityManager();
    	transaction=entityManager.getTransaction();	
    }
    
	public boolean createMusic(MusicDto music) {
		try {
			transaction.begin();
			entityManager.persist(music);
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	protected void finalize() throws Throwable {
		if(entityManager!=null) {
			entityManager.close();
		}
	}

	public boolean updateMusic(MusicDto music) {
		MusicDto updateMusic=entityManager.find(MusicDto.class,music.getSongId());
		if(updateMusic!=null) {
			transaction.begin();
			updateMusic.setSongTitle(music.getSongTitle());
			updateMusic.setArtistName(music.getArtistName());
			transaction.commit();
			return true;
		}else {
			return false;
		}
	}
    
	public boolean deleteMusic(int songId) {
		MusicDto deleteMusic=entityManager.find(MusicDto.class,songId);
		if(deleteMusic!=null) {
			transaction.begin();
			entityManager.remove(deleteMusic);
			transaction.commit();
			return true;
		}else {
			return false;
		}
	}

	public List<MusicDto> showAllSong() {
		Query query=entityManager.createQuery("from MusicDto");
		return query.getResultList();
	}

	public MusicDto palyRandomSong() {
		Random random=new Random();
		int rand=random.nextInt(5);
		return entityManager.find(MusicDto.class,rand);
	}

	public MusicDto playParticularSong(String songTitle) {
		Query query=entityManager.createQuery("from MusicDto where songTitle=:songTitle");
		query.setParameter("songTitle", songTitle);
		return (MusicDto)query.getSingleResult();
	}
}
