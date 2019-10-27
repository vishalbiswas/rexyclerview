package com.vishalbiswas.rexyclerviewexample;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;
import com.vishalbiswas.rexyclerviewexample.adapters.CategoriesAdapter;
import com.vishalbiswas.rexyclerviewexample.models.Category;
import com.vishalbiswas.rexyclerviewexample.utils.DataProvider;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Category> categories = new ArrayList<>();
    private RecyclerView categoriesView;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadData();
        bindViews();
    }

    private void loadData() {
        categories = Arrays.asList(DataProvider.getCategories());
    }

    private void bindViews() {
        categoriesView = findViewById(R.id.categories);
        button = findViewById(R.id.filter);

        categoriesView.setLayoutManager(new LinearLayoutManager(this));
        final CategoriesAdapter adapter = new CategoriesAdapter(this, categories);
        categoriesView.setAdapter(adapter);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringBuilder sb = new StringBuilder();
                for (int id : adapter.getSelectedIds())
                {
                    sb.append(id);
                    sb.append(",");
                }
                final AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                alert.setTitle(getString(R.string.selectedItemIds));
                alert.setMessage(sb.toString());
                alert.create().show();
            }
        });
    }
}
