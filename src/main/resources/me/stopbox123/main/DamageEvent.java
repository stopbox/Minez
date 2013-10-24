package me.stopbox123.main;

import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class DamageEvent extends JavaPlugin implements Listener {
	
	@EventHandler
	public void ondamage(EntityDamageEvent e) {
		if (e.getEntity() instanceof Zombie) {
			final Zombie zombie = (Zombie) e.getEntity();
		    zombie.setVelocity(zombie.getLocation().getDirection().multiply(-1));
		    
		}
	}
		@EventHandler
		public void burning(org.bukkit.event.entity.EntityCombustEvent e) {
	       if (e.getEntity() instanceof Zombie) {
	    	   e.setCancelled(true);
		}
	}

}
