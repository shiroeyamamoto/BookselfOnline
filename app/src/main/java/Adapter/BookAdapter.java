package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.fatscompany.bookseftonline.Entitis.Book;
import com.fatscompany.bookseftonline.R;

import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder> implements View.OnClickListener {
    List<Book> myListBook;
    Context context;
    public iClickItemUserListener itemOnClickListener;

    public BookAdapter(Context context, List<Book> myListBook) {

        this.context = context;
        this.myListBook = myListBook;
    }

    /// định nghĩa những view đã khai báo trong item


    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_book, parent, false);
        return new BookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {
        Book myBook = myListBook.get(position);
        if (myBook == null)
            return;


        Glide.with(holder.itemView.getContext())
                .load(myBook.getImage())
                .placeholder(R.drawable.favorite) // Tùy chọn: Ảnh tạm thời trong quá trình tải
                .error(R.drawable.logo) // Tùy chọn: Ảnh hiển thị khi xảy ra lỗi tải
                .into(holder.imgVBook1);
    }


    @Override
    public int getItemCount() {
        if (myListBook != null)
            return myListBook.size();
        return 0;
    }


    public void setOnClick(iClickItemUserListener ic) {
        this.itemOnClickListener = ic;
    }

    @Override
    public void onClick(View v) {

    }

    class BookViewHolder extends RecyclerView.ViewHolder {
        //// trong này thì sẽ ánh xạ view
        private ImageView imgVBook1; /// khai báo cái này để thằng viewHolder biết để show cái quần què gì ra rồi dùng nó ánh xạ vào cái viewholder
        private TextView txtTitle;
        private TextView txtAuthor;

        public BookViewHolder(@NonNull View itemView) {
            super(itemView);
            imgVBook1 = itemView.findViewById(R.id.imgVBook);
            txtTitle = itemView.findViewById(R.id.txtTitle);
            txtAuthor = itemView.findViewById(R.id.txtAuthor);

        }
    }
}
