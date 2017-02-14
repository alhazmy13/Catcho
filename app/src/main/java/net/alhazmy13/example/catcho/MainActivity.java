package net.alhazmy13.example.catcho;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import net.alhazmy13.catcho.library.Catcho;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Catcho.Builder(this)
                .activity(CustomActivity.class)
                .build();

        setContentView(R.layout.activity_main);
        ((Button) findViewById(R.id.exceptionBT)).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        throw new RuntimeException("");
    }
}
