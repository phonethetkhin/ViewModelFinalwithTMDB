package com.example.viewmodelfinalwithtmdb.UI;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.viewmodelfinalwithtmdb.Adapters.MoreAdapter;
import com.example.viewmodelfinalwithtmdb.Models.HorizontalModels;
import com.example.viewmodelfinalwithtmdb.R;

import java.util.List;

public class More extends AppCompatActivity {
private RecyclerView rvMore;
List<HorizontalModels> horizontalModelsList;
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more);
horizontalModelsList=getIntent().getParcelableArrayListExtra("model");

        rvMore=findViewById(R.id.rvMore);

rvMore.setLayoutManager(new GridLayoutManager(More.this,2,RecyclerView.VERTICAL,false));
rvMore.setHasFixedSize(true);
rvMore.setAdapter(new MoreAdapter(horizontalModelsList));
    }

}
