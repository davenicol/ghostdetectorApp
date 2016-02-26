package jfj.example.ghostdetector;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.SearchView;
import android.widget.Toast;

@SuppressLint("NewApi")
public class SearchResultsActivity extends Activity {
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        handleIntent(getIntent());
    }

	
	protected void onNewIntent(Intent intent) {
        handleIntent(intent);
    }
	
	DatabaseTable db = new DatabaseTable(this);


    private void handleIntent(Intent intent) {
    	

	    if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
	        String query = intent.getStringExtra(SearchManager.QUERY);
	        Cursor c = db.getWordMatches(query, null);
	        	
	       if(c == (null)){
	        Toast.makeText(this, "T6ast", Toast.LENGTH_SHORT)
	          .show();}
	    }
	        
        }
    

	@SuppressLint("NewApi")
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);

        // Associate searchable configuration with the SearchView
        SearchManager searchManager =
               (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView =
                (SearchView) menu.findItem(R.id.action_settings).getActionView();
        searchView.setSearchableInfo(
                searchManager.getSearchableInfo(getComponentName()));

        return true;
    }
	
	
}
