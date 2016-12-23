package com.jmedinilla.capturingonkeydown;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.Toast;

public class AndroidKey extends Activity {

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.android_key);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub

        switch (keyCode) {
            case KeyEvent.KEYCODE_CAMERA:
                Toast.makeText(this, "Obturador presionado", Toast.LENGTH_SHORT)
                        .show();
                return true;
            case KeyEvent.KEYCODE_VOLUME_UP:
                Toast.makeText(this, "Boton de Volumen Up presionado",
                        Toast.LENGTH_SHORT).show();
                return true;
            case KeyEvent.KEYCODE_VOLUME_DOWN:
                Toast.makeText(this, "Boton de Volumen Down presionado",
                        Toast.LENGTH_SHORT).show();
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // TODO Auto-generated method stub
        float posX = event.getX();
        float posY = event.getY();
        Toast.makeText(this,
                "Acabas de tocar la pantalla en: " + posX + ", " + posY,
                Toast.LENGTH_SHORT).show();
        return true;
    }
}
