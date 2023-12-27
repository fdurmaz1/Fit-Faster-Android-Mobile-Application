package com.example.termproject;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;


public class BodyMassIndexFragment extends Fragment {

    public BodyMassIndexFragment() {
        // Required empty public constructor
    }

    EditText input_weight, input_height;
    Button btn_BMI_Calculate;
    TextView txtBMI, txtBMIResult;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_body_mass_index, container, false);
        input_weight = view.findViewById(R.id.txtWeight);
        input_height = view.findViewById(R.id.txtHeight);
        btn_BMI_Calculate = view.findViewById(R.id.btnBMICalculate);
        txtBMI = view.findViewById(R.id.txtBMI);
        txtBMIResult = view.findViewById(R.id.txtBMIResult);

        btn_BMI_Calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double height = 0;
                double weight = 0;
                double bmi = 0;
                String msg="";

                weight = Double.parseDouble(input_weight.getText().toString());
                height = Double.parseDouble(input_height.getText().toString());
                bmi = height * height;
                bmi = weight / bmi;
                DecimalFormat df = new DecimalFormat();
                df.setMaximumFractionDigits(2);

                txtBMI.setText(df.format(bmi));

                if (bmi < 18.5){
                    msg = "Underweight, Please try our Full body Weight lifting program.";
                }else if(bmi>18.5 && bmi<25){
                    msg = "Normal, Please try our Full body Weight lifting program.";
                }else if(bmi>25){
                    msg = "Overweight, Please try our Fat Burning program.";
                }


                String finalMsg = msg;
                txtBMIResult.setText(finalMsg);
            }
        });
        return view;

    }


}