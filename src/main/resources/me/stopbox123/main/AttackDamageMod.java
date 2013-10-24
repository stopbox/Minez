package me.stopbox123.main;

import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

public class AttackDamageMod implements Listener {
	
	@EventHandler
	public void ondamage(EntityDamageByEntityEvent e) {

		if (e.getDamager() instanceof Zombie && e.getEntity() instanceof Player) {
			e.setDamage(4);
		}
		if (e.getDamager() instanceof Player) {
			Player player = (Player) e.getDamager();
			if (player.getItemInHand().getType() == Material.WOOD_SWORD) {
				player.getItemInHand().setDurability((short) (player.getItemInHand().getDurability() + 2));
			}
			if (e.getDamager() instanceof Player) {

				if (player.getItemInHand().getType() == Material.STONE_SWORD) {
					player.getItemInHand().setDurability((short) (player.getItemInHand().getDurability() + 2));
				}
		}
			if (e.getDamager() instanceof Player) {

				if (player.getItemInHand().getType() == Material.IRON_SWORD) {
					player.getItemInHand().setDurability((short) (player.getItemInHand().getDurability() + 4));
				}
		}
			if (e.getDamager() instanceof Player) {

				if (player.getItemInHand().getType() == Material.GOLD_SWORD) {
					player.getItemInHand().setDurability((short) (player.getItemInHand().getDurability() + 1));
				}
		}
			if (e.getDamager() instanceof Player) {

				if (player.getItemInHand().getType() == Material.DIAMOND_SWORD) {
					player.getItemInHand().setDurability((short) (player.getItemInHand().getDurability() + 12));
				}
			}
		}
				
				
	}
			@EventHandler
			public void blood(EntityDamageEvent e) {
				e.getEntity().getWorld().playEffect(e.getEntity().getLocation(), Effect.STEP_SOUND, Material.REDSTONE_WIRE.getId());
				e.getEntity().getWorld().playEffect(e.getEntity().getLocation(), Effect.STEP_SOUND, Material.REDSTONE_WIRE.getId());
				e.getEntity().getWorld().playEffect(e.getEntity().getLocation(), Effect.STEP_SOUND, Material.REDSTONE_WIRE.getId());
				e.getEntity().getWorld().playEffect(e.getEntity().getLocation(), Effect.STEP_SOUND, Material.REDSTONE_WIRE.getId());
			}
	
	}

