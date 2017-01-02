package com.example.superlativeequation;

import android.app.Activity;
import android.graphics.CornerPathEffect;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	private EditText edtInputCoefficientA, edtInputCoefficientB;
	private Button btnCalculate;
	private TextView txtResult;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//Mapped
		onMapped();
		
		//Catch even when click button
		onClickButton();
	}

	private void onClickButton() {
		btnCalculate.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				//Convert EditText to String and continue to Float number
				Float coefficient_a = Float.valueOf(edtInputCoefficientA.getText().toString());
				Float coefficient_b = Float.valueOf(edtInputCoefficientB.getText().toString());
				
				//Some case of equation
				if(coefficient_a==0){//a==0
					if(coefficient_b!=0){
						txtResult.setText("The equation has no solution");
					}else{//b=0
						txtResult.setText("Equations infinitely many solutions");
					}
				}else{//a!=0
					Float solution = (-coefficient_b)/coefficient_a;
					txtResult.setText("The equation has a unique solution: "+String.valueOf(solution));
				}
			}
		});		
	}

	private void onMapped() {
		edtInputCoefficientA = (EditText) findViewById(R.id.edtInputCoefficientA);	
		edtInputCoefficientB = (EditText) findViewById(R.id.edtInputCoefficientB);
		btnCalculate = (Button) findViewById(R.id.btnCalculate);
		txtResult = (TextView) findViewById(R.id.txtResult);
	}
}
