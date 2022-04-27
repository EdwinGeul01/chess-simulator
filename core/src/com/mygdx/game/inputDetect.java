package com.mygdx.game;

import java.io.Console;
import java.util.Iterator;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g3d.shaders.DefaultShader.Inputs;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.EasyManage;

public class inputDetect implements InputProcessor {
	private OrthographicCamera camera = new OrthographicCamera();
	Vector3 tp = new Vector3();
	Vector2 tp2 = new Vector2();
	Boolean piece_select = false;
	int piece_select_pos = -1;
	
	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}
	

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		
		
		//reset all
		if(!piece_select)
		{
			for (int i = 0; i < Actors.blocks.length; i++) {
				Actors.blocks[i].reset();
			}
				
		}
		
		if(button == Input.Buttons.LEFT)
		{
			int cont_focus;
			
			for (int i = 0; i < Actors.blocks.length; i++) {

				float  posy = (Gdx.graphics.getHeight() - screenY );
				if(Actors.blocks[i].square.getBoundingRectangle().contains(screenX  , posy)  )
				{
					if(Actors.blocks[i].isfill && piece_select == false )
					{
					
						Vector2 temp = new Vector2(Actors.blocks[i].square.getX(),Actors.blocks[i].square.getY());
						Actors.blocks[i].square = EasyManage.Create_Object("256h/square brown light_png_256px.png", 256, 256);
						Actors.blocks[i].square.setScale(0.30f);
						Actors.blocks[i].square.setPosition(temp.x,temp.y);
						GameLogic.Set_AvalibleContainers(Actors.blocks[i], i);
						piece_select = true;
						piece_select_pos = i;
						break;
					
					}
					if ( piece_select  ){

						if (Actors.blocks[i].isavalible) {
							GameLogic.Move_Piece(piece_select_pos, i);
							//reset all
							for (int k = 0; k < Actors.blocks.length; k++) {
								Actors.blocks[k].reset();
							}
								
							piece_select = false;

							
						}else
						{
							//reset all
							for (int k = 0; k < Actors.blocks.length; k++) {
								Actors.blocks[k].reset();
							}
							piece_select = false;

						}
						
						
					}
						
					}
				
			}
			
			
		}
		
		
		
		return false;
	}


	
	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		

		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		/*
		tp2 = new Vector2(screenX,screenY);
		camera.unproject(tp);
		float  posy = (Gdx.graphics.getHeight() - tp2.y )- ( Actors.imga.getHeight() /2);
		Actors.imga.setPosition(tp2.x - Actors.imga.getWidth() /2 , posy);
		System.out.print(tp2.y);
		
		*/
		return false;
		
	}

	@Override
	public boolean scrolled(float amountX, float amountY) {
		// TODO Auto-generated method stub
		return false;
	}
		
	
	

}
