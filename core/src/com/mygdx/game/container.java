package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.piece;

public class container {
	Sprite square = new Sprite();
	public Boolean isfill  = false;
	public piece p;
	public Sprite saved ;
	public Boolean isselect = false;
	public Boolean isavalible = false;
	
	public void saved_default()
	{
		 saved = new Sprite(square);
	}
	
	public void reset()
	{
		square = new Sprite(saved);
		isselect = false;
		isavalible = false;
	}
	
}
