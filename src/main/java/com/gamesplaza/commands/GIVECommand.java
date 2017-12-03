package com.gamesplaza.commands;


import com.enjin.gamesplazabrasil.GamesPlaza;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/**
 * Created by enzob on 13/01/2017.
 */
public class GIVECommand implements CommandExecutor {

    GamesPlaza plugin;
    public GIVECommand (GamesPlaza plugin){
        this.plugin = plugin;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player p = (Player) sender;

        if(command.getName().equalsIgnoreCase("give")){


            if(!(p.hasPermission("server.inventory.add"))){
                p.sendMessage(ChatColor.BLUE + "Dar> " +  ChatColor.RED + "Voce nao pode usar esse comando!");
                return true;

            }
            if(p.hasPermission("server.inventory.add")){

                if(args.length == 0 ){

                    p.sendMessage(ChatColor.DARK_RED + "Dar> " + ChatColor.RED + "Para dar itens a um jogador use: /give <player> <item> <quantidade>, por exemplo, /give Pedro stone 1");
                    return true;
                }

                if(args.length > 3){
                    p.sendMessage(ChatColor.DARK_RED + "Dar> " + ChatColor.RED + "Para dar itens a um jogador use: /give <player> <item> <quantidade>, por exemplo, /give Pedro stone 1");
                    return  true;
                }
                if(args.length == 2){

                    p.sendMessage(ChatColor.DARK_RED + "Dar> " + ChatColor.RED + "Para dar itens a um jogador use: /give <player> <item> <quantidade>, por exemplo, /give Pedro stone 1");
                    return  true;
                }
                if(args.length == 1){
                    p.sendMessage(ChatColor.DARK_RED + "Dar> " + ChatColor.RED + "Para dar itens a um jogador use: /give <player> <item> <quantidade>, por exemplo, /give Pedro stone 1");
                    return true;
                }
                if(args.length == 3){

                    Player target = Bukkit.getPlayer(args[0]);
                    String item = args[1];
                    Integer qnt = Integer.parseInt(args[2].toString());
                    Inventory targInv = target.getInventory();

                    ItemStack itemS = new ItemStack(Material.matchMaterial(item));
                    ItemMeta itemSMeta = itemS.getItemMeta();


                    itemS.setItemMeta(itemSMeta);
                    itemS.setAmount(qnt);

                    target.sendMessage(ChatColor.BLUE + "Dar> " + ChatColor.GREEN  + "Voce acabou de dar o item " + ChatColor.DARK_PURPLE + item + ChatColor.GREEN + " para o Player " + ChatColor.DARK_PURPLE + target.getName());
                    targInv.addItem(itemS);


                return true;

                }


            }





        }


        return false;
    }
}
