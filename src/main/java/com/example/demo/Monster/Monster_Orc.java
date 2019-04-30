package com.example.demo.Monster;

import java.util.Random;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
//@Profile({"Orc","default"})
@Profile("Orc")
public class Monster_Orc implements MonsterInterface{
	
	private int life;
	private int damage;
	
	public Monster_Orc() {
		setStats();
	}

	/*@Override
	public void fight() {
		System.out.println("Monster Fight");
	}*/
	
	public String monsterFindMessage() {
		return "You found a monster with " + String.valueOf(life) + " life points and " +
				   String.valueOf(damage) + " damage.";
	}
	
	
	// Set random values for life and damage
	private void setStats() {
		Random rand = new Random();
		this.life = rand.nextInt(21) + 60; // random between 60 and 80
		this.damage = rand.nextInt(11) + 5; // random between 5 and 15
	}
	
	//@Override
	public int[] giveStats() {
		//setStats();
		int[] stats = {this.life, this.damage};
		return stats;
	}
	
	
	
}