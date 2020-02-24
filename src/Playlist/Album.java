package Playlist;

import java.util.ArrayList;
import java.util.LinkedList;


public class Album {
    private String name;
    private String artists;
    private ArrayList<Playlist.Song> songs;

    public Album(String name, String artists) {
        this.name = name;
        this.artists = artists;
        this.songs = new ArrayList<>();
    }

    public boolean addSong(String title, double duration) {
        if (findSong(title) == null) {
            this.songs.add(new Playlist.Song(title, duration));
            return true;
        }
        return false;
    }

    private Playlist.Song findSong(String title) {
        //for each
        for (Playlist.Song checkedSong : this.songs) {
            if (checkedSong.getTitle().equals(title)) {
                return checkedSong;
            }
        }
        return null;
    }

    public boolean addToPlayList(int trackNumber, LinkedList<Playlist.Song> playlist) {
        int index = trackNumber - 1;
        if ((index > 0) && (index <= this.songs.size())) {
            playlist.add(this.songs.get(index));
            return true;
        }
        System.out.println("This album does not have a track " + trackNumber);
        return false;
    }

    public boolean addToPlayList(String title, LinkedList<Playlist.Song> playlist) {
        Playlist.Song checkedSong = findSong(title);
        if (checkedSong != null) {
            playlist.add(checkedSong);
            return true;
        }
        System.out.println("The song " + title + " is not in the album");
        return false;
    }


}

