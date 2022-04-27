package com.mygdx.game;

import java.util.Iterator;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Container;

public class GameLogic {
	
	
	
	public static void showAvalibles()
	{
		for (int i = 0; i < Actors.blocks.length; i++) {
			if (Actors.blocks[i].isavalible) {
				Vector2 temp = new Vector2(Actors.blocks[i].square.getX(),Actors.blocks[i].square.getY());
				Actors.blocks[i].square = EasyManage.Create_Object("256h/square brown light_png_256px.png", 256, 256);
				Actors.blocks[i].square.setScale(0.30f);
				Actors.blocks[i].square.setPosition(temp.x,temp.y+5);

			}
		}
	}
	
	public static void Set_AvalibleContainers(container c,int i)
	{
		switch (c.p.type) {
		case "pawn":
			MovePawn(c, i);
			break;
		case "bishop":
			MoveBishop(c, i);
			break;
		case "queen":
			MoveBishop(c, i);
			MoveRook(c, i);
			MoveKing(c, i);
			break;
		case "king":
			MoveKing(c, i);
			break;
		case "knight":
			MoveHorse(c, i);
			break;
		case "rook":
			MoveRook(c, i);
			break;
		}
		
		showAvalibles();
		
		
	}
	
	
	private static void MovePawn(container c,int i)
	{
		if (c.p.color == 1) {
			if (c.p.First_move) {
				Actors.blocks[i+8].isavalible = true;
				Actors.blocks[i+16].isavalible = true;

			}				
			else
			{
				if (i+8 <= 63) {
					Actors.blocks[i+8].isavalible = true;
				}
				
			}
		}else	
		{
			if (c.p.First_move) {
				Actors.blocks[i-8].isavalible = true;
				Actors.blocks[i-16].isavalible = true;

			}				
			else
			{
				if (i-8 >= 0) {
					Actors.blocks[i-8].isavalible = true;
				}
				
			}
		}
		
		
	}
	
	private static void MoveBishop(container c,int i)
	{
		int temp = 8;
		int pos = i;
		while (pos >= 8) {
			pos  -= 8;		
		}
		
	
		
		for (int j = 0; j < 7 - pos; j++) 
		{
			if (i+1+temp + j < 64) {
				Actors.blocks[i+1 +temp + j].isavalible = true;
			}
			
			temp += 8;
		}
		
		 temp = 8;
		for (int j = 0; j < pos   ; j++) 
		{
			if (i+temp - j < 64) {
				Actors.blocks[i-1 +temp - j].isavalible = true;
			}
			
			temp += 8;
		}
		
		 temp = 8;
		 
		for (int j = 0; j < pos   ; j++) 
		{
			if (i- temp - j > 0) {
				Actors.blocks[i-1 -temp - j].isavalible = true;
			}
				
			temp += 8;
			}
		temp = 8;
		for (int j = 0; j < 7 - pos   ; j++) 
		{
			if (i- temp - j > 0) {
				Actors.blocks[i+1 -temp + j].isavalible = true;
			}
			temp += 8;
		}
		
	}
	
	private static void MoveHorse(container c, int i)
	{
		int pos = i;
		while (pos >= 8) {
			pos  -= 8;	
			System.out.print("posicion: " + pos);

		}
		
		//bottom
		if (i+8+2 <= 63 && (7-pos) >= 2) {
			System.out.print(pos);
			Actors.blocks[i+8+2].isavalible = true;
		}
		if (i+8-2 <= 63 && pos >= 2) {
			Actors.blocks[i+8-2].isavalible = true;
		}
		
		if (i+16+1 <= 63 && (7-pos) >= 1) {
			Actors.blocks[i+16+1].isavalible = true;
		}
		if (i+16-1 <= 63 && pos >= 1) {
			System.out.print(pos);
			Actors.blocks[i+16-1].isavalible = true;
		}
		
		//Top
		if (i-8+2 >= 0 && (7-pos) >= 2) {
			System.out.print(pos);
			Actors.blocks[i-8+2].isavalible = true;
		}
		if (i-8-2 >= 0 && pos >= 2) {
			System.out.print(pos);
			Actors.blocks[i-8-2].isavalible = true;
		}
		if (i-16+1 >=0  && (7-pos) >= 1) {
			Actors.blocks[i-16+1].isavalible = true;
		}
		if (i-16-1 >=0 && pos >= 1) {
			System.out.print(pos);
			Actors.blocks[i-16-1].isavalible = true;
		}
		
		
		
	}

	private static void MoveKing(container c, int i)
	{
		
		int pos = i;
		while (pos >= 8) {
			pos  -= 8;	
			System.out.print("posicion: " + pos);

		}
		
		//left right
		if (i+1 <= 63 &&  (7-pos) >= 1) {
			Actors.blocks[i+1].isavalible = true;
		}
		if (i-1 >= 0 &&  pos >= 1) {
			Actors.blocks[i-1].isavalible = true;
		}
		
		//bottom
		if (i+8 <= 63 ) {
			Actors.blocks[i+8].isavalible = true;
		}
		if (i+8+1 <= 63 &&  (7-pos) >= 1 ) {
			Actors.blocks[i+8+1].isavalible = true;
		}
		if (i+8-1 <= 63 &&  pos >= 1 ) {
			Actors.blocks[i+8-1].isavalible = true;
		}
		
		//top
		if (i-8 >=0 ) {
			Actors.blocks[i-8].isavalible = true;
		}
		if (i-8+1 >=0 && (7-pos) >= 1) {
			Actors.blocks[i-8+1].isavalible = true;
		}
		if (i-8-1 >= 0 &&  pos >= 1 ) {
			Actors.blocks[i-8-1].isavalible = true;
		}
		
	}
	
	private static void MoveRook(container c, int i)
	{
		int pos = i;
		while (pos >= 8) {
			pos  -= 8;	
			System.out.print("posicion: " + pos);

		}
		
		int temp = 8;
		
		//to left
		for (int j = 0; j < 7-pos ; j++) {
			Actors.blocks[i+j+1].isavalible = true;

		}
		for (int j = 0; j < pos ; j++) {
			Actors.blocks[i-j-1].isavalible = true;

		}
		
		while (true) {
			if (i-temp >= 0) {
				Actors.blocks[i-temp].isavalible = true;
			}else
			{
				break;
			}
			
			temp +=8;
		}
		
		temp = 8;
		while (true) {
			if (i+temp <= 63) {
				Actors.blocks[i+temp].isavalible = true;
			}else
			{
				break;
			}
			temp+=8;
		}
		
	}
	
	public static void Move_Piece(int ori , int dest)
	{
		Actors.blocks[dest].p = new piece(Actors.blocks[ori].p);
		Actors.blocks[dest].p.s.setX(Actors.blocks[dest].square.getX());
		Actors.blocks[dest].p.s.setY(Actors.blocks[dest].square.getY());
		Actors.blocks[dest].isfill = true;
		Actors.blocks[dest].p.First_move = false;
		Actors.blocks[ori].p = null;
		Actors.blocks[ori].isfill = false;
	}
	
	
}
