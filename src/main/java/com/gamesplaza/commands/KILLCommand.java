package com.gamesplaza.commands;

import com.enjin.gamesplazabrasil.GamesPlaza;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by enzob on 13/01/2017.
 */
public class KILLCommand implements CommandExecutor {


    GamesPlaza plugin;

    public KILLCommand (GamesPlaza plugin){

        this.plugin = plugin;

    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player p = (Player) sender;


    if(command.getName().equalsIgnoreCase("kill")){
        if(!(p.hasPermission("player.action.kill"))){

            p.sendMessage(ChatColor.BLUE + "Matar> " + ChatColor.RED  + "Voce nao tem permissao!");
            return true;

        }
        if(p.hasPermission("player.action.kill")){

            if(args.length == 0){
                p.sendMessage(ChatColor.DARK_RED + "Matar> " + ChatColor.RED + "Para matar um player use /kill <player> , por exemplo, /kill Pedro");
                return true;

            }
            if(args.length > 1){
                p.sendMessage(ChatColor.DARK_RED + "Matar> " + ChatColor.RED + "Para matar um player use /kill <player> , por exemplo, /kill Pedro");
                return true;
            }
            if(args.length == 1){

                    Player targert = Bukkit.getPlayer(args[0]);
                    p.sendMessage(ChatColor.BLUE + "Matar> " + ChatColor.GREEN +  "O player " + ChatColor.DARK_PURPLE + targert.getName() + ChatColor.GREEN + "foi morto");
                    targert.sendMessage(ChatColor.GOLD + "Matar> " + ChatColor.AQUA + "O player " + ChatColor.DARK_PURPLE + p.getName() + ChatColor.AQUA + " te matou :P");
                    targert.setHealth(0);
            return true;
            }


        }



    }

        return false;
    }
}
