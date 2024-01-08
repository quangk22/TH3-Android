package com.example.recyclerviewth3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class AddEditOne extends AppCompatActivity {
    Button btn_cancle ,btn_ok;
    List<President> presidentList;
    EditText et_presidentDate, et_presName,et_presImageURL;
    MyApplication myApplication ;
    TextView tv_presId;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_one);
        myApplication = (MyApplication) this.getApplication();
        presidentList = myApplication.getPresidentList();
//        ánh xạ
        btn_cancle = findViewById(R.id.btn_cancle);
        btn_ok = findViewById(R.id.bnt_OK);
        et_presidentDate = findViewById(R.id.ed_date);
        et_presName = findViewById(R.id.ed_name);
        et_presImageURL = findViewById(R.id.ed_image);
        tv_presId = findViewById(R.id.tv_preresidentIDNumber);

        Intent intent = getIntent();
        id = intent.getIntExtra("id",-1);
        President president = null;
        if (id >= 0){
            for (President p: presidentList ) {
                if (p.getId() == id) {
                        president = p;
                }
            }
            et_presName.setText(president.getName());
            et_presidentDate.setText(String.valueOf(president.getDateOfElection()));
            et_presImageURL.setText(president.getImageURL());
            tv_presId.setText(String.valueOf(id));
        }else {

        }

        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (id >- 1){
                    President updatePresident = new President(id,et_presName.getText().toString(),Integer.parseInt(et_presidentDate.getText().toString()),et_presImageURL.getText().toString());
                    presidentList.set(id,updatePresident);
                }else {
                    int nextID = myApplication.getNextID();
                    President newPresident = new President(nextID, et_presName.getText().toString(),Integer.parseInt(et_presidentDate.getText().toString()),et_presImageURL.getText().toString());
                    presidentList.add(newPresident);
                    myApplication.setNextID(nextID + 1);
                }



                Intent intent = new Intent(AddEditOne.this,MainActivity.class);
                startActivity(intent);
            }
        });
        btn_cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddEditOne.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}