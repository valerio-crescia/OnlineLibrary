package it.univaq.disim.mwt.restapplication;

import android.os.AsyncTask;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.loader.content.AsyncTaskLoader;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import it.univaq.disim.mwt.restapplication.databinding.ActivityBookReviewsBinding;

public class BookReviewsActivity extends AppCompatActivity {

    private BookReviewsRecyclerViewAdapter adapter;
    List<SoapObject> soapObjects = new ArrayList();
    private RecyclerView recyclerView;

    private String TAG = "Soap Client";

    private Book book;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_reviews);

        recyclerView = findViewById(R.id.rvResponse);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new BookReviewsRecyclerViewAdapter(getApplicationContext(),soapObjects);
        recyclerView.setAdapter(adapter);

        AsyncCallWs task = new AsyncCallWs();

        //in SecondActivity
        if(getIntent().getExtras() != null) {
            book = getIntent().getParcelableExtra("book");
            task.execute(book.getId());

            // ActionBar title
            ActionBar actionBar = getSupportActionBar();
            if(actionBar != null)
            {
                actionBar.setTitle(book.getTitolo());
            }
        }

    }

    private class AsyncCallWs extends AsyncTask<Integer, Integer, Void> {

        @Override
        protected Void doInBackground(Integer... params) {
            Log.i(TAG, "doInBackground");
            getReviews(params[0]);
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            Log.i(TAG, "onPostExecute");
        }


        @Override
        protected void onPreExecute() {
            Log.i(TAG, "onPreExecute");
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            Log.i(TAG, "onProgressUpdate");
        }
    }

        public void getReviews(int bookid) {

            String NAMESPACE = "http://api.reviewservice.sose.univaq.it/";
            String METHOD_NAME = "getReviewsByBook";
            String WSDL_URL = "http://10.0.2.2:8080/ReviewService/message";
            String SOAP_ACTION = "";
            try {
                SoapObject Request = new SoapObject(NAMESPACE, METHOD_NAME);
                Request.addProperty("idBook", bookid);

                SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
                soapEnvelope.dotNet = false;
                soapEnvelope.setOutputSoapObject(Request);

                HttpTransportSE transport = new HttpTransportSE(WSDL_URL);


                transport.call(SOAP_ACTION, soapEnvelope);
                Vector<SoapObject> result = (Vector<SoapObject>) soapEnvelope.getResponse();
                Log.i(TAG, "Response received: '" + result + "'");

                this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        soapObjects.clear();
                        if(result != null) {
                            soapObjects.addAll(result);

                        }
                        adapter.notifyDataSetChanged();


                    }
                });

            } catch (Exception ex) {
                Log.e(TAG, "Error: " + ex.getMessage());
            }
        }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        getMenuInflater().inflate(R.menu.menu_book_reviews, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.back:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }


}