package me.stopbox123.main;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

public class AntiStackListener implements Listener {
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void anti(org.bukkit.event.inventory.InventoryClickEvent e) {
		if (e.getCursor().getType() != null && e.getCursor().getType() == Material.PAPER && e.getCurrentItem() != null && e.getCurrentItem().getType() == Material.PAPER) {
 
        	e.setCancelled(true); 

        	}
         }
		   }
	   
	
	


