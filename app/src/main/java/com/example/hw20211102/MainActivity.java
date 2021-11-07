package com.example.hw20211102;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    RadioGroup rdg1, rdg2;
    RadioButton rd1, rd2, rd3, rd4, rd5, rd6;
    Spinner sp1;
    TextView txt1, txt2, txt3, txt4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] food = new String[]{"西瓜汁", "柳橙汁", "蘋果汁"};
        ArrayAdapter<String> adp = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, food);
        adp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        sp1 = (Spinner) findViewById(R.id.sp1);

        rdg1 = (RadioGroup) findViewById(R.id.rdg1);
        rdg2 = (RadioGroup) findViewById(R.id.rdg2);

        txt1 = (TextView) findViewById(R.id.txt1);
        txt2 = (TextView) findViewById(R.id.txt2);
        txt3 = (TextView) findViewById(R.id.txt3);
        txt4 = (TextView) findViewById(R.id.txt4);

        rd1 = (RadioButton) findViewById(R.id.rd1);
        rd2 = (RadioButton) findViewById(R.id.rd2);
        rd3 = (RadioButton) findViewById(R.id.rd3);
        rd4 = (RadioButton) findViewById(R.id.rd4);
        rd5 = (RadioButton) findViewById(R.id.rd5);
        rd6 = (RadioButton) findViewById(R.id.rd6);

        rdg1.setOnCheckedChangeListener(myrad1);
        rdg2.setOnCheckedChangeListener(myrad2);
        sp1.setAdapter(adp);
        sp1.setOnItemSelectedListener(app);
    }
    private AdapterView.OnItemSelectedListener app=new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            String sel =parent.getSelectedItem().toString();
            txt4.setText("你所點的飲料是"+sel);
        }
        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };
    private RadioGroup.OnCheckedChangeListener myrad1 = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            String a = "";
            RadioButton su = (RadioButton) findViewById(checkedId);
            txt4.setText("糖分是" + su.getText());
        }
    };
    private RadioGroup.OnCheckedChangeListener myrad2 = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            String a = "";
            RadioButton cd = (RadioButton) findViewById(checkedId);
            txt4.setText("冰塊是" + cd.getText());
        }
    };

}

