package com.example.afuaa.newdayname

import android.app.DatePickerDialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast
import java.util.*

class MainActivity : AppCompatActivity() {
    val c = Calendar.getInstance()
    val year = c.get(Calendar.YEAR)
    val month = c.get(Calendar.MONTH)
    val day = c.get(Calendar.DAY_OF_MONTH)

    val days = arrayOf("Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday")
    val femaleNames  = arrayOf("Akosua","Adwoa","Abena","Akua","Yaa","Afua","Ama")
    val maleNames = arrayOf("Kwesi","Kwadwo","Kwabena","Kweku","Yaw","Kofi","Kwame")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dpd = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
            //Use the DatePicker Dialog's onDateSetListener to get the value of the date that the user changes to
            c.set(Calendar.YEAR,year)
            c.set(Calendar.MONTH,monthOfYear)
            c.set(Calendar.DAY_OF_MONTH,dayOfMonth)
            val weekday = c.get(Calendar.DAY_OF_WEEK)
            
            showDay.setText("This day is a "+days[weekday-1])
            femaleName.setText("Female name:"+femaleNames[weekday-1])
            maleName.setText("Male name:"+maleNames[weekday-1])
        }, year, month, day)


        lblDate.setOnClickListener {
           //Display the datepicker. See above
            dpd.show()
        }




    }


}

