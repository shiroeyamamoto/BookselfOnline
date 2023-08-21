package com.fatscompany.bookseftonline.FragmentCode;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fatscompany.bookseftonline.R;
import com.fatscompany.bookseftonline.databinding.FragmentAdminStatisticBinding;
import com.github.mikephil.charting.charts.LineChart;


public class AdminStatisticFrag extends Fragment {

    private FragmentAdminStatisticBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        return inflater.inflate(R.layout.fragment_admin_statistic, container, false);
    }
}