package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.fatscompany.bookseftonline.Entitis.Book;
import com.fatscompany.bookseftonline.R;

import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder> {
    List<Book> myListBook;
    Context context;

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

    class BookViewHolder extends RecyclerView.ViewHolder {
        //// trong này thì sẽ ánh xạ view
        private ImageView imgVBook1; /// khai báo cái này để thằng viewHolder biết để show cái quần què gì ra rồi dùng nó ánh xạ vào cái viewholder

        public BookViewHolder(@NonNull View itemView) {
            super(itemView);
            imgVBook1 = itemView.findViewById(R.id.imgVBook);
        }
    }
}
