package com.company;

import java.util.*;

public class Main {
    private static ArrayList<Album> albums = new ArrayList<Album>();

    public static void main(String[] args) {
        Album album = new Album("Stormbringer", "Deep Purple");
        album.addSong("Stormbringer", 4.6);
        album.addSong("Love don't mean a thing", 4.22);
        album.addSong("Holy man", 4.3);
        album.addSong("Hold on", 5.6);
        album.addSong("Lady double dealer", 3.21);
        album.addSong("You cant do it right", 6.23);
        album.addSong("High ball shooter", 4.25);
        album.addSong("The gypsy", 4.6);
        album.addSong("Solder of fortune", 3.13);
        albums.add(album);

        album = new Album("For those about to rock", "AC/DC");
        album.addSong("For those about to rock", 5.44);
        album.addSong("I put the finger on you", 4.22);
        album.addSong("Lets go", 4.3);
        album.addSong("Inject the venom", 5.6);
        album.addSong("Snowballed", 3.21);
        album.addSong("Evil walks", 6.23);
        album.addSong("C.O.D", 4.25);
        album.addSong("Breaking the rules", 4.6);
        album.addSong("Night of the long knives", 3.13);
        albums.add(album);

        LinkedList<Song> playList = new LinkedList<Song>();
        albums.get(0).addToPlaylist("You cant do it right", playList);
        albums.get(0).addToPlaylist("Holy man", playList);
        albums.get(0).addToPlaylist("Speed King", playList); // dosnt exist
        albums.get(0).addToPlaylist(9, playList);
        albums.get(1).addToPlaylist(8, playList);
        albums.get(1).addToPlaylist(3, playList);
        albums.get(1).addToPlaylist(2, playList);
        albums.get(1).addToPlaylist(24, playList); // doesnt exist
        play(playList);


    }

    private static void play(LinkedList<Song> playList) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean goingForward = true;
        ListIterator<Song> listIterator = playList.listIterator();
        if (playList.size() == 0) {
            System.out.println("No songs in playlist");
        } else {
            System.out.println("Now playing " + listIterator.next());
            printMenu();
        }

        while (!quit) {
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 0 -> {
                    System.out.println("Quitting...");
                    quit = true;
                }
                case 1 -> {
                    if (!goingForward) {
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        goingForward = true;
                    }
                    if (listIterator.hasNext()) {
                        System.out.println("Now playing " + listIterator.next());
                    } else {
                        System.out.println("Reached to the end of the playlist");
                        goingForward = false;
                    }
                }
                case 2 -> {
                    if (goingForward) {
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        goingForward = false;
                    }
                    if (listIterator.hasPrevious()) {
                        System.out.println("Now playing " + listIterator.previous());
                    } else {
                        System.out.println("You are on the top of the playlist");
                        goingForward = true;
                    }
                }
                case 3 -> {
                    if(goingForward){
                        if(listIterator.hasPrevious()){
                            System.out.println("Now replaying " + listIterator.previous());
                            goingForward = false;
                        }else{
                            System.out.println("We are at the start of the list");
                        }
                    }else{
                        if(listIterator.hasNext()){
                            System.out.println("Now replaying " + listIterator.next());
                            goingForward = true;
                        }else{
                            System.out.println("We have reached the end of the list");
                        }
                    }

                }
                case 4 ->{
                    printPlaylist(playList);
                }
                case 5 -> {
                    printMenu();
                }

                case 6 ->{
                    if(playList.size() > 0){
                        listIterator.remove();
                        if(listIterator.hasNext()){
                            System.out.println("Now replaying " + listIterator.next());
                        }else if(listIterator.hasPrevious()){
                            System.out.println("Now replaying " + listIterator.previous());
                        }
                    }
                }


            }
        }
    }

    private static void printMenu(){
            System.out.println("Available actions:\npress ");
            System.out.println("0 - to quit\n" +
                    "1 - go to next song\n"+
                    "2 - go to previous song\n" +
                    "3 - To replay song\n"+
                    "4 - list songs in the playlist\n" +
                    "5 - print menu options\n" +
                    "6 - To remove song");
        }

    private static void printPlaylist(LinkedList<Song> playList){
        Iterator<Song> i = playList.iterator();
        System.out.println("*****************");
        while(i.hasNext()){
            System.out.println("now playing " + i.next());
        }
        System.out.println("*****************");
    }

}


