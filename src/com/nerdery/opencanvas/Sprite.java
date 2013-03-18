package com.nerdery.opencanvas;

import java.util.ArrayList;

import android.graphics.Canvas;

public class Sprite extends DisplayObject {
	
	private ArrayList<DisplayObject> _children = new ArrayList<DisplayObject>();
	
	public Sprite()
	{
		
	}
	
	public ArrayList<DisplayObject> getChildren() { return _children; }
	
	public void addChild(DisplayObject child)
	{
		_children.add(child);
		child.setScene(_scene);
	}
	
	public boolean removeChild(DisplayObject child)
	{
		return _children.remove(child);
	}
	
	@Override
	public void setScene(Scene scene) {
		super.setScene(scene);
		for (DisplayObject child : _children) {
			child.setScene(scene);
		}
	}
	
	@Override
	public void render(Canvas canvas)
	{
		onEnterFrame();
		if (visible == false) return;
		
		canvas.save();
		canvas.translate(x, y);
		canvas.scale(scaleX, scaleY);
		canvas.rotate(rotation);
		
		draw(canvas);
		
		for (DisplayObject child : _children) {
			child.render(canvas);
		}
		
		canvas.restore();
	}
	
}
