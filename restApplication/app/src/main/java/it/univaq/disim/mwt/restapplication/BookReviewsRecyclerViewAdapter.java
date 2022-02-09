package it.univaq.disim.mwt.restapplication;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.ksoap2.serialization.SoapObject;

import java.util.List;

public class BookReviewsRecyclerViewAdapter extends RecyclerView.Adapter<BookReviewsRecyclerViewAdapter.ViewHolder>{
    private String TAG = "RVA";
    private List<SoapObject> data;
    private LayoutInflater mInflater;

    BookReviewsRecyclerViewAdapter(Context context, List<SoapObject> data){
        this.mInflater = LayoutInflater.from(context);
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.book_review_adapter, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SoapObject review = data.get(position);
        String username = review.getPropertyAsString("autorUsername");
        String text = review.getPropertyAsString("text");
        Log.d(TAG,"username" + username);
        holder.reviewUsernameTextView.setText(username);
        holder.reviewTextTextView.setText(text);

    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "Size" + data.size());
        return data.size();
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }
    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView reviewUsernameTextView;
        TextView reviewTextTextView;

        ViewHolder(View itemView) {
            super(itemView);
            reviewUsernameTextView = itemView.findViewById(R.id.review_username);
            reviewTextTextView = itemView.findViewById(R.id.review_text);
        }
    }
}
