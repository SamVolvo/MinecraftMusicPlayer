package com.samvolvo.musicplayer.Managers;

import com.samvolvo.musicplayer.MusicPlayer;
import com.xxmicloxx.NoteBlockAPI.event.SongEndEvent;
import com.xxmicloxx.NoteBlockAPI.model.Song;
import com.xxmicloxx.NoteBlockAPI.songplayer.RadioSongPlayer;
import com.xxmicloxx.NoteBlockAPI.songplayer.SongPlayer;
import com.xxmicloxx.NoteBlockAPI.utils.NBSDecoder;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.FilenameFilter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class SongManager implements Listener {

    private static HashMap<String, File> songs = getSongs();

    public static void playSong(String songName, Player player) throws SongNotFoundException{
        songName = songName + ".nbs";
        File file = songs.get(songName);

        if (file == null)throw new SongNotFoundException("Song does not exist: " + songName);

        RadioSongPlayer rsp = new RadioSongPlayer(NBSDecoder.parse(file));

        rsp.addPlayer(player);
        rsp.setPlaying(true);

        player.sendMessage("§e§lMusic§a§lPlayer§7: §ePlaying " + songName.replace(".nbs", ""));

    }

    public static void reloadSongs(){
        songs = getSongs();
    }

    public static Set<String> getSongNames(){
        Set<String> names = new HashSet<>();
        for (String name : songs.keySet()) {
            if (name.endsWith(".nbs")) {
                names.add(name.replace(".nbs", ""));
            }
        }
        return names;
    }

    private static HashMap<String, File> getSongs() {
        Plugin plugin = MusicPlayer.getPlugin();
        File dataFolder = plugin.getDataFolder();
        File songsFolder = new File(dataFolder, "songs");

        HashMap<String, File> songMap = new HashMap<>();
        if (songsFolder.exists()) {
            File[] songFiles = songsFolder.listFiles(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return name.endsWith(".nbs");
                }
            });

            if (songFiles != null) {
                for (File songFile : songFiles) {
                    songMap.put(songFile.getName(), songFile);
                }
            }
        }else{
            songsFolder.mkdir();
        }

        return songMap;
    }

    public void songEnd(SongEndEvent e){

        SongPlayer sp = e.getSongPlayer(); // get the songPlayer
        Song song = sp.getSong(); // gives you the player song

    }

}
