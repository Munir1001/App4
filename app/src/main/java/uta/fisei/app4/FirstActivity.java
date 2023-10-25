package uta.fisei.app4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {

    private EditText editTextName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        editTextName = findViewById(R.id.editTextName);

        registerForContextMenu(editTextName);
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

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        switch (id){
            case R.id.submenuEditPaste:
                Toast.makeText(this, "Presiona en la opcion pegar", Toast.LENGTH_SHORT).show();
            case R.id.menuAbout:
                Toast.makeText(this, "Bienvenido a la APP", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menuFinish:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.menu_contextual, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.menuContextualEditCopy:
                Toast.makeText(this, "Presiona en Copiar", Toast.LENGTH_SHORT).show();
        }
        return super.onContextItemSelected(item);
    }


}