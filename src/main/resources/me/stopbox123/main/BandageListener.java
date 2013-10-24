package me.stopbox123.main;

import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class BandageListener extends JavaPlugin implements Listener {
	
	@EventHandler
	public void bandage(PlayerInteractEvent e) {
		Player player = e.getPlayer();
		if(e.getPlayer().getItemInHand().getType() == Material.PAPER && e.getAction() == Action.RIGHT_CLICK_AIR) {
			Random rand = new Random();
			if (player.getHealth() == 20) {
				player.sendMessage(ChatColor.DARK_RED + "Well that was a waste.");
				
			    player.getInventory().removeItem(new ItemStack(Material.PAPER, 1));
			} else {
			
		player.setHealth(player.getHealth() + 2);
		player.getInventory().removeItem(new ItemStack(Material.PAPER, 1));
		if (player.getHealth() == 19) {
			player.setHealth(20);
			player.getInventory().removeItem(new ItemStack(Material.PAPER, 1));
		}
			}

		}
			}
}


