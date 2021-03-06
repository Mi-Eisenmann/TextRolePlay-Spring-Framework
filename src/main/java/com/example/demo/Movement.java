package com.example.demo;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;

public class Movement {

	public static void movement(Scanner user_input, ApplicationContext ctx) {
			
			int[] playerPosition = Dungeon.findPlayer();
			
			System.out.println("Your current position is: x = " + String.valueOf(playerPosition[0]) + " ; y = " + String.valueOf(playerPosition[1]) + " .");
	
			System.out.println("Move to (w: North, a: West, s: South, d: East)");
			String input;
			input = user_input.next( );
			
			String direction;
			switch (input) {
			case "w": direction = "North"; break;
			case "d": direction = "East"; break;
			case "s": direction = "South"; break;
			case "a": direction = "West"; break;
			default: direction = "Nowhere";
			}
			
			System.out.println("You moved " + direction);
			
			Dungeon.movePlayer(input, ctx);
	}

}