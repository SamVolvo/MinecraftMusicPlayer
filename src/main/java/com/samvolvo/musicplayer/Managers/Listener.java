package com.samvolvo.musicplayer.Managers;
import com.xxmicloxx.NoteBlockAPI.songplayer.RadioSongPlayer;
import com.xxmicloxx.NoteBlockAPI.songplayer.SongPlayer;
import org.bukkit.entity.Player;
import java.util.List;

public class Listener {
    private List<Player> listeners;
    private List<SongPlayer> que;
    public void play(SongPlayer rsp){
        rsp.setPlaying(false);
        rsp.setLoop(true);
    }
}
