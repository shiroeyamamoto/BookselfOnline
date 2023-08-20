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
import com.fatscompany.bookseftonline.Entitis.User;
import com.fatscompany.bookseftonline.R;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {
    List<User> listUser;
    Context context;

    public UserAdapter(List<User> listUser, Context context) {
        this.listUser = listUser;
        this.context = context;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_user, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user = listUser.get(position);
        if (user == null)
            return;
        holder.imgUser.setImageResource(R.drawable.baseline_account_circle_24);
        holder.txtName.setText(user.getLastName() + " " +user.getFirstName());
        holder.userRole.setText((user.getUserRole()));
    }


    @Override
    public int getItemCount() {
        if (listUser != null)
            return listUser.size();
        return 0;
    }

    class UserViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgUser;
        private TextView txtName;
        private TextView userRole;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            imgUser = itemView.findViewById(R.id.imgUser);
            txtName = itemView.findViewById(R.id.txtName);
            userRole = itemView.findViewById(R.id.txtUserRole);
        }
    }
}
