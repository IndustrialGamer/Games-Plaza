package com.gamesplaza.commands;

import com.enjin.gamesplazabrasil.GamesPlaza;
import com.enjin.gamesplazabrasil.GamesPlazaEventos;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by enzob on 09/01/2017.
 */
public class TELLCommand implements CommandExecutor {

    GamesPlaza plugin;



   public TELLCommand(GamesPlaza plugin){
        this.plugin = plugin;
    }

String message = "";



    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;
if(command.getName().equalsIgnoreCase("tell")){
    if(args.length == 0){



        p.sendMessage(ChatColor.DARK_RED + "Mensagem Particular> " + ChatColor.RED  + "Digite o nome do jogador e em seguida a mensagem, por exemplo: ");
        p.sendMessage(ChatColor.RED + "/tell Pedro Oi! Vamos criar um grupo?");
        return true;
    }

    if(args.length == 1){

        p.sendMessage(ChatColor.DARK_RED + "Mensagem Particular> " + ChatColor.RED  + "Digite o nome do jogador e em seguida a mensagem, por exemplo: ");
        p.sendMessage(ChatColor.RED + "/tell Pedro Oi! Vamos criar um grupo?");

        return true;

    }else {

        for(int i = 1; i < args.length; i++) {

            message = message + args[1] + "";

            Player target = Bukkit.getPlayer(args[0]);


            TextComponent mp = new TextComponent(ChatColor.GOLD + "" + ChatColor.BOLD + p.getName() + " > " + target.getName() + " " + ChatColor.YELLOW + message);
            TextComponent bdenunciar = new TextComponent(ChatColor.GRAY + " - [Denunciar]");
            ClickEvent denunc = new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/wip");
            HoverEvent hdenunc = new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Clique aqui para denunciar esse player!").create());
            bdenunciar.setClickEvent(denunc);
            bdenunciar.setHoverEvent(hdenunc);


            p.spigot().sendMessage(mp);
            target.spigot().sendMessage(mp, bdenunciar);

        }
    }





}

        return false;
    }
}
