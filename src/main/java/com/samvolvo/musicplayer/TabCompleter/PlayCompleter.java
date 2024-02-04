package com.samvolvo.musicplayer.TabCompleter;

import com.samvolvo.musicplayer.Managers.SongManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class PlayCompleter implements TabCompleter {

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {

        if (args.length == 1) {
            return new ArrayList<>(SongManager.getSongNames());
        }
        return null;
    }
}
