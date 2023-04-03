package com.source;

import java.util.*;

public class Playlist {
    public static void main(String[] args) {
        // Create a LinkedList to represent the playlist
        LinkedList<String> playlist = new LinkedList<String>();
        
        // Set the initial capacity of the playlist to 3
        int initialCapacity = 3;
        
        // Add the first 3 songs to the playlist
        playlist.add("S1");
        playlist.add("S2");
        playlist.add("S3");
        
        // Loop through 4 additional songs to simulate user playback
        String[] additionalSongs = {"S4", "S2", "S1", "S5"};
        for (String song : additionalSongs) {
            // If the playlist is full, remove the first song
            if (playlist.size() == initialCapacity) {
                playlist.removeFirst();
            }
            // Add the new song to the end of the playlist
            playlist.add(song);
            // Print out the updated playlist
            System.out.println(playlist.toString());
        }
    }
}



