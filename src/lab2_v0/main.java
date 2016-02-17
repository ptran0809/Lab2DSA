package lab2_v0;

import java.sql.Timestamp;
import java.util.Date;

public class main {

	public static void main(String[] args) {

		Song s1 = new Song("Yellow", "Cold Play", 2.4);
		Song s2 = new Song("Clocks", "Cold Play", 3.56);
		Song d1 = new Song("1", "Cold Play", 2.4);
		Song d2 = new Song("2", "Cold Play", 2.4);
		Song d3 = new Song("3", "Cold Play", 2.4);
		Song d4 = new Song("4", "Cold Play", 2.4);
		Song d5 = new Song("5", "Cold Play", 2.4);
		Song d6 = new Song("6", "Cold Play", 2.4);
//		System.out.println(s2);
//		Playlist p = new ArrayPlaylist("ColdPlayHits");
//		p.addSong(s1);
//		p.addSong(s2);
//		System.out.println(p.totalSongs());
//		System.out.println(p.playlistTime());
//		System.out.println(p);
//		System.out.println("+==================================================+");
//		p.removeSong(s2);
//		System.out.println(p);
//		System.out.println("+==================================================+");
//		System.out.println(p.totalSongs());
//		p.addSong(s2);
//		System.out.println(p);
//		System.out.println("+==================================================+");
//		System.out.println(p.isSongInPlaylist("clocks"));
//		p.songsByArtist("Cold play");
//		p.songsByArtist("Grease Monkey");
//		Song s3 = new Song("Around the Sun", "REM", 4.30);
		Playlist favorites = new ArrayPlaylist("favorites");
//		System.out.println(p);
//		System.out.println("+==================================================+");
		System.out.println(new Timestamp(System.currentTimeMillis()));
		addSongs(favorites,1000000);
		System.out.println(new Timestamp(System.currentTimeMillis()));
		addSongsRandom(favorites,500000);
		System.out.println(new Timestamp(System.currentTimeMillis()));
		retrieveRandom(favorites,500000);
		System.out.println(new Timestamp(System.currentTimeMillis()));
	}
	
	public static void addSongs(Playlist p,int numSong){
		for(int i=0;i<numSong;i++){
			p.addSong(new Song("Song "+i, "artist "+i, i/10));
		}
	}
	public static void addSongsRandom(Playlist p,int numSong){
		for(int i=0;i<numSong;i++){
			p.addSongAt(new Song("Song random"+i, "artist radom "+i, i%10), (int)Math.floor(Math.random()*p.totalSongs()));
		}
	}
	public static void retrieveRandom(Playlist p,int n){
		for(int i=0;i<n;i++){
			p.getSongAt((int)Math.floor(Math.random()*p.totalSongs()));
		}
	}
	
	public static void swapRandom(Playlist p,int n){
		for(int i=0;i<n;i++){
			p.moveSong(p.getSongAt((int)Math.floor(Math.random()*p.totalSongs())), (int)Math.floor(Math.random()*p.totalSongs()));
		}
	}
	
	public static void shift(Playlist p,int n) throws CloneNotSupportedException{
		for(int i=0;i<n;i++){
			p.moveAllSong((int)Math.floor(Math.random()*p.totalSongs()));
		}
	}

}
