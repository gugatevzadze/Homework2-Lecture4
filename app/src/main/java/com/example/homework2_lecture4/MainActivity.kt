package com.example.homework2_lecture4

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)
        val editText = findViewById<EditText>(R.id.editText3)
        val textView = findViewById<TextView>(R.id.textView2)

        //
        button.setOnClickListener{
            val input = editText.text.toString()//Charsequence-ს სტრინგად გადაქცევა
            val number = input.toIntOrNull()//ცარიელი ინპუტის შემთხვევაში null-დ გადააქცევს

            //Null-ს შესამოწმებლად, ცარიელი სტრინგის გაშვებისას აპლიკაცია იქრაშებოდა, ასე ნალი ელს ბლოკის კოდს უშვებს..აექზექიუთებს
            if (number != null && number in 0..1000){
                val result = numberConverter(number)
                textView.text = "$result"
            }else{
                textView.text = "მონაცემი ვერ დამუშავდა\n:(\nთავიდან სცადეთ"
            }
        }
    }
}