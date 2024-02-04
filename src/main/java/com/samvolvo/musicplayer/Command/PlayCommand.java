package com.samvolvo.musicplayer.Command;

import com.samvolvo.musicplayer.Managers.SongManager;
import com.samvolvo.musicplayer.Managers.SongNotFoundException;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class PlayCommand implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){

            if (!(args.length > 0)){
                return false;
            }

            try {
                SongManager.playSong(String.join(" ", args), (Player) sender);
            } catch (SongNotFoundException e) {
                sender.sendMessage(e.getMessage());
            }

        }

        return true;
    }
}
