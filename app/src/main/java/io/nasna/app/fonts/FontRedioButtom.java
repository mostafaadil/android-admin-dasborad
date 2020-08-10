package io.nasna.app.fonts;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.RadioButton;

@SuppressLint("AppCompatCustomView")
public class FontRedioButtom extends RadioButton {
    public FontRedioButtom(Context context) {
        super(context);
        Typeface face=Typeface.createFromAsset(context.getAssets(), "fonts/myfont.ttf");
        this.setTypeface(face);
    }

    public FontRedioButtom(Context context, AttributeSet attrs) {
        super(context, attrs);
        Typeface face=Typeface.createFromAsset(context.getAssets(), "fonts/myfont.ttf");
        this.setTypeface(face);
    }

    public FontRedioButtom(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Typeface face=Typeface.createFromAsset(context.getAssets(), "fonts/myfont.ttf");
        this.setTypeface(face);
    }

    @SuppressLint("NewApi")
    public FontRedioButtom(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        Typeface face=Typeface.createFromAsset(context.getAssets(), "fonts/myfont.ttf");
        this.setTypeface(face);
    }
}
