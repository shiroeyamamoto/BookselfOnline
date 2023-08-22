package com.fatscompany.bookseftonline.FragmentCode;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fatscompany.bookseftonline.R;
import com.fatscompany.bookseftonline.databinding.FragmentAdminStatisticBinding;
import com.fatscompany.bookseftonline.databinding.UserStatisicBinding;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;


public class AdminStatisticFrag extends Fragment {

    private FragmentAdminStatisticBinding binding;

    private UserStatisicBinding userStatisicBinding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        /*//dau vao
        ArrayList<Entry> entries = new ArrayList<>();
        entries.add(new Entry(0, 5));
        entries.add(new Entry(1, 8));
        entries.add(new Entry(2, 4));

        // set data cho no
        LineDataSet dataSet = new LineDataSet(entries, "Sample Line Data");
        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(dataSet);

        LineData lineData = new LineData(dataSets);

        userStatisicBinding.chartUser.setData(lineData);

        Description description = new Description();
        description.setText("Line Chart Example");
        userStatisicBinding.chartUser.setDescription(description);
        userStatisicBinding.chartUser.animateX(1000); // Animation duration in milliseconds*/

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        binding.rcvUserStatistic.setLayoutManager(linearLayoutManager);


        return inflater.inflate(R.layout.fragment_admin_statistic, container, false);
    }
}