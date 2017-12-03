package com.gamesplaza.commands;

import com.enjin.gamesplazabrasil.GamesPlaza;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PINGCommand implements CommandExecutor {


    GamesPlaza plugin;
    public PINGCommand (GamesPlaza plugin){

        this.plugin = plugin;

    }


    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command command, String label, String[] args) {

        Player p = (Player) sender;

        if (command.getName().equalsIgnoreCase("ping")){

            p.sendMessage(ChatColor.DARK_RED  + "" + ChatColor.BOLD + "PONG");


        }



        return false;
    }
}
