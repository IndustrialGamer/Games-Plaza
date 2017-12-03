package com.enjin.gamesplazabrasil;

import com.gamesplaza.commands.ADMCommand;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.*;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.*;
import org.bukkit.inventory.ItemStack;

public class GamesPlazaEventos implements Listener {


    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){
        Player p = e.getPlayer();
        p.sendTitle(ChatColor.GOLD + "Bem-Vindo",  ChatColor.BOLD +   "ao Games Plaza");
        e.setJoinMessage(ChatColor.DARK_GRAY + "Entrou> " + ChatColor.GRAY +  e.getPlayer().getName());

    }
    @EventHandler
    public  void onPlayerQuit(PlayerQuitEvent e){

        e.setQuitMessage(ChatColor.DARK_GRAY + "Saiu> " + ChatColor.GRAY +  e.getPlayer().getName());
    }

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent e) {
        e.setCancelled(true);
    }


    @EventHandler
    public void onPlayerInteratcButton(PlayerInteractEvent e){
        if(e.getAction() != Action.RIGHT_CLICK_BLOCK){
            return;
        }

        if(e.getClickedBlock().getType() == Material.WOOD_BUTTON){
            e.setCancelled(true);
        }
        if(e.getClickedBlock().getType() == Material.STONE_BUTTON){
            e.setCancelled(true);
        }
    }

    @EventHandler (priority = EventPriority.LOWEST)
    public void onPlayerDeath(PlayerDeathEvent e){

    if(!e.getEntity().getLastDamageCause().equals(EntityDamageEvent.DamageCause.ENTITY_SWEEP_ATTACK) ) {
        e.setDeathMessage(ChatColor.BLUE + "Morte> " + ChatColor.DARK_PURPLE + "O player " + ChatColor.RED + e.getEntity().getName() + ChatColor.DARK_PURPLE + " foi morto por outro player - kkkk");
    }else{
        e.setDeathMessage(ChatColor.BLUE + "Morte> " + ChatColor.DARK_PURPLE + "O player " + ChatColor.RED + e.getEntity().getName() + ChatColor.DARK_PURPLE + " morreu - kkkk");
    }





    }
    @EventHandler
    public void onBlockBreak(BlockBreakEvent e){
        Player p = e.getPlayer();
        if(e.getPlayer().isOp()){
            e.setCancelled(false);

        } else
        if(!(e.getPlayer().isOp())){
            p.sendMessage(ChatColor.BLUE + "Quebrar> " + ChatColor.RED + "Voce nao pode quebrar blocos aqui" );
            e.setCancelled(true);


        } else
        if(p.hasPermission("block.server.break")){
            e.setCancelled(false);
        } else
        if(!(p.hasPermission("block.server.break"))){
            e.setCancelled(true);
        }
    }
    @EventHandler
    public void onBlockPlace(BlockPlaceEvent e){
        Player p = e.getPlayer();
        if(p.isOp()){
            e.setCancelled(false);
        } else
        if(!(p.isOp())){
            p.sendMessage(  ChatColor.BLUE + "Construir> " + ChatColor.RED + "Voce nao pode construir aqui!");
            ItemStack i = (ItemStack) e.getItemInHand();
            e.setCancelled(true);
            p.getInventory().addItem(new ItemStack(i));




        } else
        if(p.hasPermission("block.server.place")){
            e.setCancelled(false);
        } else
        if(!(p.hasPermission("block.server.place"))){
            p.sendMessage(  ChatColor.BLUE + "Construir> " + ChatColor.RED + "Voce nao tem permissao para construir aqui!");
            ItemStack i = (ItemStack) e.getItemInHand();
            e.setCancelled(true);
            p.getInventory().addItem(new ItemStack(i));


        }
    }

    // Cancela os damage de fogo - LavaParkour

    @EventHandler
    public void noFireTickDamage(EntityDamageEvent e){
        if(e.getEntity() instanceof  Player && e.getCause() == EntityDamageEvent.DamageCause.FIRE_TICK){
            e.setCancelled(true);
        }
    }



    @EventHandler
    public void noLavaDamage(EntityDamageEvent e){
        if(e.getEntity() instanceof  Player && e.getCause() == EntityDamageEvent.DamageCause.LAVA){
            e.setCancelled(true);
        }
    }
    @EventHandler
    public void noFireDamage(EntityDamageEvent e){
        if(e.getEntity() instanceof  Player && e.getCause() == EntityDamageEvent.DamageCause.FIRE){
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void playerOnFire(EntityDamageEvent e){

        Player p = (Player) e .getEntity();

        if(e.getEntity() instanceof Player && e.getCause() == EntityDamageEvent.DamageCause.FIRE_TICK){
            p.setFireTicks(0);
        }
    }

    @EventHandler (priority = EventPriority.LOWEST)
    public void onLeaveFall(LeavesDecayEvent e){



        e.setCancelled(true);
    }




}
