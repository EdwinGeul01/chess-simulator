package com.mygdx.game;

import java.util.Iterator;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Window;

public class EasyManage {

	
	public static Sprite Create_Object(String img, int x, int y)
	{
		
		
		Texture text = new Texture(Gdx.files.internal(img));
		Sprite sprite = new Sprite(text,x,y);
	

		return sprite;
		
		
		
	}
	
	
	public static void Create_Table()
	{
		Boolean a = true;
		int n = 1;
		float ymove = 170f;
		for (int i = 0; i < 64; i++) {
			Actors.blocks[i]= new container();
			if (a) {
				Actors.blocks[i].square = Create_Object("256h/square gray light _png_256px.png", 256, 256);
				if (i == 0 || n == 1) {
					Actors.blocks[i].square.setPosition(0-75f ,Gdx.graphics.getHeight()-ymove);
					n++;
				}else
				{
						Actors.blocks[i].square.setPosition(Actors.blocks[i-1].square.getX() + (Actors.blocks[i-1].square.getWidth() *0.3f) ,Gdx.graphics.getHeight()-ymove);
						n++;
				}
				a=!a;
			}else				
			{
				Actors.blocks[i].square = Create_Object("256h/square gray dark _png_256px.png", 256, 256);
				if (i == 0 || n == 1) {
					Actors.blocks[i].square.setPosition(0-75f ,Gdx.graphics.getHeight()-ymove);
					n++;
				}else
				{
						Actors.blocks[i].square.setPosition(Actors.blocks[i-1].square.getX() + (Actors.blocks[i-1].square.getWidth() *0.3f) ,Gdx.graphics.getHeight()-ymove);
						n++;
				}
				a=!a;

			}
			
			
			if(n == 9)
			{
				ymove += 70f;
				n =1;
				a=!a;
			}
			Actors.blocks[i].square.setScale(0.30f);
			Actors.blocks[i].saved_default();
		}
		
		
		
		//set pieces
		
		//dark pieces
		Actors.blocks[0].p = new piece("rook",1,Actors.blocks[0].square);
		Actors.blocks[7].p = new piece("rook",1,Actors.blocks[7].square);
		Actors.blocks[1].p = new piece("knight",1,Actors.blocks[1].square);
		Actors.blocks[6].p = new piece("knight",1,Actors.blocks[6].square);
		Actors.blocks[2].p = new piece("bishop",1,Actors.blocks[2].square);
		Actors.blocks[5].p = new piece("bishop",1,Actors.blocks[5].square);
		Actors.blocks[3].p = new piece("queen",1,Actors.blocks[3].square);
		Actors.blocks[4].p = new piece("king",1,Actors.blocks[4].square);
		
		Actors.blocks[8].p = new piece("pawn",1,Actors.blocks[8].square);
		Actors.blocks[9].p = new piece("pawn",1,Actors.blocks[9].square);
		Actors.blocks[10].p = new piece("pawn",1,Actors.blocks[10].square);
		Actors.blocks[11].p = new piece("pawn",1,Actors.blocks[11].square);
		Actors.blocks[12].p = new piece("pawn",1,Actors.blocks[12].square);
		Actors.blocks[13].p = new piece("pawn",1,Actors.blocks[13].square);
		Actors.blocks[14].p = new piece("pawn",1,Actors.blocks[14].square);
		Actors.blocks[15].p = new piece("pawn",1,Actors.blocks[15].square);

		
		
		Actors.blocks[0].isfill = true;
		Actors.blocks[1].isfill = true;
		Actors.blocks[2].isfill = true;
		Actors.blocks[3].isfill = true;
		Actors.blocks[4].isfill = true;
		Actors.blocks[5].isfill = true;
		Actors.blocks[6].isfill = true;
		Actors.blocks[7].isfill = true;
		Actors.blocks[8].isfill = true;
		Actors.blocks[9].isfill = true;
		Actors.blocks[10].isfill = true;
		Actors.blocks[11].isfill = true;
		Actors.blocks[12].isfill = true;
		Actors.blocks[13].isfill = true;
		Actors.blocks[14].isfill = true;
		Actors.blocks[15].isfill = true;

		// white pieces
		
		Actors.blocks[56].p = new piece("rook",0,Actors.blocks[56].square);
		Actors.blocks[63].p = new piece("rook",0,Actors.blocks[63].square);
		Actors.blocks[57].p = new piece("knight",0,Actors.blocks[57].square);
		Actors.blocks[62].p = new piece("knight",0,Actors.blocks[62].square);
		Actors.blocks[58].p = new piece("bishop",0,Actors.blocks[58].square);
		Actors.blocks[61].p = new piece("bishop",0,Actors.blocks[61].square);
		Actors.blocks[59].p = new piece("queen",0,Actors.blocks[59].square);
		Actors.blocks[60].p = new piece("king",0,Actors.blocks[60].square);
		
		Actors.blocks[48].p = new piece("pawn",0,Actors.blocks[48].square);
		Actors.blocks[49].p = new piece("pawn",0,Actors.blocks[49].square);
		Actors.blocks[50].p = new piece("pawn",0,Actors.blocks[50].square);
		Actors.blocks[51].p = new piece("pawn",0,Actors.blocks[51].square);
		Actors.blocks[52].p = new piece("pawn",0,Actors.blocks[52].square);
		Actors.blocks[53].p = new piece("pawn",0,Actors.blocks[53].square);
		Actors.blocks[54].p = new piece("pawn",0,Actors.blocks[54].square);
		Actors.blocks[55].p = new piece("pawn",0,Actors.blocks[55].square);

		Actors.blocks[48].isfill = true;
		Actors.blocks[49].isfill = true;
		Actors.blocks[50].isfill = true;
		Actors.blocks[51].isfill = true;
		Actors.blocks[52].isfill = true;
		Actors.blocks[53].isfill = true;
		Actors.blocks[54].isfill = true;
		Actors.blocks[55].isfill = true;
		Actors.blocks[56].isfill = true;
		Actors.blocks[57].isfill = true;
		Actors.blocks[58].isfill = true;
		Actors.blocks[59].isfill = true;
		Actors.blocks[60].isfill = true;
		Actors.blocks[61].isfill = true;
		Actors.blocks[62].isfill = true;
		Actors.blocks[63].isfill = true;
		
		/*
		if(Actors.imga.getBoundingRectangle().overlaps(Actors.imga2.getBoundingRectangle()))
		{
			System.out.print("asdasd");
		}
		*/
	}
	
	public static void DrawTable()
	{
		
		for (int i = 0; i < 64; i++) {
			Actors.blocks[i].square.draw(Actors.batch);
			if(Actors.blocks[i].p != null)
			{
				Actors.blocks[i].p.s.draw(Actors.batch);
			
			}
		}
		

	}
}
