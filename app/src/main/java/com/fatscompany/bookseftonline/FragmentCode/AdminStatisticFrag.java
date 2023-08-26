package com.fatscompany.bookseftonline.FragmentCode;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.fatscompany.bookseftonline.Database.DatabaseAdapter;
import com.fatscompany.bookseftonline.Database.DatabaseController;
import com.fatscompany.bookseftonline.AdminActivity;
import com.fatscompany.bookseftonline.AppDatabase;
import com.fatscompany.bookseftonline.Entitis.User;
import com.fatscompany.bookseftonline.Entitis.UserData;
import com.fatscompany.bookseftonline.R;
import com.fatscompany.bookseftonline.databinding.FragmentAdminStatisticBinding;
import com.fatscompany.bookseftonline.databinding.UserStatisicLayoutBinding;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import Adapter.UserAdapter;
import Adapter.UserStatisticAdapter;
import Adapter.iClickItemUserListener;


public class AdminStatisticFrag extends Fragment {

    //private DatabaseAdapter db;
    private FragmentAdminStatisticBinding binding;
    private List<User> userList;

    private List<UserData> userDataList;

    private UserStatisticAdapter statisticAdapter;

    private UserStatisicLayoutBinding userStatisicBinding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        AdminActivity adminActivity = (AdminActivity) getActivity();
        binding = FragmentAdminStatisticBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        RecyclerView rcv = view.findViewById(R.id.rcvUserStatistic);
        rcv.setLayoutManager(linearLayoutManager);

        AppDatabase database = AppDatabase.getInstance(getActivity());
        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(new Runnable() {
            @Override
            public void run() {
                database.runInTransaction(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            userList = database.userDao().selectAll();

                            if(userList==null){
                                return;
                            }

                            getActivity().runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    statisticAdapter = new UserStatisticAdapter(getContext(), userList);
                                    rcv.setAdapter(statisticAdapter);
                                }
                            });

                        }catch (Exception ex){

                        }
                    }
                });
            }
        });
        return view;
    }
}