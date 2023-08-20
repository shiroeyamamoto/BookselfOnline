package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fatscompany.bookseftonline.Entitis.Book;
import com.fatscompany.bookseftonline.Entitis.Category;
import com.fatscompany.bookseftonline.R;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CateHolderView> {
    List<Category> cates;
    Context context;

    public CategoryAdapter(Context context, List<Category> cates) {
        this.context = context;
        this.cates = cates;
    }

    @NonNull
    @Override
    public CateHolderView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_category, parent, false);
        RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) view.getLayoutParams();
        params.setMargins(16, 16, 16, 16);
        view.setLayoutParams(params);

        return new CategoryAdapter.CateHolderView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CateHolderView holder, int position) {
        Category myCate = cates.get(position);
        if (myCate == null)
            return;
        holder.btnCate.setText(myCate.getName());
    }

    @Override
    public int getItemCount() {
        if (cates != null)
            return cates.size();
        return 0;
    }

    class CateHolderView extends RecyclerView.ViewHolder {
        private Button btnCate;

        public CateHolderView(@NonNull View itemView) {
            super(itemView);
            btnCate = itemView.findViewById(R.id.btnCate);
        }

    }

}
