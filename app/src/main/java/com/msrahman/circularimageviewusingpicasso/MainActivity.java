package com.msrahman.circularimageviewusingpicasso;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.makeramen.roundedimageview.RoundedTransformationBuilder;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.circularManImage)
    ImageView circularManImage;
    @BindView(R.id.circularOtherImage)
    ImageView circularOtherImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        Picasso.with(this)
                .load(R.drawable.man)
                .error(R.mipmap.ic_launcher)
                .placeholder(R.mipmap.ic_launcher)
                .resize(240, 200)
                .transform(new ImageTrans_CircleTransform(this,3))
                .into(circularManImage);

        Picasso.with(this)
                .load(R.drawable.flower)
                .error(R.mipmap.ic_launcher)
                .placeholder(R.mipmap.ic_launcher)
                .resize(250, 200)
                .transform(new ImageTrans_CircleTransform(this,5))
                .into(circularOtherImage);

    }
}
