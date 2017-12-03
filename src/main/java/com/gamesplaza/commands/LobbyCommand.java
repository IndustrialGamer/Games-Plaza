package com.gamesplaza.commands;

import com.enjin.gamesplazabrasil.GamesPlaza;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class LobbyCommand implements CommandExecutor {


    GamesPlaza plugin;

    public LobbyCommand(GamesPlaza plugin) {

        this.plugin = plugin;
    }





    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        ArrayList<String> aliases = new ArrayList<>();
        String aliase = "hub";
        aliases.add(aliase);
        Player p = (Player) sender;

        //Comando lobby
        if (command.getName().equalsIgnoreCase("lobby")) {
            if (!(sender instanceof Player)) {
                p.sendMessage(ChatColor.BLUE + "Lobby> " + ChatColor.RED + "Apenas players podem se teleportar para o Lobby!");
                return true;
            }
               String lobby =  plugin.getConfig().getString("lobby");

            p.teleport(Bukkit.getWorld(lobby).getSpawnLocation());
            p.sendMessage(ChatColor.BLUE + "Lobby> " + ChatColor.GREEN + "Voce foi teleportado para o lobby principal!");

            command.setAliases(aliases);


        }

        return false;
    }



}