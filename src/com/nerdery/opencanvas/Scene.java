package com.nerdery.opencanvas;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;

public class Scene {
	
	protected Context _context;
	protected ArrayList<DisplayObject> _children;
	protected int _backgroundColor = Color.BLACK;
	protected int _stageWidth = 0;
	protected int _stageHeight = 0;
	
	public Scene(Context context, int width, int height)
	{
		_children = new ArrayList<DisplayObject>();
		_context = context;
		_stageWidth = width;
		_stageHeight = height;
	}
	
	public Context getContext() { return _context; }
	
	public int getStageWidth() { return _stageWidth; }
	public int getStageHeight() { return _stageHeight; }
	
	public void setBackgroundColor(int color)
	{
		_backgroundColor = color;
	}
	
	public void clearBackgoundColor()
	{
		_backgroundColor = -1;
	}
	
	public void addChild(DisplayObject child)
	{
		_children.add(child);
		child.setScene(this);
	}
	
	public boolean removeChild(DisplayObject child)
	{
		return _children.remove(child);
	}
	
	public void render(Canvas canvas)
	{
		onEnterFrame();
		if (_backgroundColor != -1) canvas.drawColor(_backgroundColor);
		draw(canvas);
		
		for (DisplayObject child : _children) {
			child.render(canvas);
		}
	}
	
	protected void onEnterFrame()
	{
		
	}
	
	protected void draw(Canvas canvas)
	{
		
	}

}
