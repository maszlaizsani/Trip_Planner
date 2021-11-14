package com.example.myapplication

import android.content.ContentValues
import android.content.Intent
import android.icu.text.SimpleDateFormat
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.google.android.material.datepicker.MaterialDatePicker
import kotlinx.android.synthetic.main.activity_planning.*
import myDBhelper
import java.util.*

var startDate: Long = 0
var endDate: Long = 0

class PlanningActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_planning)


        //------------------------------Variables for date picking-----------------------------

        val selectDate=findViewById<ImageView>(R.id.selectDate)

        selectDate.setOnClickListener {
            buildDatePicker()
        }

        //------------------------------Back and next button-----------------------------------
        val cancel=findViewById<ImageView>(R.id.cancelPlan)
        cancel.setOnClickListener {
            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        }

        val next=findViewById<Button>(R.id.next_plan)

        //-------------------------------Dropdown lists----------------------------------------
        val getName=findViewById<EditText>(R.id.getName)
        val spinner1=findViewById<Spinner>(R.id.dropdownlist1)
        val spinner2=findViewById<Spinner>(R.id.dropdownlist2)

        spinner2.visibility=View.INVISIBLE
        val spinner3=findViewById<Spinner>(R.id.dropdownlist3)
        spinner3.visibility=View.INVISIBLE
        val plus1=findViewById<ImageView>(R.id.add_destination1)
        val plus2=findViewById<ImageView>(R.id.add_destination2)
        plus2.visibility=View.INVISIBLE

        val items= arrayOf("Afghanistan","Albania","Algeria","Andorra","Angola","Antigua and Barbuda","Argentina","Armenia","Australia","Austria","Azerbaijan","The Bahamas","Bahrain","Bangladesh","Barbados","Belarus","Belgium","Belize","Benin","Bhutan","Bolivia","Bosnia and Herzegovina","Botswana","Brazil","Brunei","Bulgaria","Burkina Faso","Burundi","Cambodia","Cameroon","Canada","Cape Verde","Central African Republic","Chad","Chile","China","Colombia","Comoros","Congo","Costa Rica","Cote d'Ivoire","Croatia","Cuba","Cyprus","Czech Republic","Denmark","Djibouti","Dominica","Dominican Republic","East Timor (Timor-Leste)","Ecuador","Egypt","El Salvador","Equatorial Guinea","Eritrea","Estonia","Ethiopia","Fiji","Finland","France","Gabon","The Gambia","Georgia","Germany","Ghana","Greece","Grenada","Guatemala","Guinea","Guinea-Bissau","Guyana","Haiti","Honduras","Hungary","Iceland","India","Indonesia","Iran","Iraq","Ireland","Israel","Italy","Jamaica","Japan","Jordan","Kazakhstan","Kenya","Kiribati","Korea, North","Korea, South","Kosovo","Kuwait","Kyrgyzstan","Laos","Latvia","Lebanon","Lesotho","Liberia","Libya","Liechtenstein","Lithuania","Luxembourg","Macedonia","Madagascar","Malawi","Malaysia","Maldives","Mali","Malta","Marshall Islands","Mauritania","Mauritius","Mexico","Micronesia","Moldova","Monaco","Mongolia","Montenegro","Morocco","Mozambique","Myanmar (Burma)","Namibia","Nauru","Nepal","Netherlands","New Zealand","Nicaragua","Niger","Nigeria","Norway","Pakistan","Palau","Panama","Papua New Guinea","Paraguay","Peru","Philippines","Poland","Portugal","Qatar","Romania","Russia","Rwanda","Saint Kitts and Nevis","Saint Lucia","Saint Vincent and the Grenadines","Samoa","San Marino","Sao Tome and Principe","Saudi Arabia","Senegal","Serbia","Seychelles","Singapore","Slovakia","Slovenia","Solomon Islands","Somalia","South Africa","South Sudan","Spain","Sri Lanka","Sudan","Suriname","Swaziland","Sweden","Switzerland","Syria","Taiwan","Tajikistan","Tanzania","Thailand","Togo","Tonga","Trinidad and Tobago","Tunisia","Turkey","Turkmenistan","Tuvalu","Uganda","Ukraine","United Arab Emirates","United Kingdom","United States of America","Uruguay","Uzbekistan","Vanuatu","Vatican City","Venezuela","Vietnam","Yemen","Zambia","Zimbabwe")
        val adapter: ArrayAdapter<String?> = ArrayAdapter<String?>(this, android.R.layout.simple_spinner_dropdown_item, items)
        spinner1.adapter = adapter
        spinner2.adapter = adapter
        spinner3.adapter = adapter

        //----------------------------adding more destination lists-----------------------------
        plus1.setOnClickListener {
            plus1.visibility= View.GONE
            spinner2.visibility=View.VISIBLE
            plus2.visibility=View.VISIBLE
        }

        plus2.setOnClickListener {
            plus2.visibility=View.GONE
            spinner3.visibility=View.VISIBLE
        }

        //---------------------------saving all attributes in DB--------------------------------
        val helper= myDBhelper(applicationContext)
        val db=helper.readableDatabase
        val cv= ContentValues()

        next.setOnClickListener {
            if (getName.length()<3) {
                Toast.makeText(this, "Trip name is too short!", Toast.LENGTH_SHORT).show()
                getName.requestFocus()
            }
            else {
                cv.put("tripNAME", getName.text.toString())
                cv.put("destination", spinner1.selectedItem.toString())
                cv.put("tripStartDate", startDate)
                cv.put("tripEndDate", endDate)
                db.insert("TRIPS", null, cv)
                Toast.makeText(this,"Saved plan",Toast.LENGTH_SHORT).show()
                val intent = Intent(applicationContext, MainActivity::class.java)
                startActivity(intent)
            }
        }
    }

    //---------------------------------Date picker and converter--------------------------------
    private fun buildDatePicker(){
        val dateRangePicker=MaterialDatePicker.Builder
            .dateRangePicker()
            .setTitleText("Select date")
            .build()

        dateRangePicker.show(supportFragmentManager, "date_range_picker")

        dateRangePicker.addOnPositiveButtonClickListener { date ->
            startDate=date.first
            endDate=date.second
            selectedDate.text = convertLongToTime(startDate) + " - " + convertLongToTime(endDate)
        }
    }

   private fun convertLongToTime(time: Long): String {
       val date = Date(time)
       val format = SimpleDateFormat("dd.MM.yyyy")
       return format.format(date)
    }
}