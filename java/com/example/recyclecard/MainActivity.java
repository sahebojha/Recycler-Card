package com.example.recyclecard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<example_item> exampleList;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    private Button buttonAdd,buttonDel;
    private EditText editTextAdd,editTextDel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonAdd = findViewById(R.id.buttonadd);
        buttonDel = findViewById(R.id.buttondelete);
        editTextAdd = findViewById(R.id.edittextadd);
        editTextDel = findViewById(R.id.edittextdelete);

       buttonAdd.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               int position =Integer.parseInt(editTextAdd.getText().toString());
               addCard(position);
               //adapter.notifyDataSetChanged();
               adapter.notifyItemInserted(position);

           }
       });

       buttonDel.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               int position =Integer.parseInt(editTextDel.getText().toString());
               removeCard(position);
               adapter.notifyItemInserted(position);
           }
       });

        generateFakeData();

        recyclerViewConfig();

    }
    public  void  generateFakeData(){
        exampleList = new ArrayList<>();

        exampleList.add(new example_item(R.drawable.node, "Clicked at studio"));
        exampleList.add(new example_item(R.drawable.oner, "Clicked at India"));
        exampleList.add(new example_item(R.drawable.twor, "Clicked at Australia"));
        exampleList.add(new example_item(R.drawable.threer, "Clicked at Newzeland"));
        exampleList.add(new example_item(R.drawable.fourr, "Clicked at Africa"));
        exampleList.add(new example_item(R.drawable.fiver, "Clicked at Barlin"));
        exampleList.add(new example_item(R.drawable.sixr, "Clicked at India"));
    }
    public void recyclerViewConfig(){
        //config for RV
        recyclerView = findViewById(R.id.recyclerView);
        //TODO :: performance
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        adapter = new ExampleAdapter(exampleList);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    public void addCard(int position){
        exampleList.add(position, new example_item(R.drawable.node, "new card added"));
    }

    public void removeCard(int position){
        exampleList.remove(position);
    }
}
