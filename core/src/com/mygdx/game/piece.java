package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.Sprite;

public class piece {
	// 0 blanco , 1 negro
	int color ;
	boolean islive = true;
	public String type;
	public Sprite s;
	public Boolean First_move = true;
	
	
	public piece() {
	
		
		
	}
	public piece(String p, int color,Sprite square) {
		this.color = color;
		type = p;
		
		if(color == 1)
		{
			

			switch (p) {
			case "pawn":
				s = EasyManage.Create_Object("256h/b_pawn_png_256px.png", 256, 256);
				break;
			case "bishop":
				s = EasyManage.Create_Object("256h/b_bishop_png_256px.png", 256, 256);
				break;
			case "queen":
				s = EasyManage.Create_Object("256h/b_queen_png_256px.png", 256, 256);
				break;
			case "king":
				s = EasyManage.Create_Object("256h/b_king_png_256px.png", 256, 256);
				break;
			case "knight":
				s = EasyManage.Create_Object("256h/b_knight_png_256px.png", 256, 256);
				break;
			case "rook":
				s = EasyManage.Create_Object("256h/b_rook_png_256px.png", 256, 256);
				break;
			}
			
		
		
			s.setPosition(square.getX(), square.getY());
			s.setScale(0.2f);
		
		}else
		{
			
			switch (p) {
			case "pawn":
				s = EasyManage.Create_Object("256h/w_pawn_png_256px.png", 256, 256);
				break;
			case "bishop":
				s = EasyManage.Create_Object("256h/w_bishop_png_256px.png", 256, 256);
				break;
			case "queen":
				s = EasyManage.Create_Object("256h/w_queen_png_256px.png", 256, 256);
				break;
			case "king":
				s = EasyManage.Create_Object("256h/w_king_png_256px.png", 256, 256);
				break;
			case "knight":
				s = EasyManage.Create_Object("256h/w_knight_png_256px.png", 256, 256);
				break;
			case "rook":
				s = EasyManage.Create_Object("256h/w_rook_png_256px.png", 256, 256);
				break;
			}
			
		
		
			s.setPosition(square.getX(), square.getY());
			s.setScale(0.2f);
			
			
			
			
			
			
			
			
			
			
			
		}
		
		
	}

	
	public piece ( piece p)
	{
		this.color = p.color;
		islive = p.islive;
		type = p.type;
		s =  p.s;
		First_move = p.First_move;
	}

}
