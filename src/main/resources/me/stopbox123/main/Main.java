package me.stopbox123.main;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Animals;
import org.bukkit.entity.CreatureType;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Monster;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import de.kumpelblase2.remoteentities.EntityManager;
import de.kumpelblase2.remoteentities.RemoteEntities;
import de.kumpelblase2.remoteentities.api.RemoteEntity;
import de.kumpelblase2.remoteentities.api.RemoteEntityType;
import de.kumpelblase2.remoteentities.api.thinking.goals.DesireMoveAndMeleeAttack;
import de.kumpelblase2.remoteentities.entities.RemoteZombie;
import de.ntcomputer.minecraft.controllablemobs.api.ControllableMob;
import de.ntcomputer.minecraft.controllablemobs.api.ControllableMobs;
import de.ntcomputer.minecraft.controllablemobs.api.ai.behaviors.AIAttackMelee;
import de.ntcomputer.minecraft.controllablemobs.api.ai.behaviors.AITargetHurtBy;
import de.ntcomputer.minecraft.controllablemobs.api.ai.behaviors.AITargetNearest;

public class Main extends JavaPlugin implements Listener {
	
	Location sploc;
	
	private EntityManager manager;
	
	public void onEnable() {
		manager = RemoteEntities.createManager(this);
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(this, this);
		pm.registerEvents(new DamageEvent(), this);
		pm.registerEvents(new EntityRegenEvent(), this);
		pm.registerEvents(new AttackDamageMod(), this);
		pm.registerEvents(new PlayerDeathMinezEvent(), this);
		pm.registerEvents(new BandageListener(), this);
		pm.registerEvents(new AntiStackListener(), this);
		EntityManager manager = RemoteEntities.createManager(this);
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onSpawn(CreatureSpawnEvent ev) {
		Entity e = ev.getEntity();
		Location eLoc = ev.getLocation();
		/*
		* Everything that spawns will be a zombie
		*/
		if(ev.getSpawnReason() == SpawnReason.SPAWNER_EGG){

		ev.setCancelled(true);
		Zombie zombie = (Zombie) e.getWorld().spawnCreature(eLoc, CreatureType.ZOMBIE);
		/*zombie.setMaxHealth(1);
		zombie.setHealth(1);
		zombie.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 100000, 3));*/
		ControllableMob<Zombie> cZombie = ControllableMobs.assign(zombie, true);
		cZombie.getProperties().setMovementSpeed(0.45F);
		cZombie.getAI().addBehavior(new AIAttackMelee());
		cZombie.getAI().addBehavior(new AITargetHurtBy());
		cZombie.getAI().addBehavior(new AITargetNearest());
		cZombie.getEntity().setMaxHealth(25);
		cZombie.getEntity().setHealth(25);

		//e.getWorld().spawnCreature(eLoc, CreatureType.ZOMBIE);
		//RemoteEntity entity = manager.createEntity(RemoteEntityType.Zombie, eLoc, true); {
			//entity.getMind().addMovementDesire(new DesireMelee(entity, EntityHuman.class, false), 1);
		}
		}
	}
