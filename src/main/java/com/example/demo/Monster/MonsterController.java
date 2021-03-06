package com.example.demo.Monster;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MonsterController {
	
	private MonsterInterface monsterInterface;
	
	public MonsterController() {
		
	}
	
	@Autowired
	public void setMonster(MonsterInterface monsterInterface) {
		this.monsterInterface = monsterInterface;
	}
	
	/*public void fight() {
		monsterInterface.fight();
	}*/
	
	public String monsterFindMessage() {
		return monsterInterface.monsterFindMessage();
	}
	
	public int[] giveStats() {
		return monsterInterface.giveStats();
	}
}