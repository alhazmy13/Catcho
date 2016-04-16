package net.alhazmy13.example.catcho;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import net.alhazmy13.catcho.library.Catcho;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Thread.setDefaultUncaughtExceptionHandler(new Catcho(this));
        setContentView(R.layout.activity_main);
        Integer.parseInt("G");

    }
}
