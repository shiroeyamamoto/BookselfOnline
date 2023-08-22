package Adapter;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.fatscompany.bookseftonline.Entitis.User;
import com.fatscompany.bookseftonline.R;
import com.github.mikephil.charting.charts.LineChart;

import java.util.ArrayList;
import java.util.List;

public class UserStatisticAdapter extends RecyclerView.Adapter<UserStatisticAdapter.UserStatisticViewHolder> {

    List<UserStatisticAdapter> userStatisticAdapterList;

    ArrayList<User> userArrayList;


    @NonNull
    @Override
    public UserStatisticAdapter.UserStatisticViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull UserStatisticAdapter.UserStatisticViewHolder holder, int position) {
        UserStatisticAdapter userStatisticAdapter = userStatisticAdapterList.get(position);
        if(userStatisticAdapter == null){
            return;
        }


    }

    @Override
    public int getItemCount() {

        return 0;
    }

    public class UserStatisticViewHolder extends RecyclerView.ViewHolder {

        private TextView txtFullName;

        private TextView txtTotalOrders;

        private LineChart lineChart;

        private ConstraintLayout userStatictisLayout;

        public UserStatisticViewHolder(@NonNull View itemView) {
            super(itemView);
            txtFullName = itemView.findViewById(R.id.txtFullName);
            txtTotalOrders = itemView.findViewById(R.id.txtTotalOrders);
            lineChart = itemView.findViewById(R.id.chartUser);
            userStatictisLayout = itemView.findViewById(R.id.userStatisticLayout);
        }
    }
}
