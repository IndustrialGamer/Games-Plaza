package com.gamesplaza.commands;

import com.enjin.gamesplazabrasil.GamesPlaza;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by enzob on 12/01/2017.
 */
public class TPCommand implements CommandExecutor {

    GamesPlaza plugin;

    public TPCommand(GamesPlaza plugin) {

        this.plugin = plugin;

    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player p = (Player) sender;


        if (command.getName().equalsIgnoreCase("tphere")) {


            if (!(p.hasPermission("server.teleport.tptoplayer"))) {
                p.sendMessage(ChatColor.DARK_RED + "Teleporte> " + ChatColor.RED + "Voce nao tem permissao!");

            }

            if (p.hasPermission("server.teleport.tptoplayer")) {
                if (args.length == 0) {
                    p.sendMessage(ChatColor.DARK_RED + "Teleporte> " + ChatColor.RED + "Para teleportar um player para voce use /tphere <Player>, por exemplo, /tphere Pedro");
                    return true;

                }

                if (args.length > 1) {
                    p.sendMessage(ChatColor.DARK_RED + "Teleporte> " + ChatColor.RED + "Para teleportar um player para voce use /tphere <Player>, por exemplo, /tphere Pedro");

                    return true;
                }

                if (args.length == 1) {

                    Player target = Bukkit.getPlayer(args[0]);

                    if (target == null) {

                        p.sendMessage(ChatColor.DARK_RED + "Teleporte> " + "O player " + target.getName() + " nao esta online!");
                        return true;
                    } else {
                        target.sendMessage(ChatColor.GOLD + "Teleporte> " + ChatColor.AQUA + "Voce foi teleportado para o player " + p.getName());
                        p.sendMessage(ChatColor.BLUE + "Teleporte> " + ChatColor.GREEN + "O player " + ChatColor.DARK_PURPLE + target.getName() + ChatColor.GREEN + " foi teleportado para voce com sucesso!");
                        target.teleport(p.getLocation());

                    }
                }

            }


        }
        if (command.getName().equalsIgnoreCase("tp")) {


            if (!(p.hasPermission("server.teleport.tpplayer"))){
                p.sendMessage(ChatColor.DARK_RED + "Teleporte> " + ChatColor.RED + "Voce nao tem permssao!");
            }


                if (p.hasPermission("server.teleport.tpplayer")) {
                    if (args.length == 0) {
                        p.sendMessage(ChatColor.DARK_RED + "Teleporte> " + ChatColor.RED + "Para teleportar para outro player use /tp <Player>, por exemplo, /tp Pedro");
                        return true;

                    }

                    if (args.length > 1) {
                        p.sendMessage(ChatColor.DARK_RED + "Teleporte> " + ChatColor.RED + "Para teleportar para outro player use /tp <Player>, por exemplo, /tp Pedro");

                        return true;
                    }

                    if (args.length == 1) {

                        Player target = Bukkit.getPlayer(args[0]);

                        if (target == null) {

                            p.sendMessage(ChatColor.DARK_RED + "Teleporte> " + ChatColor.RED + "O player " + target.getName() + " nao esta online!");
                            return true;
                        } else {
                            target.sendMessage(ChatColor.GOLD + "Teleporte> " + ChatColor.AQUA + "O player " + p.getName() + " se teleportou para voce!");
                            p.sendMessage(ChatColor.BLUE + "Teleporte> " + ChatColor.GREEN + "Voce foi teleportado para o player " + ChatColor.DARK_PURPLE + target.getName() + ChatColor.GREEN + " com sucesso!");
                            p.teleport(target.getLocation());

                        }
                    }

                }


        }
        return false;


    }
}
