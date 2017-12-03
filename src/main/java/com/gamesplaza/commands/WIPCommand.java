package com.gamesplaza.commands;

import com.enjin.gamesplazabrasil.GamesPlaza;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by enzob on 12/01/2017.
 */
public class WIPCommand implements CommandExecutor {


    GamesPlaza plugin;

    public WIPCommand (GamesPlaza plugin){
        plugin = plugin;

    }



    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equalsIgnoreCase("wip")){
            TextComponent mensagem = new TextComponent(ChatColor.DARK_RED + "WIP> " +  ChatColor.RED + "Esse plugin esta em desenvolvimento, e essa funcao WIP");
            TextComponent mensagem2 = new TextComponent( ChatColor.RED + " (Work in Progress)");
            ClickEvent mclick = new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/wip");
            HoverEvent mhover = new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Clique para ver essa mensagem de novo :)").create());
            mensagem.setClickEvent(mclick);
            mensagem.setHoverEvent(mhover);
            mensagem2.setClickEvent(mclick);
            mensagem2.setHoverEvent(mhover);
            Player p = (Player) sender;

            p.spigot().sendMessage(mensagem);
            p.sendMessage("");
            p.spigot().sendMessage(mensagem2);
        }

        return false;
    }
}
