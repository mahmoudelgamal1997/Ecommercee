package katar.example.elgaml.ecommerce.utils;

import android.content.Context;
import android.graphics.Typeface;

public class FontManger {


    public static final String ROOT = "Fonts/",
            FONTAWESOME = ROOT + "fontawesome.ttf";
    public static Typeface getTypeface(Context context, String font) {
        return Typeface.createFromAsset(context.getAssets(), font);
    }
}
