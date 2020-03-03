package com.daya.nodo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewNoDoActivity extends AppCompatActivity {
    public static final String EXTRA_REPLY = "com.dayakar";
    private EditText noDoEdit;
    private Button saveButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_no_do);
        noDoEdit = findViewById(R.id.editNodo);
        saveButton = findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent reply = new Intent();
                if(noDoEdit.getText().toString().isEmpty()){
                    setResult(RESULT_CANCELED,reply);
                    Log.d("ONETHING", "onClick: "+"came here");
                }else{
                    String sample = noDoEdit.getText().toString();
                    reply.putExtra(EXTRA_REPLY,sample);
                    setResult(RESULT_OK,reply);
                }
                finish();
            }
        });
    }

}
