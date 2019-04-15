package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class Dungeon {
	
	public static int[][] field = {{-1,-1,-1,-1,-1,-1,-1},
								   {-1,0,0,2,0,0,-1},
								   {-1,0,0,0,0,0,-1},
								   {-1,0,0,1,0,3,-1},
								   {-1,0,0,0,0,0,-1},
								   {-1,0,0,0,0,0,-1},
								   {-1,-1,-1,-1,-1,-1,-1}};;
	
	public Dungeon() {
		//setField();
	}
	
	public static void printField() {
		System.out.println(String.valueOf(Dungeon.field[1][1]) + String.valueOf(Dungeon.field[1][2]) + String.valueOf(Dungeon.field[1][3]) + String.valueOf(Dungeon.field[1][4]) + String.valueOf(Dungeon.field[1][5]) + "\n" +
				String.valueOf(Dungeon.field[2][1]) + String.valueOf(Dungeon.field[2][2]) + String.valueOf(Dungeon.field[2][3]) + String.valueOf(Dungeon.field[2][4]) + String.valueOf(Dungeon.field[2][5]) + "\n" +
				String.valueOf(Dungeon.field[3][1]) + String.valueOf(Dungeon.field[3][2]) + String.valueOf(Dungeon.field[3][3]) + String.valueOf(Dungeon.field[3][4]) + String.valueOf(Dungeon.field[3][5]) + "\n" +
				String.valueOf(Dungeon.field[4][1]) + String.valueOf(Dungeon.field[4][2]) + String.valueOf(Dungeon.field[4][3]) + String.valueOf(Dungeon.field[4][4]) + String.valueOf(Dungeon.field[4][5]) + "\n" +
				String.valueOf(Dungeon.field[5][1]) + String.valueOf(Dungeon.field[5][2]) + String.valueOf(Dungeon.field[5][3]) + String.valueOf(Dungeon.field[5][4]) + String.valueOf(Dungeon.field[5][5]) + "\n" );
	}
	
	// Getter
	public static int[][] getField(){
		return field;
	}
	
	// Find the position of the Player in the Dungeon
	public static int[] findPlayer() {
		
		int[][] field = Dungeon.field;
		int posX;
		int posY;
		int[] playerPosition = {-1,-1};
		
		// The field might not have been initialized
		if(field != null) {
			
			posX = -1;
			posY = -1;
			
			for (int i = 0; i < field[0].length; i++) {
				for (int j = 0; j < field[0].length; j++) {
					if (field[i][j] == 1) {
						posY = i;
						posX = j;
					}
				}
			}
			playerPosition[0] = posX;
			playerPosition[1] = posY;
			
		} 
		return playerPosition;
	}
	
	// Move the Player
	public static void movePlayer(String dir) {
		int[] currentPosition = findPlayer();
		int currentX = currentPosition[0];
		int currentY = currentPosition[1];
		int[] nextStep = {currentX,currentY};
		
		switch (dir) {
		case "w": nextStep[1] = currentPosition[1] - 1; break;
		case "d": nextStep[0] = currentPosition[0] + 1; break;
		case "s": nextStep[1] = currentPosition[1] + 1; break;
		case "a": nextStep[0] = currentPosition[0] - 1; break;
		default: break;
		}
		
		// Check for collisions with objects
		if (Dungeon.field[nextStep[1]][nextStep[0]] != 0) {
			contact(Dungeon.field[nextStep[1]][nextStep[0]]);
		}
		
		// Check for a contact with a wall
		if (Dungeon.field[nextStep[1]][nextStep[0]] == -1) {
			nextStep = currentPosition;
			System.out.println("Invalid Move");
		}
		
		Dungeon.field[currentPosition[1]][currentPosition[0]] = 0;
		Dungeon.field[nextStep[1]][nextStep[0]] = 1;
		
		printField();
	}
	
	
	public static void contact(int obj) {
		switch (obj) {
		case 2: System.out.println("You found a treasure chest !"); break;
		case 3: System.out.println("Oh no, a monster is in your way!"); break;
		default: break;
		}
	}
	
}