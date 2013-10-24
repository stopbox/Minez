package me.stopbox123.main;

import org.bukkit.entity.CreatureType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import de.ntcomputer.minecraft.controllablemobs.api.ControllableMob;
import de.ntcomputer.minecraft.controllablemobs.api.ControllableMobs;
import de.ntcomputer.minecraft.controllablemobs.api.ai.behaviors.AIAttackMelee;
import de.ntcomputer.minecraft.controllablemobs.api.ai.behaviors.AITargetHurtBy;
import de.ntcomputer.minecraft.controllablemobs.api.ai.behaviors.AITargetNearest;

@SuppressWarnings("deprecation")
public class PlayerDeathMinezEvent implements Listener {
	
	Main plugin = new Main();
	
	@EventHandler
	public void death(PlayerDeathEvent e) {
		Zombie zombie = (Zombie) e.getEntity().getWorld().spawnCreature(e.getEntity().getLocation(), CreatureType.ZOMBIE);
		//ItemStack PlayerHelm = new ItemStack(Material.SKULL_ITEM, 1);
		//ItemMeta meta = PlayerHelm.getItemMeta();
		//((CraftSkull)meta).setSkullType(SkullType.PLAYER);
		//((CraftSkull)meta).setOwner(e.getEntity().getName());
	     //PlayerHelm.setItemMeta(meta);
	     //zombie.getEquipment().setHelmet(PlayerHelm);
		Player player = (Player) e.getEntity();
          
		
		zombie.setCustomName(player.getName());
		zombie.setCustomNameVisible(true);
		ControllableMob<Zombie> cZombie = ControllableMobs.assign(zombie, true);
		cZombie.getProperties().setMovementSpeed(0.45F);
		cZombie.getAI().addBehavior(new AIAttackMelee());
		cZombie.getAI().addBehavior(new AITargetHurtBy());
		cZombie.getAI().addBehavior(new AITargetNearest());
		cZombie.getEntity().setMaxHealth(25);
		cZombie.getEntity().setHealth(25);
	
	}
     @EventHandler
     public void ondeath(EntityDeathEvent e) {
    	 if (e.getEntity() instanceof Zombie) {
    		 e.getDrops().clear();
    		 
    	 }
     }
}
