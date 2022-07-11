package com.renvictus.salarycalculator;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.renvictus.salarycalculator.calculations.SalaryConverter;
import com.renvictus.salarycalculator.databinding.FragmentMainScreenBinding;

public class MainScreen extends Fragment {

    private FragmentMainScreenBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        int temp;
        binding = FragmentMainScreenBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        binding.calculateButtonNet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.editTextFieldGross.getText().length() > 0) {
                    binding.editTextFieldNet.setText(
                            String.valueOf(SalaryConverter.grossIncomeToNet(Double.parseDouble(binding.editTextFieldGross.getText().toString())))
                    );
                } else {
                    Toast.makeText(getContext(), "Enter value to NET field", Toast.LENGTH_SHORT).show();
                }
            }
        });

        binding.calculateButtonGross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(binding.editTextFieldNet.getText().length() > 0){
                    binding.editTextFieldGross.setText(
                            String.valueOf(SalaryConverter.netIncomeToGross(Double.parseDouble(binding.editTextFieldNet.getText().toString())))
                    );
                }else {
                    Toast.makeText(getContext(), "Enter value to Gross field", Toast.LENGTH_SHORT).show();
                }/*
                Toast.makeText(getContext(), "Work in progress", Toast.LENGTH_SHORT).show();*/
            }
        });

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}