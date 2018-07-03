package com.example.k.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private UploadTask task;
    TextView textView;

    String url="https://eykk161td0.execute-api.ap-northeast-1.amazonaws.com/stage/resource";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView)findViewById(R.id.result_text);
        Button move_to_teacher=(Button)findViewById(R.id.move_to_teachers);
        Button move_to_student=(Button)findViewById(R.id.move_to_students);
        move_to_teacher.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
               Intent intent =new Intent(getApplicationContext(),TeacherConfigActivity.class);
               startActivityForResult(intent,100);
            }
        });
        /*move_to_teacher.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String[] params = {"t1","123","234"};
                task = new UploadTask();
                task.setListener(createListener());
                task.execute(params);
            }
        });*/
    }
    @Override
    protected void onDestroy() {
        task.setListener(null);
        super.onDestroy();
    }
    private UploadTask.Listener createListener() {
        return new UploadTask.Listener() {
            @Override
            public void onSuccess(String result) {
                textView.setText(result);
            }
        };
    }
}
