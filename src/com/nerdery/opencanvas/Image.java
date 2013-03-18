package com.nerdery.opencanvas;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class Image extends DisplayObject {
	
	public Bitmap bitmap;
	public float offsetX = 0;
	public float offsetY = 0;
	
	public Image() {
		
	}
	
	public Image(Bitmap bitmap) {
		setBitmap(bitmap);
	}
	
	public void setBitmap(Bitmap bitmap) {
		this.bitmap = bitmap;
		this.width = bitmap.getWidth();
		this.height = bitmap.getHeight();
	}
	
	public Bitmap getBitmap() {
		return this.bitmap;
	}
	
	@Override
	protected void draw(Canvas canvas) {
		super.draw(canvas);
		
		if (this.bitmap != null) {
			canvas.drawBitmap(this.bitmap, -offsetX, -offsetY, null);
		}
	}

}
