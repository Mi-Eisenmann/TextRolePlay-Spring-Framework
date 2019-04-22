package com.example.demo.Gear;

import java.util.Random;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile({"Gear", "default"})
public class Gear implements GearInterface{
	
	private int statValue;
	private int armorOrWeapon;
	
	public Gear() {
		determineStats();
		armorOrWeapon();
	}

	@Override
	public String foundMessage() {
		String message;
		if (armorOrWeapon == 0) {
			message = "Congratulations, you found a beautiful armor with " + String.valueOf(statValue) + " damage reduction.";
		} else{
			message = "Congratulations, you found a great new weapon with " + String.valueOf(statValue) + " damage.";
		}
		return message;
	}

	private void determineStats() {
		Random rand = new Random();
		this.statValue = rand.nextInt(10) + 1; // random between 1 and 10
	}
	
	private void armorOrWeapon() {
		Random rand = new Random();
		int chose = rand.nextInt(1); // random 0 or 1, 0 meaning armor, 1 meaning weapon
		this.armorOrWeapon = chose;
	}

	@Override
	public int[] getStats() {

		int[] stats = {0,0}; // The first stat is the armor, the second is the weapon damage
		
		if (this.armorOrWeapon == 0) {
			stats[0] = statValue;
		} else {
			stats[1] = statValue;
		}
		
		return stats;
	}

	

}