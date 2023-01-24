package com.example.unitconverterapplication.a3rabota.Manvelyan303;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CheckBox[] checkBoxesProduct = new CheckBox[4];
    EditText[] editTextsAmount = new EditText[4];

    int[] productsAmount = new int[4];
    double[] productsPrice = {12, 231, 343, 42};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkBoxesProduct[0] = findViewById(R.id.checkBoxProduct1);
        checkBoxesProduct[1] = findViewById(R.id.checkBoxProduct2);
        checkBoxesProduct[2] = findViewById(R.id.checkBoxProduct3);
        checkBoxesProduct[3] = findViewById(R.id.checkBoxProduct4);

        editTextsAmount[0] = findViewById(R.id.editTextAmountProduct1);
        editTextsAmount[1] = findViewById(R.id.editTextAmountProduct2);
        editTextsAmount[2] = findViewById(R.id.editTextAmountProduct3);
        editTextsAmount[3] = findViewById(R.id.editTextAmountProduct4);

    }


    // Рассчитать
    public void button(View v) {

        double sum = 0;
        GetProductsPrice();

        for (int i = 0; i < 4; i++) {
            if (checkBoxesProduct[i].isChecked()) {
                int amount = Integer.parseInt(editTextsAmount[i].getText().toString());
                double price = productsPrice[i];

                sum += (amount * price);

            }
        }

        String str2 = String.format("\nСумма: %.2f рублей\n", sum);

        Toast.makeText(this, str2, Toast.LENGTH_SHORT).show();
    }


    // Получить цену продуктов
    private void GetProductsPrice() {
        try {
            for (int i = 0; i < 4; i++) {
                productsAmount[i] = Integer.parseInt(editTextsAmount[i].getText().toString());
            }
        } catch (Exception e) {
        }
    }
}