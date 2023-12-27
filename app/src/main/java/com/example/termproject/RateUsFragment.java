package com.example.termproject;

import android.app.Dialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;


public class RateUsFragment extends Fragment {

    public RateUsFragment() {
        // Required empty public constructor
    }

    RatingBar rbRatingbar;
    Button mDialogButton;
    TextView okay_text, cancel_text;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_rate_us2, container, false);

        mDialogButton=view.findViewById(R.id.btnSubmit);
        rbRatingbar=view.findViewById(R.id.rbRatingBar);
        Dialog dialog = new Dialog(getContext());

        mDialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double ratingValue = rbRatingbar.getRating();
                String rating = String.valueOf(ratingValue);
                Toast.makeText(getContext(), rating, Toast.LENGTH_SHORT).show();
                dialog.setContentView(R.layout.rateus_dialog);
                dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                dialog.setCancelable(false);
                dialog.getWindow().getAttributes().windowAnimations = R.style.Theme_TermProject;

                okay_text = dialog.findViewById(R.id.okay_text);
                cancel_text = dialog.findViewById(R.id.cancel_text);

                okay_text.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                        Toast.makeText(getContext(), "Thanks for your feedback!", Toast.LENGTH_SHORT).show();
                    }
                });

                cancel_text.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                        Toast.makeText(getContext(), "Cancel clicked", Toast.LENGTH_SHORT).show();
                    }
                });

                dialog.show();
            }
        });

        return view;
    }
}