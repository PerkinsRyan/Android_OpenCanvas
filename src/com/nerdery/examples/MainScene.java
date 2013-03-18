package com.nerdery.canvasframework;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;

import com.nerdery.opencanvas.Image;
import com.nerdery.opencanvas.Scene;
import com.nerdery.opencanvas.Sprite;

public class MainScene extends Scene {
	
	private Sprite container;
	private Ball ball;
	private Bitmap bmp1;
	private Bitmap bmp2;
	private Image img1;
	private Image img2;
	
	private Point destPoint = new Point(0, 0);

	public MainScene(Context context, int width, int height) {
		super(context, width, height);
		
		container = new Sprite();
		this.addChild(container);
		
		bmp1 = BitmapFactory.decodeResource(context.getResources(), R.drawable.snickers_bar);
		img1 = new Image(bmp1);
		img1.offsetX = (float) (img1.width * .5);
		img1.offsetY = (float) (img1.height * .5);
		container.addChild(img1);
		
		bmp2 = BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_launcher);
		img2 = new Image(bmp2);
		container.addChild(img2);
		
		ball = new Ball(20, Color.RED);
		container.addChild(ball);
	}
	
	public void onTouchEvent(MotionEvent event)
	{
		destPoint.set((int) event.getX(), (int) event.getY());
		
		img2.scaleX = img2.scaleY = (float) (Math.random() + .5);
		
		container.scaleX = container.scaleY = (float) (Math.random() + .5);
	}
	
	private void update()
	{
		img1.rotation++;
		img2.rotation--;
		
		container.x += (destPoint.x - container.x) / 5;
		container.y += (destPoint.y - container.y) / 5;
		
	}
	
	@Override
	public void render(Canvas canvas) {
		update();
		super.render(canvas);
	}

}
