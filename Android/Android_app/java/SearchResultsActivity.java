package com.example.hamza.bibliotheque;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

/**
 * Created by nguyen on 07/12/16.
 */
public class SearchResultsActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        handleIntent(getIntent());
    }

    @Override
    protected void onNewIntent(Intent intent) {
        setIntent(intent);
        handleIntent(intent);
    }
    public void onListItemClick(ListView l, View v,
                                int position, long id) {

    }
    private void handleIntent(Intent intent) {

        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            //use the query to search your data somehow
            doSearch(query);
        }
    }
    private void doSearch(String queryStr) {

    }
}