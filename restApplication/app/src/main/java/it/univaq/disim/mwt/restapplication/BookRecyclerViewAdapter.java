package it.univaq.disim.mwt.restapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class BookRecyclerViewAdapter extends RecyclerView.Adapter<BookRecyclerViewAdapter.ViewHolder> {
    private List<Book> data;
    private LayoutInflater mInflater;
    private Context context;

    BookRecyclerViewAdapter(Context context, List<Book> data){
         this.mInflater = LayoutInflater.from(context);
         this.data = data;
         this.context = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.recyclerview_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Book book = data.get(position);
        holder.title.setText(book.getTitolo());
        holder.autore.setText(book.getAutore());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }
    //inflates the row from xml

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView title;
        TextView autore;

        ViewHolder(View itemView){
            super(itemView);
            title = itemView.findViewById(R.id.book_title);
            autore = itemView.findViewById(R.id.book_autore);

            //Define the click event on item
            itemView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    Book book = data.get(getAdapterPosition());
                    Intent intent = new Intent(context, BookReviewsActivity.class);
                    intent.putExtra("book", book);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }
            });
        }

    }



}
