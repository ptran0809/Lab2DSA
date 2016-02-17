package lab2_v0;

public abstract class Playlist {
	public abstract String getName();

	public abstract void setName(String name);

	public abstract boolean addSong(Song s);

	public abstract boolean addSongAt(Song s, int index);

	public abstract Song getSongAt(int index);

	public abstract MyList<Song> getList();

	public abstract boolean removeSong(Song s);

	public abstract int totalSongs();

	public abstract float playlistTime();

	public abstract boolean isSongInPlaylist(String name, String artist);

	public abstract boolean isSongInPlaylist(String name);

	public abstract void songsByArtist(String name);

	public abstract void addSongsFrom(Playlist p);
	
	public abstract void moveSong(Song s, int position);
	
	public abstract void moveAllSong(int position) throws CloneNotSupportedException;
}
