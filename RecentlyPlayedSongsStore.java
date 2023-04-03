package com.source;

import java.util.LinkedHashMap;
import java.util.Map;

public class RecentlyPlayedSongsStore {
    private static int capacity;
    private static Map<String, LinkedHashMap<String, Long>> store;

    public RecentlyPlayedSongsStore(int capacity) {
        this.capacity = capacity;
        this.store = new LinkedHashMap<>();
    }

    public static void addSong(String user, String song, long timestamp) {
        LinkedHashMap<String, Long> userSongs = store.computeIfAbsent(user, k -> new LinkedHashMap<>());

        // Remove the song if it already exists
        userSongs.remove(song);

        // Add the new song at the beginning of the list
        userSongs.put(song, timestamp);

        // If the list exceeds the capacity, remove the least recently played song
        if (userSongs.size() > capacity) {
            userSongs.remove(userSongs.keySet().iterator().next());
        }
    }

    public String[] getRecentlyPlayedSongs(String user) {
        LinkedHashMap<String, Long> userSongs = store.get(user);

        if (userSongs == null) {
            return new String[0];
        }

        return userSongs.keySet().toArray(new String[0]);
    }
}

