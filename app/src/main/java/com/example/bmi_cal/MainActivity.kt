package com.example.bmi_cal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCalculate.setOnClickListener(){
            try {
                val weight: Double = text_weight.text.toString().toDouble()
                val height: Double = text_height.text.toString().toDouble()

                val bmi: Double = weight / (height * height)
                val result: String

                if (bmi <= 18.5) {
                    result = "UNDER"
                    img_result.setImageResource(R.drawable.under)
                } else if (bmi <= 24.9) {
                    result = "NORMAL"
                    img_result.setImageResource(R.drawable.normal)
                } else {
                    result = "OVER"
                    img_result.setImageResource(R.drawable.over)
                }

                result_BMI.text = "BMI: %.2f (%s)".format(bmi, result)
            }catch (e:Exception){
                val toast:Toast = Toast.makeText(this,"Invalid input", Toast.LENGTH_LONG)

                toast.setGravity(Gravity.CENTER,0,0);
                toast.show()
            }
        }

        btnReset.setOnClickListener(){
            text_height.setText("")
            text_weight.setText("")
            result_BMI.setText("")
            img_result.setImageResource(R.drawable.empty)
        }
    }
}
