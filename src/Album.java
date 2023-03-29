import java.time.LocalDate;

public class Album {
    public int albumID;
    public String albumTitle;
    public int numSongs;

    public Album(int albumID, String title, int numSongs){
        this.albumID = albumID;
        this.albumTitle = title;
        this.numSongs = numSongs;

    }
}
