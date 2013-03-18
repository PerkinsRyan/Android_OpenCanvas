package com.nerdery.canvasframework;

import android.graphics.Canvas;
import android.graphics.Paint;

import com.nerdery.opencanvas.DisplayObject;

public class Ball extends DisplayObject {
	
	public int radius;
	public int color;
	
	private Paint p;
	
	public Ball(int radius, int color)
	{
		p = new Paint();
		this.radius = radius;
		this.color = color;
		this.width = this.height = radius * 2;
	}
	
	@Override
	protected void draw(Canvas canvas)
	{
		p.setColor(color);
		canvas.drawCircle(0, 0, radius, p);
	}

}
