package com.example.demo.Monster;

import java.util.Random;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile({"Goblin"})
public class Monster_Goblin implements MonsterInterface{
	
	private int life;
	private int damage;
	
	public Monster_Goblin() {
		setStats();
	}

	@Override
	public void fight() {
		System.out.println(monsterFindMessage());
	}
	
	public String monsterFindMessage() {
		return "You found a monster with " + String.valueOf(life) + " life points and " +
				   String.valueOf(damage) + " damage.";
	}
	
	
	// Set random values for life and damage
	private void setStats() {
		Random rand = new Random();
		this.life = rand.nextInt(21) + 20; // random between 20 and 40
		this.damage = rand.nextInt(9) + 1; // random between 1 and 10
	}
	
	
	
}