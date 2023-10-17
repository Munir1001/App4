package uta.fisei.app4;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ThirdActivity extends AppCompatActivity {

    private ListView listViewData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        listViewData = findViewById(R.id.listViewData);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, loadData());

        listViewData.setAdapter(adapter);

        // obtener el item seleccionado dentro del listView
        listViewData.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String itemSelected = (String) listViewData.getAdapter().getItem(position);
                // Toast.makeText(getApplicationContext(), "Selecciono: " + itemSelected,
                        //Toast.LENGTH_SHORT).show();

                Intent intent = new Intent();

                intent.setData(Uri.parse(itemSelected));

                // comprobrar que todo funcione de acuerdo a lo esperado

                setResult(Activity.RESULT_OK, intent);

                finish();
            }
        });

    }

    private List<String> loadData() {
        List<String> list = new ArrayList<String>();
        for (int i = 1; i <= 20; i++){
            String item = "Número: " + i;
            list.add(item);
        }
        return list;
    }
}