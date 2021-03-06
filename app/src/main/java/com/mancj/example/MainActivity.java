package com.mancj.example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.mancj.materialsearchbar.MaterialSearchBar;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MaterialSearchBar.OnSearchActionListener {
    private List<String> lastSearches;
    private MaterialSearchBar searchBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchBar = (MaterialSearchBar) findViewById(R.id.searchBar);
        searchBar.setHint("Custom hint");
        searchBar.setSpeechMode(true);
        //enable searchbar callbacks
        searchBar.setOnSearchActionListener(this);
        //restore last queries from disk
//        lastSearches = loadSearchSuggestionFromDiks();
//        searchBar.setLastSuggestions(list);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //save last queries to disk
//        saveSearchSuggestionToDisk(searchBar.getLastSuggestions());
    }

    //called when searchbar enabled or disabled
    @Override
    public void onSearchStateChanged(boolean enabled) {
        String s = enabled ? "enabled" : "disabled";
        Toast.makeText(MainActivity.this, "Search " + s, Toast.LENGTH_SHORT).show();
    }

    //called when user confirms request
    @Override
    public void onSearchConfirmed(CharSequence text) {
        startSearch(text.toString(), true, null, true);
    }

    //called when microphone icon clicked
    @Override
    public void onSpeechIconSelected() {
//        openVoiceRecognizer();
    }
}
