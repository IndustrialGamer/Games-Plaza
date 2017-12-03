package com.gamesplaza.commands;

import com.enjin.gamesplazabrasil.GamesPlaza;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by enzob on 31/12/2016.
 */
public class LocateCommand implements CommandExecutor {



    GamesPlaza plugin;

    public LocateCommand (GamesPlaza plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equalsIgnoreCase("localizar")){

            Player p = (Player) sender;
            if(args.length == 0){
                p.sendMessage(ChatColor.BLUE + "Localizacao> " + ChatColor.RED + "Voce precisa específicar um player para podermos encontra-lo!");
                return true;

            }
            if(args.length == 1){

          for(Player target : Bukkit.getOnlinePlayers()) {

              double x = target.getLocation().getX();
              double y = target.getLocation().getY();
              double z = target.getLocation().getZ();
              String world = target.getWorld().getName();

              p.sendMessage(ChatColor.BLUE + "Localizacao> " + ChatColor.GREEN + "O player " + ChatColor.DARK_PURPLE + target.getName() + ChatColor.GREEN + " esta nas localizacoes: ");
                p.sendMessage(ChatColor.DARK_PURPLE + "Mundo: " + world);
                p.sendMessage(ChatColor.DARK_PURPLE + "X: " + x);
                p.sendMessage(ChatColor.DARK_PURPLE + "Y: " + y);
                p.sendMessage(ChatColor.DARK_PURPLE + "Z: " + z);
              if(target == null){
                  p.sendMessage(ChatColor.BLUE + "Localizacao> " + ChatColor.RED + "Nao conseguimos localizar o player, pois ele está offline!");
              }

          }
            }


        }

        return false;
    }
}
