package com.example.ex085;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    double[] arr = new double[20];
    List<item> items;
    RecyclerView rV1;
    ToggleButton tB1;
    TextView tV1;
    TextView tV2;
    TextView tV3;
    TextView tV4;
    EditText eT1;
    EditText eT2;
    MyAdapter adp;
    int count;
    double x1,x2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        count = 0;
        items = new ArrayList<item>();
        rV1 = findViewById(R.id.rV1);
        tB1 = findViewById(R.id.tB1);
        tV1 = findViewById(R.id.tV1);
        tV2 = findViewById(R.id.tV2);
        tV3 = findViewById(R.id.tV1);
        tV4 = findViewById(R.id.tV2);
        eT1 = findViewById(R.id.eT1);
        eT2 = findViewById(R.id.eT2);
        rV1.setLayoutManager(new LinearLayoutManager(this));
        adp = new MyAdapter(getApplicationContext(), items, new ItemClickListener() {
            @Override
            public void onItemClick(int position) {
                if(count > 0)
                {
                    tV1.setText(Integer.toString(position));
                    double sum = arr[0];
                    for(int i = 1; i < position + 1; i++)
                    {
                        sum += arr[i];
                    }
                    tV2.setText(Double.toString(sum));
                }
            }
        });
        rV1.setAdapter(adp);
        sidor();

    }

    public void sidor() {
        items.add(new item(""));
        items.add(new item(""));
        items.add(new item(""));
        items.add(new item(""));
        items.add(new item(""));
        items.add(new item(""));
        items.add(new item(""));
        items.add(new item(""));
        items.add(new item(""));
        items.add(new item(""));
        items.add(new item(""));
        items.add(new item(""));
        items.add(new item(""));
        items.add(new item(""));
        items.add(new item(""));
        items.add(new item(""));
        items.add(new item(""));
        items.add(new item(""));
        items.add(new item(""));
        items.add(new item(""));
    }


    public void dori(View view) {
        adp.notifyDataSetChanged();
        String st1 = eT1.getText().toString();
        String st2 = eT2.getText().toString();
        boolean nisim1 = valid(st1);
        boolean nisim2 = valid(st2);
        if(nisim1==true && nisim2==true){
            count ++;
            x1 = Double.parseDouble(st1);
            x2 = Double.parseDouble(st2);
            boolean temp = tB1.isChecked();
            if(temp == true){
                Math();
            }
            else
            {
                Geometrical();
            }
        }
        else{
            Toast.makeText(this, "Ronaldoooooo SOY!", Toast.LENGTH_SHORT).show();
        }

    }

    public void Math(){
        for(int i = 0; i < 20; i++){
            arr[i] = x1;
            int x  = putE(Double.toString(x1));
            String str1 = String.format("%.02f",x1);
            if(x > 2){
                items.set(i, new item(str1 + "E" + Integer.toString(x-2)))  ;
            }
            else{
                items.set(i, new item(str1));
            }
            x1 = x1 + x2;
        }
    }

    public void Geometrical(){
        for(int j = 0; j < 20; j++){
            arr[j] = x1;
            int y = putE(Double.toString(x1));
            String str4 = String.format("%.02f",x1);
            if(y > 2){
                items.set(j ,new item(str4 + "E" + Integer.toString(y-2)));
            }
            else{
                items.set(j, new item(str4)) ;
            }
            x1 = x1 * x2;
        }
    }

    public int putE(String lol){
        int q = lol.indexOf(".");
        int E = lol.indexOf("E");
        if(E == -1){
            return (lol.substring(q + 1)).length();
        }
        else{
            return (lol.substring(q + 1)).length() + Integer.parseInt(lol.substring(E + 1));
        }
    }
    public static boolean valid(String str){
        if(str.equals("") || str.equals(".") || str.equals("-.") || str.equals("-")){
            return(false);
        }
        else{
            return (true);
        }
    }

}