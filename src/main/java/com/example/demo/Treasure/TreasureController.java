package com.example.demo.Treasure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TreasureController {
	
	private TreasureInterface treasureInterface;
	
	@Autowired
	public void setMonster(TreasureInterface treasureInterface) {
		this.treasureInterface = treasureInterface;
	}
	
	public int getHealing() {
		return treasureInterface.getHealing();
	}
	
	public int getMana() {
		return treasureInterface.getMana();
	}
	
	public String foundMessage() {
		return treasureInterface.foundMessage();
	}
	
	public String openingMessage() {
		return treasureInterface.openingMessage();
	}
}