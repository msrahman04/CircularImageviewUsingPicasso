package com.msrahman.circularimageviewusingpicasso;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Color;
import android.graphics.Shader;
import android.os.Build;
import android.support.annotation.RequiresApi;

import com.squareup.picasso.Transformation;

/**
 * Created by pg3 on 9/25/2017.
 */

public class ImageTrans_CircleTransform implements Transformation {
    int borderwidth;
    Context context;

    public ImageTrans_CircleTransform(Context context, int borderwidth) {
        this.context = context;
        this.borderwidth = borderwidth;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public Bitmap transform(Bitmap source) {
        if (source == null || source.isRecycled()) {
            return null;
        }


        final int width = source.getWidth() + borderwidth;
        final int height = source.getHeight() + borderwidth;

        Bitmap canvasBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        BitmapShader shader = new BitmapShader(source, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setShader(shader);

        Canvas canvas = new Canvas(canvasBitmap);
        float radius = width > height ? ((float) height) / 2f : ((float) width) / 2f;
        canvas.drawCircle(width / 2f, height / 2f, radius, paint);

        //border code
        paint.setShader(null);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(context.getColor(R.color.colorAccent));
        paint.setStrokeWidth(borderwidth);
        canvas.drawCircle(width / 2f, height / 2f, radius - borderwidth / 2f, paint);
        //--------------------------------------

        if (canvasBitmap != source) {
            source.recycle();
        }

        return canvasBitmap;
    }
    @Override
    public String key() {
        return "circle";
    }
}
