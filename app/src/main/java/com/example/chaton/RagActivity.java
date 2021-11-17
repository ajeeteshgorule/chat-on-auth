package com.example.chaton;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.chaton.databinding.ActivityRagBinding;

public class RagActivity extends AppCompatActivity {

    ActivityRagBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRagBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().hide();

        binding.phoneBox.requestFocus();
        binding.cpp.requestFocus();

        binding.continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RagActivity.this,OTPActivity.class);
                intent.putExtra("phoneNumber","+"+binding.cpp.getFullNumber()+binding.phoneBox.getText().toString());

                String phone=binding.phoneBox.getText().toString();
                if (phone.isEmpty() ){
                    binding.phoneBox.setError("Please Type 10 Digit Mobile Number");
                    return;
                }
                startActivity(intent);
            }
        });
    }
}