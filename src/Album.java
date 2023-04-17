import java.util.ArrayList;

public class Album implements Comparable<Album>{
    public int albumID;
    public String albumTitle;
    public int numSongs;
    ArrayList<String> artistNames;

    public Album(int albumID, String albumTitle, int numSongs){
        this.albumID = albumID;
        this.albumTitle = albumTitle;
        this.numSongs = numSongs;
        this.artistNames = new ArrayList<String>();
    }

    public Album(int id, String title, int numSongs, ArrayList<String> artist) {
        this.albumID = id;
        this.albumTitle = title;
        this.numSongs = numSongs;
        this.artistNames = artist;
    }

    // Add artist name to artistNames arraylist
    public void addArtists(String artistName) {

        this.artistNames. add(artistName);
    }

    @Override
    public int compareTo(Album album2) {
        if (this.numSongs == album2.numSongs)
            return 0;
        else if (this.numSongs > album2.numSongs) {
            return 1;
        }
        else {
            return -1;
        }
    }

//    public String getNameString(){
//        StringBuilder stb = new StringBuilder();
//        for(int i = 0; i< artistNames.size()-1; i++){
//            stb.append(String.format("%s, ",artistNames.get(i)));
//        }
//        stb.append(String.format("%s",artistNames.get(artistNames.size()-1)));
//        return stb.toString();
//    }

    @Override
    public String toString() {
        StringBuilder stb = new StringBuilder();
        stb = stb.append("Album ID: " + this.albumID);
        stb = stb.append("/nNumber of Songs: " + this.numSongs);
        stb = stb.append("/nArtist Names: ");

        if (artistNames.size() > 0) {
            stb = stb.append(artistNames.toString());
        }
        else stb = stb.append("Artist Name Not Added.");
        return stb.toString();
    }
}


