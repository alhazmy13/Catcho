package net.alhazmy13.example.catcho;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import net.alhazmy13.catcho.library.Catcho;
import net.alhazmy13.catcho.library.error.CatchoError;

public class CustomActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom);
        CatchoError error = (CatchoError) getIntent().getSerializableExtra(Catcho.ERROR);

    }
}
