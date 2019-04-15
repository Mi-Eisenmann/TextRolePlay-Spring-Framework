package com.example.demo;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.demo.Monster.MonsterController;
import com.example.demo.Treasure.TreasureController;

@SpringBootApplication
public class TextRolePlayingGameApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(TextRolePlayingGameApplication.class, args);
		
		new Dungeon();
		System.out.println(Dungeon.getField()[3][3]);
		
		//Treasure chest = new Treasure();
		/*Treasure_Small chest = (Treasure_Small) ctx.getBean("treasure");
		System.out.println(chest.foundMessage());
		System.out.println(chest.openingMessage()); */
		TreasureController treasureCont = (TreasureController) ctx.getBean("treasureController");
		System.out.println(treasureCont.foundMessage());
		System.out.println(treasureCont.openingMessage());
		
		/*Monster_Orc monster = (Monster_Orc) ctx.getBean("monster");
		monster.fight();*/
		
		MonsterController monsterCont = (MonsterController) ctx.getBean("monsterController");
		monsterCont.fight();
		
		Scanner user_input = new Scanner( System.in );
		while(true){
			Movement.movement(user_input);
			
			if(Dungeon.getField()[5][5] == 1) {
				break;
			}
		}
		user_input.close();
		
	}

}
