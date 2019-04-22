package com.example.demo.Monster;

import java.util.Random;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("Troll")
public class Monster_Troll implements MonsterInterface{
	
	private int life;
	private int damage;
	
	public Monster_Troll() {
		setStats();
	}

	/*@Override
	public void fight() {
		System.out.println(monsterFindMessage());
	}*/
	
	public String monsterFindMessage() {
		return "You found a monster with " + String.valueOf(life) + " life points and " +
				   String.valueOf(damage) + " damage.";
	}
	
	
	// Set random values for life and damage
	private void setStats() {
		Random rand = new Random();
		this.life = rand.nextInt(21) + 80; // random between 80 and 100
		this.damage = rand.nextInt(11) + 10; // random between 10 and 20
	}

	@Override
	public int[] giveStats() {
		//setStats();
		int[] stats = {this.life, this.damage};
		return stats;
	}
	
	
}