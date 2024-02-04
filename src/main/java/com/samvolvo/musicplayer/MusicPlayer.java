package com.samvolvo.musicplayer;

import com.samvolvo.musicplayer.Command.PlayCommand;
import com.samvolvo.musicplayer.Command.SongsCommand;
import com.samvolvo.musicplayer.Managers.SongManager;
import com.samvolvo.musicplayer.TabCompleter.PlayCompleter;
import com.samvolvo.musicplayer.TabCompleter.SongsTabCompleter;
import com.xxmicloxx.NoteBlockAPI.model.Song;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class MusicPlayer extends JavaPlugin {

    private static Plugin plugin;

    @Override
    public void onEnable() {
        // Plugin startup logic

        plugin = this;

        if (!this.getDataFolder().exists()){
            this.getDataFolder().mkdir();
        }

        SongManager.reloadSongs();


        getCommand("play").setExecutor(new PlayCommand());
        getCommand("play").setTabCompleter(new PlayCompleter());
        getCommand("songs").setExecutor(new SongsCommand());
        getCommand("songs").setTabCompleter(new SongsTabCompleter());

    }

    public static Plugin getPlugin() {
        return plugin;
    }
}
