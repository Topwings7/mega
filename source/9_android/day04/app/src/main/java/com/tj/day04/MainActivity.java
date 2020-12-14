package com.tj.day04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView tvResult;
    private Button btnCE, btnC, btnDel, btnPow;
    private Button[] btnNum = new Button[10];
    private int[] id = {R.id.btnNum0, R.id.btnNum1, R.id.btnNum2,
            R.id.btnNum3, R.id.btnNum4, R.id.btnNum5, R.id.btnNum6,
            R.id.btnNum7, R.id.btnNum8, R.id.btnNum9};
    private Button btnAdd, btnSub, btnMul, btnDiv, btnPoint, btnResult;
    private double num1, num2;
    private String tempResult;
    private String op=""; // 연산자의 종류를 잠시 저장하는 용도
    private boolean power;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("본인 이름");
        tvResult = findViewById(R.id.tvResult);
        btnCE = findViewById(R.id.btnCE);
        btnC = findViewById(R.id.btnC);
        btnDel = findViewById(R.id.btnDel);
        btnPow = findViewById(R.id.btnPow);
        for(int i=0 ; i<id.length ; i++) {
            btnNum[i] = findViewById(id[i]);
        }
        btnAdd = findViewById(R.id.btnAdd);
        btnSub = findViewById(R.id.btnSub);
        btnMul = findViewById(R.id.btnMul);
        btnDiv = findViewById(R.id.btnDiv);
        btnPoint = findViewById(R.id.btnPoint);
        btnResult = findViewById(R.id.btnResult);
        power = true;
        btnPow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(power){ // 파워가 true면 끄고(false), 파워가 false면 켬
                    power = false;
                    tvResult.setText("");
                }else{
                    power = true;
                    tvResult.setText("0");
                }
                btnCE.setEnabled(power);
                btnC.setEnabled(power);
                btnDel.setEnabled(power);
                btnAdd.setEnabled(power);
                btnSub.setEnabled(power);
                btnMul.setEnabled(power);
                btnDiv.setEnabled(power);
                btnPoint.setEnabled(power);
                btnResult.setEnabled(power);
                for(int i=0 ; i<id.length ; i++){
                    btnNum[i].setEnabled(power);
                }
                num1 = 0; num2 = 0; op=""; // 계산을 담는 변수들 초기화
            }
        });//btnPow 의 이벤트
        btnPoint.setOnClickListener(numClickListener);
        for(int i=0 ; i<id.length ; i++){
            btnNum[i].setOnClickListener(numClickListener);
        }// btnNum들과 btnPoint 의  이벤트
        btnAdd.setOnClickListener(opClickListener);
        btnSub.setOnClickListener(opClickListener);
        btnMul.setOnClickListener(opClickListener);
        btnDiv.setOnClickListener(opClickListener);// op들 이벤트
        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (op){
                    case  "" : num1 = num2; break;
                    case "+" : num1 += num2; break;
                    case "-" : num1 -= num2; break;
                    case "*" : num1 *= num2; break;
                    case "/" : num1 /= num2; break;
                }
                tempResult = String.valueOf(num1);
                if(tempResult.indexOf(".0")==tempResult.length()-2){
                    tempResult = tempResult.substring(0, tempResult.length()-2);
                }
                tvResult.setText(tempResult);
                num1 = num2 = 0; op="";
            }
        });// btnResult의 이벤트
        btnCE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num2 = 0;
                tvResult.setText("0");
            }
        });// btnCE의 이벤트
        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = num2 = 0 ; op="";
                tvResult.setText("0");
            }
        });// btnC의 이벤트
        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tempResult = tvResult.getText().toString();
                int length = tempResult.length();
                if(length>1){
                    tempResult = tempResult.substring(0, length-1);
                }else{
                    tempResult = "0";
                }
                tvResult.setText(tempResult);//화면에 있는 우측수 하나 없애기
                num2 = Double.parseDouble(tvResult.getText().toString()); // num2반영
            }
        });// btnDel의 이벤트
    }//onCreate 메소드
    private View.OnClickListener opClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            num2 = Double.parseDouble(tvResult.getText().toString());
            switch (op){
                case  "" : num1 = num2; break;
                case "+" : num1 += num2; break;
                case "-" : num1 -= num2; break;
                case "*" : num1 *= num2; break;
                case "/" : num1 /= num2; break;
            }
            num2 = 0;
            op = ((Button)v).getText().toString();
            tempResult = String.valueOf(num1);
            if(tempResult.indexOf(".0")==tempResult.length()-2){
                tempResult = tempResult.substring(0, tempResult.length()-2);
            }
            tvResult.setText(tempResult);
        }
    };
    private View.OnClickListener numClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(num2==0 && !tvResult.getText().toString().equals("0.")){
                tvResult.setText("");
            }
            switch (v.getId()){
                case R.id.btnNum0: tvResult.append("0");break;
                case R.id.btnNum1: tvResult.append("1");break;
                case R.id.btnNum2: tvResult.append("2");break;
                case R.id.btnNum3: tvResult.append("3");break;
                case R.id.btnNum4: tvResult.append("4");break;
                case R.id.btnNum5: tvResult.append("5");break;
                case R.id.btnNum6: tvResult.append("6");break;
                case R.id.btnNum7: tvResult.append("7");break;
                case R.id.btnNum8: tvResult.append("8");break;
                case R.id.btnNum9: tvResult.append("9");break;
                case R.id.btnPoint:
                    if(tvResult.getText().toString().equals("")){
                        tvResult.setText("0.");
                    }else if(tvResult.getText().toString().indexOf(".")==-1){
                        tvResult.append(".");
                    }else{
                        Toast.makeText(getApplicationContext(),
                                "소수점이 두개일 수 없음",Toast.LENGTH_LONG).show();
                    }//if
            }//switch
            num2 = Double.parseDouble(tvResult.getText().toString());
            System.out.println("현재 num2 = "+num2);
        }//onClick
    };// 변수
}// class











