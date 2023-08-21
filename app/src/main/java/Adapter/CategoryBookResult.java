package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.fatscompany.bookseftonline.Entitis.Book;
import com.fatscompany.bookseftonline.R;

import java.text.DecimalFormat;
import java.util.List;

public class CategoryBookResult extends RecyclerView.Adapter<CategoryBookResult.CategoryBookResultViewHolder> {
    private List<Book> myListBook;
    private Context context;
    private ItemOnClickListener itemOnClickListener;

    public CategoryBookResult(Context context, List<Book> myListBook) {
        this.context = context;
        this.myListBook = myListBook;

    }

    @NonNull
    @Override
    public CategoryBookResultViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_book_category_result, parent, false);
        return new CategoryBookResultViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryBookResultViewHolder holder, int position) {
        Book myBook = myListBook.get(position);
        if (myBook == null)
            return;

        holder.txtTitle.setText(myBook.getTitle());
        holder.txtAuthor.setText(myBook.getAuthors());

        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        String formattedPrice = decimalFormat.format(myBook.getPrice());
        holder.txtPrice.setText("Price: $" + formattedPrice);

        Glide.with(holder.itemView.getContext())
                .load(myBook.getImage())
                .into(holder.imgVBook);

        holder.btnDecrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentQuantity = myBook.getCurrentQuantity();
                if (currentQuantity > 1) {
                    currentQuantity--;
                    myBook.setCurrentQuantity(currentQuantity);
                    holder.edtQuantity.setText(String.valueOf(currentQuantity));
                }
            }
        });

        holder.btnIncrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentQuantity = myBook.getCurrentQuantity();
                currentQuantity++;
                myBook.setCurrentQuantity(currentQuantity);
                holder.edtQuantity.setText(String.valueOf(currentQuantity));
            }
        });

        holder.btnAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (itemOnClickListener != null) {
                    itemOnClickListener.onAddToCartClicked(myBook);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        if (myListBook != null)
            return myListBook.size();
        return 0;
    }

    public interface ItemOnClickListener {
        void onAddToCartClicked(Book book);
    }

    public class CategoryBookResultViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgVBook;
        private TextView txtTitle;
        private TextView txtAuthor;
        private TextView txtPrice;
        private Button btnDecrease;
        private EditText edtQuantity;
        private Button btnIncrease;
        private Button btnAddToCart;

        public CategoryBookResultViewHolder(@NonNull View itemView) {
            super(itemView);
            imgVBook = itemView.findViewById(R.id.imgVBook);
            txtTitle = itemView.findViewById(R.id.txtTitle);
            txtAuthor = itemView.findViewById(R.id.txtAuthor);
            txtPrice = itemView.findViewById(R.id.txtPrice);
            btnDecrease = itemView.findViewById(R.id.btnDecrease);
            edtQuantity = itemView.findViewById(R.id.edtQuantity);
            btnIncrease = itemView.findViewById(R.id.btnIncrease);
            btnAddToCart = itemView.findViewById(R.id.btnAddToCart);
        }
    }
}
