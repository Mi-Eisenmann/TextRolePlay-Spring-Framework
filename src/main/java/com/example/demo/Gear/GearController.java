package com.example.demo.Gear;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GearController {
	
	private GearInterface gearInterface;
	
	@Autowired
	public void setGear(GearInterface gearInterface) {
		this.gearInterface= gearInterface;
	}
	
	public String foundMessage() {
		return gearInterface.foundMessage();
	}
	
	public int[] getStats() {
		return gearInterface.getStats();
	}
}