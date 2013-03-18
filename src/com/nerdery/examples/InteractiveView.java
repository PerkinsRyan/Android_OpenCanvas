package com.nerdery.canvasframework;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceView;

@SuppressLint("DrawAllocation")
public class InteractiveView extends SurfaceView {
	
	private final int FRAME_RATE = 30;
	
	private Handler h;
	private Runnable r;
	private MainScene scene;

	public InteractiveView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}
	
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		init();
	}
	
	private void init() {
		h = new Handler();
		r = new Runnable() {
			public void run() {
				invalidate();
			}
		};
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		scene.onTouchEvent(event);
		return super.onTouchEvent(event);
	}
	
	@Override
	protected void dispatchDraw(Canvas canvas) {
		super.dispatchDraw(canvas);
		if (scene == null) {
			scene = new MainScene(this.getContext(), canvas.getWidth(), canvas.getHeight());
		}
		scene.render(canvas);
		h.postDelayed(r, getFPSInMS());
	}
	
	private int getFPSInMS() {
		return (int) 1000 / FRAME_RATE;
	}

}
