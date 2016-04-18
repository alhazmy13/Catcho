package net.alhazmy13.example.catcho;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import net.alhazmy13.catcho.library.Catcho;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Thread.setDefaultUncaughtExceptionHandler(new Catcho.Builder(this).recipients("alhazmy15@gmail.com").build());
        setContentView(R.layout.activity_main);
        Button exBt = (Button) findViewById(R.id.exceptionBT);
        assert exBt != null;
        exBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer.parseInt("G");
            }
        });

    }
}
