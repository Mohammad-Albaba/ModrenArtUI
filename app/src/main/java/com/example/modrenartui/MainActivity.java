package com.example.modrenartui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.content.Intent;
import android.graphics.drawable.LevelListDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {
    private AlertDialog alertDialog;
    Button btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1=findViewById(R.id.btn1);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.color:
                View popupview = LayoutInflater.from(this).inflate(R.layout.popupwindow_layout,null);
                PopupWindow popupWindow=new PopupWindow(this);
                popupWindow.setContentView(popupview);
                popupWindow.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
                popupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
                popupWindow.showAtLocation(findViewById(R.id.container),Gravity.BOTTOM,0,300);
                SeekBar seekBar=popupview.findViewById(R.id.seekBar);
                seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                        LevelListDrawable levelListDrawable= (LevelListDrawable) ResourcesCompat.getDrawable(getResources(), R.drawable.color_button1,null);
                        Button button=findViewById(R.id.btn1);
                        button.setBackground(levelListDrawable);
                        levelListDrawable.setLevel(progress);

                        LevelListDrawable levelListDrawable2= (LevelListDrawable) ResourcesCompat.getDrawable(getResources(), R.drawable.color_button2,null);
                        Button button2=findViewById(R.id.btn2);
                        button2.setBackground(levelListDrawable2);
                        levelListDrawable2.setLevel(progress);
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
//                        seekBar.setVisibility(View.GONE);

                    }
                });
                break;
            case R.id.information:
                View dialogview= LayoutInflater.from(this).inflate(R.layout.customdialog,null);
            dialogview.findViewById(R.id.textnot).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });
                dialogview.findViewById(R.id.textvisit).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent   =new Intent(MainActivity.this,WebActivity.class);
                        startActivity(intent);
//                        alertDialog.dismiss();
                    }
                });

        alertDialog = new AlertDialog.Builder(this)
                .setView(dialogview)
                .create();
        alertDialog.show();

    }

        return super.onOptionsItemSelected(item);
    }


}