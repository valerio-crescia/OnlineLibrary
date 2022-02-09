package it.univaq.disim.mwt.restapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {
    private BookRecyclerViewAdapter adapter;
    List<Book> bookList = new ArrayList<Book>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ActionBar title
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setTitle("Libreria online");
        }

        //set up the recyclerView
        final RecyclerView recyclerView = findViewById(R.id.recyclerView_book);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        RequestParams params = new RequestParams();
        params.add("_limit", "100");

        RestClient.get("BookServiceProsumer/rest/books", params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                // Handle success
                Log.i("INFO", new String(responseBody));
                try {
                    JSONArray resp = new JSONArray(new String(responseBody));
                    for (int i=0; i< resp.length(); i++) {
                        JSONObject respObj = (JSONObject) resp.get(i);
                        Book book = new Book(
                                respObj.getInt("id"),
                                respObj.getString("titolo"),
                                respObj.getString("autore"),
                                respObj.getInt("annoPubblicazione"),
                                respObj.getInt("numeroCopieDisponibili"),
                                respObj.getString("isbn"),
                                respObj.getDouble("weight"),
                                respObj.getDouble("price")
                                );

                        bookList.add(book);
                        Log.i("Book", book.toString());
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                adapter = new BookRecyclerViewAdapter(getApplicationContext(), bookList);
                recyclerView.setAdapter(adapter);


            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                // Handle error
                error.printStackTrace();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        getMenuInflater().inflate(R.menu.menu_books,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);

        switch (item.getItemId()){
            case R.id.exit:
                finish();
                System.exit(0);
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }
}