package com.gamesplaza.commands;

import com.enjin.gamesplazabrasil.GamesPlaza;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FakeCommand implements CommandExecutor {


    GamesPlaza plugin;

    public FakeCommand (GamesPlaza plugin){

        this.plugin = plugin;

    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(command.getName().equalsIgnoreCase("nick")){

try {
    Player p = (Player) sender;

    if (args.length == 0) {
        p.sendMessage(ChatColor.BLUE + "Disfarce> " + ChatColor.RED + "Use /nick <nomeFalso>");
        return true;
    }
    String nomeFalso = args[0];
    String nomeVerdadeiro = p.getName();
    if (args.length == 1) {


        p.setDisplayName(nomeFalso);
        p.setPlayerListName(nomeFalso);
        p.setCustomName(nomeFalso);
        p.setCustomNameVisible(true);
        sender.sendMessage(ChatColor.BLUE + "Disfarce> " + ChatColor.GREEN + "Seu nome foi alterado com sucesso!");

        Bukkit.broadcastMessage(ChatColor.DARK_GRAY + "Saiu> " + ChatColor.GRAY + nomeVerdadeiro);
        Bukkit.broadcastMessage(ChatColor.DARK_GRAY + "Entrou> " + ChatColor.GRAY + nomeFalso);
    }

    if(args[0].equalsIgnoreCase("reset")){

        p.setDisplayName(nomeVerdadeiro);
        p.setPlayerListName(nomeVerdadeiro);
        p.setCustomName(nomeVerdadeiro);
        p.setCustomNameVisible(false);
        sender.sendMessage(ChatColor.BLUE + "Disfarce> " + ChatColor.GREEN + "Seu nome resetado! Coloque sua antiga tag com /tag");
    }

}catch (Exception e){
    e.getStackTrace();
    sender.sendMessage(ChatColor.BLUE + "Disfarce> " + ChatColor.GREEN + "Seu nome foi alterado com sucesso!");


}

        }

        return false;
    }
}
