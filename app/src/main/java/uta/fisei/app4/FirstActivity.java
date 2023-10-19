package uta.fisei.app4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
    }

    public void onclickButtonBrowser(View view) {
    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
    startActivity(intent);
    }

    public void onclickButtonCallPhone(View view) {
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: +593980319324"));
        startActivity(intent);
    }

    public void onclickButtonGoogleMaps(View view) {
        Uri uri = Uri.parse("geo: 0, 0");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void onclickShowMainActivity(View view) {
        Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //return super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return true;
    }


}