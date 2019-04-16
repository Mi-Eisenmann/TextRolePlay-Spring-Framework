package com.example.demo.Treasure;

import java.util.Random;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile({"PotSmall","default"})
public class Treasure_Small implements TreasureInterface{
	
	private int healing;
	private int mana;
	
	public Treasure_Small() {
		
		// Get a healing value;
		int healing = determineHealing();
		
		// Get a mana value;
		int mana = determineMana();
		
		this.healing = healing;
		this.mana = mana;
	}
	
	// Determine a random value for the healing through the treasure
	private int determineHealing() {
		
		Random rand = new Random();
		int heal = rand.nextInt(61) - 10; // random between -10 and 50

		return heal;
	}
	
	// Determine a random value for the mana regeneration through the treasure
	private int determineMana() {
		
		Random rand = new Random();
		int mana = rand.nextInt(11); // random between 0 and 10

		return mana;
	}
	
	
	// Getters
	public int getHealing() {
		return this.healing;
	}
	
	public int getMana() {
		return this.mana;
	}
	
	
	// Opening Message
	public String openingMessage() {
		
		int heal = this.healing;
		int AbsHeal = Math.abs(heal);
		int mana = this.mana;
		String message;
		
		// Determine whether we got healed or damaged
		if(heal >= 0) {
			message = "Great, you got healed by " + String.valueOf(AbsHeal) + " life points." + "\n" +
					  " Additionally your mana got increased by " + String.valueOf(mana) + ".";
		} else {
			message = "Oh no, you got poisoned and lost " + String.valueOf(AbsHeal) + " life points." + "\n" +
					  " Additionally your mana got increased by " + String.valueOf(mana) + ".";
		}
		
		return message;
	}
	
	// Found Message
	public String foundMessage() {
		String message = "Fantastic, you found a hidden treasure chest. Want to open it?";
		return message;
	}
}