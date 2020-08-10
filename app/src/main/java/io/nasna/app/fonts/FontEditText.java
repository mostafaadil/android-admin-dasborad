package io.nasna.app.fonts;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.EditText;

@SuppressLint("AppCompatCustomView")
public class FontEditText extends EditText {
    public FontEditText(Context context) {
        super(context);
        Typeface face=Typeface.createFromAsset(context.getAssets(), "fonts/jf_flat.ttf");
        this.setTypeface(face);

    }

    public FontEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        Typeface face=Typeface.createFromAsset(context.getAssets(), "fonts/jf_flat.ttf");
        this.setTypeface(face);

    }

    public FontEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Typeface face=Typeface.createFromAsset(context.getAssets(), "fonts/jf_flat.ttf");
        this.setTypeface(face);

    }

    public FontEditText(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        Typeface face=Typeface.createFromAsset(context.getAssets(), "fonts/jf_flat.ttf");
        this.setTypeface(face);

    }
}
