package selengut.alex.doodle;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class drawView extends View {

    private Canvas drawCanvas;
    private Bitmap canvasBitmap;
    private Paint _paint = new Paint();
    private Paint canvasPaint;
    private Path _path = new Path();
    private Boolean line = false;

    private int paintColor;
    private int opacity = 255;
    private float brushSize;

    public drawView(Context context) {
        super(context);
        init(null, 0);
    }

    public drawView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public drawView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs, defStyle);
    }

    private void init(AttributeSet attrs, int defStyle) {
        brushSize = 20;

        _paint.setColor(Color.RED);
        _paint.setAntiAlias(true);
        _paint.setStyle(Paint.Style.STROKE);
        _paint.setStrokeWidth(brushSize);

        canvasPaint = new Paint();

    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawBitmap(canvasBitmap, 0, 0, canvasPaint);
        canvas.drawPath(_path, _paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent motionEvent) {
        float getX = motionEvent.getX();
        float getY = motionEvent.getY();

        switch(motionEvent.getAction()) {
            case MotionEvent.ACTION_DOWN:
                _path.moveTo(getX, getY);
                break;
            case MotionEvent.ACTION_MOVE:
                if(line == false) {
                    _path.lineTo(getX, getY);
                }
                break;
            case MotionEvent.ACTION_UP:
                if(line == true){
                    _path.lineTo(getX,getY);
                }
                drawCanvas.drawPath(_path, _paint);
                _path.reset();
                break;
        }

        invalidate();
        return true;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        canvasBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        drawCanvas = new Canvas(canvasBitmap);
    }


    public void setOpacity(int newOpacity){
        opacity = newOpacity;
        _paint.setColor(paintColor);
        _paint.setAlpha(opacity);
    }

    public void clear(){
        drawCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
        invalidate();
    }

    public void setBrushSize(float size){
        _paint.setStrokeWidth(size);
    }


    public void setColor(String newColor){
        invalidate();
        paintColor = Color.parseColor(newColor);
        _paint.setColor(paintColor);
    }

    public void setline(boolean b){
        line = b;
    }



}