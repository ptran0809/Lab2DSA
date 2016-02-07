package lab2_v0;

public class Song {
    private String songName;
    private String artist;
    private float playtime;
    public String getSongName() {
        return songName;
    }
    public void setSongName(String songName) {
        this.songName = songName;
    }
    public String getArtist() {
        return artist;
    }
    public void setArtist(String artist) {
        this.artist = artist;
    }
    public float getPlaytime() {
        return playtime;
    }
    public void setPlaytime(float playtime) {
        this.playtime = playtime;
    }
    public Song(String songName, String artist, float playtime) {
	this.songName = songName;
	this.artist = artist;
	this.playtime = playtime;
    }
    public Song(String songName, String artist, double playtime) {
	this.songName = songName;
	this.artist = artist;
	this.playtime = (float)playtime;
    }
    private String float2Time(){
	int min = (int) Math.floor(this.playtime);
	int second = (int) Math.round((this.playtime - min)*60);
	return min+":"+second;
    }
    
    public boolean equals(Song s){
	return (this.songName.compareToIgnoreCase(s.getSongName())==0
		&& this.artist.compareToIgnoreCase(s.getArtist())==0
		&& this.playtime==s.getPlaytime());
    }
    public String toString(){
	return this.songName+".artist: "+ this.artist+", playtime: "+this.float2Time();
    }

}
