package com.example.video_player;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import butterknife.BindView;
import butterknife.ButterKnife;
import im.ene.toro.widget.Container;
import im.ene.toro.widget.PressablePlayerSelector;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.player_container) Container container;
    LinearLayoutManager layoutManager;
    SimpleAdapter adapter;

    PressablePlayerSelector selector;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        layoutManager = new LinearLayoutManager(this);
        container.setLayoutManager(layoutManager);
        selector = new PressablePlayerSelector(container);
        container.setPlayerSelector(selector);

        adapter = new SimpleAdapter(selector);
        container.setAdapter(adapter);
    }

    @Override
    protected void onDestroy() {
        layoutManager = null;
        adapter = null;
        selector = null;
        super.onDestroy();
    }
}
