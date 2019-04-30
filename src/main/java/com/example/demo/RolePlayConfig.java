package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;


import com.example.demo.Monster.MonsterController;
import com.example.demo.Monster.MonsterInterface;
import com.example.demo.Monster.Monster_Orc;
import com.example.demo.Monster.Monster_Troll;
import com.example.demo.Monster.Monster_Goblin;

import com.example.demo.Treasure.TreasureController;
import com.example.demo.Treasure.TreasureInterface;
import com.example.demo.Treasure.Treasure_Big;
import com.example.demo.Treasure.Treasure_Small;

import com.example.demo.Gear.GearController;
import com.example.demo.Gear.GearInterface;
import com.example.demo.Gear.Gear;

@Configuration
public class RolePlayConfig {
	
	// @Bean(initMethod = "init", destroyMethod = "destroyed") 
	
	   @Bean(name = "hero")
	   public Hero Hero(){
	      return new Hero();
	   }

	   @Bean(name = "dungeon")
	   public Dungeon Dungeon(){
	      return new Dungeon( );
	   }
	   
	   
	   
	   @Bean(name = "treasureInterface")
	   public TreasureInterface TreasureInterface() {
		   return null;
	   }
	   
	   @Bean(name = "treasureController")
	   public TreasureController TreasureController() {
		   return new TreasureController();
	   }
	   
	   /*@Bean(name = "treasure_Big")
	   @Primary
	   public Treasure_Big Treasure_Big() {
		   return Treasure_Big();
	   }*/
	   
	   /*@Bean(name = "treasure_Small")
	   @Primary
	   public Treasure_Small Treasure_Small() {
		   return Treasure_Small();
	   }*/
	   
	   
	   
	   
	   
	   
	   @Bean(name = "monsterInterface")
	   public MonsterInterface MonsterInterface() {
		return null;
	   }
	   
	   @Bean(name = "monsterController")
	   public MonsterController MonsterController() {
		   return new MonsterController();
	   }
	   
	   @Bean(name = "monster_Orc")
	   public Monster_Orc Monster_Orc() {
		   return new Monster_Orc();
	   }
	   
	   @Bean(name = "monster_Goblin")
	   @Primary
	   public Monster_Goblin Monster_Goblin() {
		   return new Monster_Goblin();
	   }
	   
	   @Bean(name = "monster_Troll")
	   public Monster_Troll Monster_Troll() {
		   return new Monster_Troll();
	   }
	   
	   
	   
	   
	   @Bean(name = "gearInterface")
	   public GearInterface GearInterface() {
		return null;
	   }
	   
	   @Bean(name = "gearController")
	   public GearController GearController() {
		   return new GearController();
	   }
	   
	   @Bean(name = "gear")
	   @Primary
	   public Gear Gear() {
		   return new Gear();
	   }

}
