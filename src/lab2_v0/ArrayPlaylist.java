package lab2_v0;

public class ArrayPlaylist extends Playlist {
	String name;
//	MyArrayList<Song> songs;
	MyLinkedList<Song> songs;
	public ArrayPlaylist(String name) {
		this.name = name;
//		this.songs = new MyArrayList<Song>();
		this.songs = new MyLinkedList<Song>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean addSong(Song s) {
		try {
			this.songs.add(s);
			return true;
		} catch (Exception e) {
			throw e;
			// return false;
		}
	}

	public boolean addSongAt(Song s, int index) {
		try {
			this.songs.add(index, s);
			return true;
		} catch (Exception e) {

			return false;
		}
	}

	public Song getSongAt(int index) {
		try {
			return this.songs.get(index);
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e.getMessage());
			return null;
		}
	}

	public MyList<Song> getList() {
		return this.songs;
	}

	public boolean removeSong(Song s) {
		try {
			this.songs.remove(this.songs.indexOf(s));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public int totalSongs() {
		return this.songs.size();
	}

	public float playlistTime() {
		float playTime = 0;
		for (int i = 0; i < this.totalSongs(); i++) {
			playTime = playTime + this.getSongAt(i).getPlaytime();
		}
		return playTime;
	}

	public boolean isSongInPlaylist(String name, String artist) {
		for (int i = 0; i < this.totalSongs(); i++) {
			if (this.getSongAt(i).getSongName().compareToIgnoreCase(name) == 0
					&& this.getSongAt(i).getArtist().compareToIgnoreCase(artist) == 0) {
				return true;
			}
		}
		return false;
	}

	public boolean isSongInPlaylist(String name) {
		for (int i = 0; i < this.totalSongs(); i++) {
			if (this.getSongAt(i).getSongName().compareToIgnoreCase(name) == 0) {
				return true;
			}
		}
		return false;
	}

	public void songsByArtist(String name) {
		Song s;
		for (int i = 0; i < this.totalSongs(); i++) {
			s = this.getSongAt(i);
			if (s.getArtist().compareToIgnoreCase(name) == 0) {
				System.out.println(s);
			}
		}
	}

	public void addSongsFrom(Playlist p) {
		for (int i = 0; i < p.totalSongs(); i++) {
			this.addSong(p.getSongAt(i));
		}
	}
	public String toString(){
		String s = "";
		for(int i=0;i<this.songs.size();i++){
			s = s+this.songs.get(i).toString()+"\n";
		}
		return s;
	}

	@Override
	public void moveSong(Song s, int position) {
		this.songs.sway(this.songs.indexOf(s), position);
	}

	@Override
	public void moveAllSong(int position) throws CloneNotSupportedException {
		this.songs.shift(position);
	}

}
