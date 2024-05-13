package com.example.mirea_prac_9_3;

import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import android.Manifest.permission;


public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private EditText nameOfFile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        textView = findViewById(R.id.textView);
        nameOfFile = findViewById(R.id.editTextText);

    }

    public void read(View view) {
        Log.d("RRR","Заход 1");
        String fileName = nameOfFile.getText().toString();
        File dir = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS), "mirea");
        Log.d("RRR",dir.toString());
        Log.d("RRR","Заход 2");



        File file = new File(dir, fileName);
        file.getAbsolutePath();
        Log.d("RRR",fileName.toString());
        Log.d("RRR","Заход 3");
        Log.d("RRR",file.getAbsolutePath().toString());

        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line;
            Log.d("RRR","Заход 4");
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
                Log.d("RRR","Заход 5");
            }
            bufferedReader.close();
            textView.setText(stringBuilder.toString());
            Log.d("RRR","Заход 6");
        } catch (FileNotFoundException e) {
            Toast.makeText(this, "Файл не найден", Toast.LENGTH_SHORT).show();
            Log.d("RRR","Заход 7");
            Log.d("RRR",e.getMessage().toString());
        } catch (IOException e) {
            Toast.makeText(this, "Ошибка!", Toast.LENGTH_SHORT).show();
            Log.d("RRR",e.getMessage().toString());
        }
    }






}

