package com.example.demo;

import org.springframework.stereotype.Component;
import org.springframework.context.ApplicationContext;

import com.example.demo.Gear.Gear;
import com.example.demo.Gear.GearController;
import com.example.demo.Monster.MonsterController;
import com.example.demo.Treasure.TreasureController;

@Component
public class Dungeon {
	
	public static int[][] field = {{-1,-1,-1,-1,-1,-1,-1},
								   {-1,0,0,2,0,0,-1},
								   {-1,0,0,0,0,3,-1},
								   {-1,0,0,1,0,3,-1},
								   {-1,0,0,0,0,3,-1},
								   {-1,0,0,0,0,0,-1},
								   {-1,-1,-1,-1,-1,-1,-1}};;
	
	public Dungeon() {
		//setField();
	}
	
	public static void printField() {
		System.out.println(String.valueOf(Dungeon.field[1][1]) + String.valueOf(Dungeon.field[1][2]) + String.valueOf(Dungeon.field[1][3]) + String.valueOf(Dungeon.field[1][4]) + String.valueOf(Dungeon.field[1][5]) + "\n" +
				String.valueOf(Dungeon.field[2][1]) + String.valueOf(Dungeon.field[2][2]) + String.valueOf(Dungeon.field[2][3]) + String.valueOf(Dungeon.field[2][4]) + String.valueOf(Dungeon.field[2][5]) + "\n" +
				String.valueOf(Dungeon.field[3][1]) + String.valueOf(Dungeon.field[3][2]) + String.valueOf(Dungeon.field[3][3]) + String.valueOf(Dungeon.field[3][4]) + String.valueOf(Dungeon.field[3][5]) + "\n" +
				String.valueOf(Dungeon.field[4][1]) + String.valueOf(Dungeon.field[4][2]) + String.valueOf(Dungeon.field[4][3]) + String.valueOf(Dungeon.field[4][4]) + String.valueOf(Dungeon.field[4][5]) + "\n" +
				String.valueOf(Dungeon.field[5][1]) + String.valueOf(Dungeon.field[5][2]) + String.valueOf(Dungeon.field[5][3]) + String.valueOf(Dungeon.field[5][4]) + String.valueOf(Dungeon.field[5][5])  );
	}
	
	// Getter
	public static int[][] getField(){
		return field;
	}
	
	// Find the position of the Player in the Dungeon
	public static int[] findPlayer() {
		
		int[][] field = Dungeon.field;
		int posX;
		int posY;
		int[] playerPosition = {-1,-1};
		
		// The field might not have been initialized
		if(field != null) {
			
			posX = -1;
			posY = -1;
			
			for (int i = 0; i < field[0].length; i++) {
				for (int j = 0; j < field[0].length; j++) {
					if (field[i][j] == 1) {
						posY = i;
						posX = j;
					}
				}
			}
			playerPosition[0] = posX;
			playerPosition[1] = posY;
			
		} 
		return playerPosition;
	}
	
	// Move the Player
	public static void movePlayer(String dir, ApplicationContext ctx) {
		int[] currentPosition = findPlayer();
		int currentX = currentPosition[0];
		int currentY = currentPosition[1];
		int[] nextStep = {currentX,currentY};
		
		switch (dir) {
		case "w": nextStep[1] = currentPosition[1] - 1; break;
		case "d": nextStep[0] = currentPosition[0] + 1; break;
		case "s": nextStep[1] = currentPosition[1] + 1; break;
		case "a": nextStep[0] = currentPosition[0] - 1; break;
		default: break;
		}
		
		// Check for collisions with objects
		if (Dungeon.field[nextStep[1]][nextStep[0]] != 0) {
			contact(Dungeon.field[nextStep[1]][nextStep[0]], ctx);
		}
		
		// Check for a contact with a wall
		if (Dungeon.field[nextStep[1]][nextStep[0]] == -1) {
			nextStep = currentPosition;
			System.out.println("There is a wall.");
		}
		
		Dungeon.field[currentPosition[1]][currentPosition[0]] = 0;
		Dungeon.field[nextStep[1]][nextStep[0]] = 1;
		
		printField();
	}
	
	// Interaction between the Hero and Objects
	public static void contact(int obj, ApplicationContext ctx) {
		
		TreasureController treasureCont = (TreasureController) ctx.getBean("treasureController");
		MonsterController monsterCont = (MonsterController) ctx.getBean("monsterController");
		GearController gearCont = (GearController) ctx.getBean("gearController");
		
		switch (obj) {
		case 2:
		System.out.println(gearCont.foundMessage());
		/*System.out.println(treasureCont.foundMessage());
		System.out.println(treasureCont.openingMessage());*/
		
		// Update the Hero's stats
		Hero.updateHeroLife(treasureCont.getHealing());
		Hero.updateHeroMana(treasureCont.getMana());
		break;
		case 3: 
		System.out.println(monsterCont.monsterFindMessage());
		fight(monsterCont);
		break;
		default: break;
		}
	}
	
	// Fights between the Hero and dungeon monster
	private static void fight(MonsterController monsterCont) {
		
		// Initializing stats
		int damageHero = Hero.damage;
		int lifeHero = Hero.life;
		int damageMonster = monsterCont.giveStats()[1];
		int lifeMonster = monsterCont.giveStats()[0];
		int Round = 1;
		
		// Check for the Heroes gear
		int weaponDamage = 0;
		int armor = 0;
		if(Hero.getGear() != null) {
			Gear heroGear = Hero.getGear();
			weaponDamage = heroGear.getStats()[1];
			armor = heroGear.getStats()[0];
		}
		damageHero += weaponDamage;
		
		// As long as both are alive, they are fighting
		while(lifeHero > 0 && lifeMonster > 0) {
			System.out.println("Round: " + String.valueOf(Round) + "\n");
			System.out.println("You have " + lifeHero + " lifepoints left." + "\n");
			System.out.println("Your opponent has " + lifeMonster + " lifepoints left." + "\n" + "\n");
			
			System.out.println("You deal " + damageHero + " damage." + "\n");
			lifeMonster -= damageHero;
			System.out.println("The monster deals " + damageMonster + " damage." + "\n" + "\n");
			lifeHero -= damageMonster - armor; // Damage reduced by the heroes armor
			
			System.out.println("You have " + lifeHero + " lifepoints left." + "\n");
			System.out.println("Your opponent has " + lifeMonster + " lifepoints left." + "\n" + "\n");
			
			Round += 1;
		}
		
		// Who won?
		if (lifeHero <= 0) {
			System.out.println("You died." + "\n");
		} else if (lifeMonster <= 0) {
			System.out.println("You won, you lucky bastard!" + "\n");
			
			// Drop a weapon or armor for the hero
			Gear newGear = new Gear();
			Hero.setGear(newGear); // Replace the old one
		}
		
		// Update the hero's life after the fight
		Hero.life = lifeHero;
		
	}
	
	
}