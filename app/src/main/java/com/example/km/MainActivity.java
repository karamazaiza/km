package com.example.km;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.recycler_view_apps);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        List<AppItem> appList = createMockData();
        AppListAdapter adapter = new AppListAdapter(appList);
        recyclerView.setAdapter(adapter);
    }

    private List<AppItem> createMockData() {
        List<AppItem> data = new ArrayList<>();

        data.add(new AppItem(1, R.drawable.ic_block_blast, "Block Blast!", "Puzzle • Block • Casual • Offline", 4.5f, 161, false, null));
        data.add(new AppItem(2, R.drawable.ic_vita_mahjong, "Vita Mahjong", "Board • Puzzle • Mahjong solitaire", 4.6f, 142, false, null));
        data.add(new AppItem(3, R.drawable.ic_jigsolitaire, "Jigsolitaire", "Puzzle", 4.3f, 71, false, null));
        data.add(new AppItem(4, R.drawable.ic_tile_explorer, "Tile Explorer - Triple Match", "Puzzle • Match 3 • Casual • Offline", 4.5f, 59, true, "Ends in 6 days"));
        data.add(new AppItem(5, R.drawable.ic_water_match, "Water Match™- ASMR Water Sort", "Casual", 4.7f, 174, false, null));
        data.add(new AppItem(6, R.drawable.ic_roblox, "Roblox", "Adventure • Simulation • Sandbox", 4.4f, 190, true, "Ends on 29/12/2025"));
        data.add(new AppItem(7, R.drawable.ic_happy_color, "Happy Color®: Colouring Game", "Casual • Art & Design", 4.7f, 190, false, null));

        return data;
    }
}