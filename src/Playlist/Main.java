package Playlist;

import java.util.*;

public class Main {

    private static ArrayList<Album> albums = new ArrayList<>();

    public static void main(String[] args) {
        Album album = new Album("StormBringer", "Deep Purple");
        album.addSong("StormBringer", 4.6);
        album.addSong("Love dont mean a thing", 8.6);
        album.addSong("Holy man", 4.6);
        album.addSong("Ifunanya", 2.6);
        album.addSong("Soldier go", 5.3);
        album.addSong("Jamb question", 3.7);
        album.addSong("Crazy stupid love", 3.3);
        album.addSong("The gypsy", 3.3);
        album.addSong("The soldier of fortune", 3.3);
        albums.add(album);

        album = new Album("For those about to rock", "AC/DC");
        album.addSong("For those about to rock", 4.6);
        album.addSong("I put the finger on you", 8.6);
        album.addSong("Let go", 4.6);
        album.addSong("Inject the venom", 2.6);
        album.addSong("Snowballed", 5.3);
        album.addSong("Evil walks", 3.7);
        album.addSong("C.O.D", 3.3);
        album.addSong("The breaking of the rules", 3.3);
        album.addSong("The night of the long knives", 3.3);
        albums.add(album);

        LinkedList<Song> playlist = new LinkedList<>();
        albums.get(0).addToPlayList("Ifunanya", playlist);
        albums.get(0).addToPlayList("Soldier go", playlist);
        albums.get(0).addToPlayList("Jamb question", playlist);
        albums.get(0).addToPlayList("Jamb question no dey", playlist);// Does not exist
        albums.get(0).addToPlayList(9, playlist);
        albums.get(1).addToPlayList(8, playlist);
        albums.get(1).addToPlayList(5, playlist);
        albums.get(1).addToPlayList(3, playlist);
        albums.get(1).addToPlayList(4, playlist);
        albums.get(1).addToPlayList(24, playlist);// No track 24

        play(playlist);


    }

    private static void play(LinkedList<Song> playlist){
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = playlist.listIterator();
        if(playlist.size() == 0){
            System.out.println("No songs in playlist");
            return;
        }else{
            System.out.println("Now playing " + listIterator.next().toString());
            printMenu();
        }

        while (!quit){
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action){
                case 0:
                    System.out.println("Playlist complete");
                    quit = true;
                    break;
                case 1:
                    if(!forward){
                        if(listIterator.hasNext()){
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if(listIterator.hasNext()){
                        System.out.println("Now playing " + listIterator.next().toString());
                    }else{
                        System.out.println("We have reached the end of the playlist");
                        forward = false;
                    }
                    break;
                case 2:
                    if(forward){
                        if(listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if(listIterator.hasPrevious()){
                        System.out.println("Now playing " + listIterator.previous().toString());
                    }else{
                        System.out.println("We are at the start of the playlist");
                        forward = true;
                    }
                    break;
                case 3:
                    if(forward){
                        if(listIterator.hasPrevious()){
                            System.out.println("Now replaying " + listIterator.previous().toString());
                            forward=false;
                        }else {
                            System.out.println("We are at the start of the list");
                        }
                    }else{
                        if(listIterator.hasNext()){
                            System.out.println("Now replaying " + listIterator.next().toString());
                            forward = true;
                        }else{
                            System.out.println("We have reached the end of the list");
                        }
                    }
                    break;
                case 4:
                    printList(playlist);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    if(playlist.size()>0){
                        listIterator.remove();
                        if(listIterator.hasNext()){
                            System.out.println("Now playing " + listIterator.next());
                        }else if(listIterator.hasNext()){
                            System.out.println("Now playing " + listIterator.previous());
                        }
                    }
                    break;

            }
        }

    }

    private static void printMenu(){
        System.out.println("Available actions: \n press");
        System.out.println("0 - to quit \n" +
                "1 - to play next song \n" +
                "2 - to play previous song \n" +
                "3 - to replay the current song \n" +
                "4 - list songs in the playlist \n" +
                "5 - print available actions.\n" +
                "6 - delete current song from playlist.");
    }

    private static void printList(LinkedList<Song> playlist){
        Iterator<Song> iterator = playlist.iterator();
        System.out.println("================================");
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("================================");
    }
}
