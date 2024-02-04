package com.samvolvo.musicplayer.Command;

import com.samvolvo.musicplayer.Managers.SongManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SongsCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player){
            if (args.length == 0){
                return false;
            }

            if (args[0].equalsIgnoreCase("reload")){
                SongManager.reloadSongs();
                sender.sendMessage("§e§lMusic§a§lPlayer§7: §eSongs reloaded!");
            }

        }

        return true;
    }
}
