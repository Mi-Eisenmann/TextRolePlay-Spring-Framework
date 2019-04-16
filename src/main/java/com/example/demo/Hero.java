package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class Hero{
	
	static int life = 100;
	static int mana = 100;
	static int damage = 10;
	// Weapon weapon;
	// Armor armor;
	
	public Hero() {
	}
	
	// Getters (more or less unnecessary, since the variables are static)
	public static int getHeroLife() {
		return life;
	}
	
	public static int getHeroMana() {
		return mana;
	}
	
	public static int getHeroDamage() {
		return damage;
	}
	
	// Setters
	public static void updateHeroLife(int lifePoints) {
		life += lifePoints;
		if (life <= 0) {
			// lostGame();
		}
	}
	
	public static void updateHeroMana(int manaPoints) {
		mana += manaPoints;
	}
	
}