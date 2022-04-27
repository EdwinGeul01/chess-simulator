package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.EasyManage;

public class MyGdxGame extends ApplicationAdapter {

	Vector3 tp = new Vector3();

	@Override
	public void create () {
		Gdx.input.setInputProcessor(new inputDetect());
		Actors.batch = new SpriteBatch();
		Actors.blocks = new container[64];

		EasyManage.Create_Table();

	}

	@Override
	public void render () {
		ScreenUtils.clear(Color.BLACK);
		Actors.batch.begin();
		EasyManage.DrawTable();
		Actors.batch.end();
	}
	
	@Override
	public void dispose () {
		Actors.batch.dispose();
	}
}
