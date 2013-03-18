package com.nerdery.opencanvas;

import android.graphics.Canvas;

public class DisplayObject {
	
	public float x = 0;
	public float y = 0;
	public float width = 0;
	public float height = 0;
	public float rotation = 0;
	public float scaleX = 1;
	public float scaleY = 1;
	public boolean visible = true;
	protected Scene _scene;
	
	public DisplayObject()
	{
		
	}
	
	public void setScene(Scene scene) {
		_scene = scene;
		if (_scene != null) {
			onAddedToScene();
		}
	}
	public Scene getScene() { return _scene; }
	
	public void setPosition(float x, float y)
	{
		this.x = x;
		this.y = y;
	}
	
	public void render(Canvas canvas)
	{
		if (visible == false) return;
		
		canvas.save();
		canvas.translate(x, y);
		canvas.scale(scaleX, scaleY);
		canvas.rotate(rotation);
		draw(canvas);
		canvas.restore();
	}
	
	protected void onEnterFrame()
	{
		
	}
	
	protected void draw(Canvas canvas)
	{
		
	}
	
	protected void onAddedToScene() {
		
	}

}
