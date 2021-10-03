package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*


class activity_planning2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_planning2)

        //---------------------------Back button---------------------------------
        val cancel=findViewById<ImageView>(R.id.cancelplan)
        cancel.setOnClickListener(){
            val intent = Intent(applicationContext, Planning::class.java)
            startActivity(intent)
        }

        //-------------------Dropdown list----------------------------------------
        val spinner1=findViewById<Spinner>(R.id.dropdownlist1)
        val spinner2=findViewById<Spinner>(R.id.dropdownlist2)
        spinner2.visibility=View.INVISIBLE
        val spinner3=findViewById<Spinner>(R.id.dropdownlist3)
        spinner3.visibility=View.INVISIBLE
        val plus1=findViewById<ImageView>(R.id.add_destination1)
        val plus2=findViewById<ImageView>(R.id.add_destination2)
        plus2.visibility=View.INVISIBLE
        val plus3=findViewById<ImageView>(R.id.add_destination3)
        plus3.visibility=View.INVISIBLE

        val items= arrayOf("Afghanistan","Albania","Algeria","Andorra","Angola","Antigua and Barbuda","Argentina","Armenia","Australia","Austria","Azerbaijan","The Bahamas","Bahrain","Bangladesh","Barbados","Belarus","Belgium","Belize","Benin","Bhutan","Bolivia","Bosnia and Herzegovina","Botswana","Brazil","Brunei","Bulgaria","Burkina Faso","Burundi","Cambodia","Cameroon","Canada","Cape Verde","Central African Republic","Chad","Chile","China","Colombia","Comoros","Congo, Republic of the","Congo, Democratic Republic of the","Costa Rica","Cote d'Ivoire","Croatia","Cuba","Cyprus","Czech Republic","Denmark","Djibouti","Dominica","Dominican Republic","East Timor (Timor-Leste)","Ecuador","Egypt","El Salvador","Equatorial Guinea","Eritrea","Estonia","Ethiopia","Fiji","Finland","France","Gabon","The Gambia","Georgia","Germany","Ghana","Greece","Grenada","Guatemala","Guinea","Guinea-Bissau","Guyana","Haiti","Honduras","Hungary","Iceland","India","Indonesia","Iran","Iraq","Ireland","Israel","Italy","Jamaica","Japan","Jordan","Kazakhstan","Kenya","Kiribati","Korea, North","Korea, South","Kosovo","Kuwait","Kyrgyzstan","Laos","Latvia","Lebanon","Lesotho","Liberia","Libya","Liechtenstein","Lithuania","Luxembourg","Macedonia","Madagascar","Malawi","Malaysia","Maldives","Mali","Malta","Marshall Islands","Mauritania","Mauritius","Mexico","Micronesia, Federated States of","Moldova","Monaco","Mongolia","Montenegro","Morocco","Mozambique","Myanmar (Burma)","Namibia","Nauru","Nepal","Netherlands","New Zealand","Nicaragua","Niger","Nigeria","Norway","Pakistan","Palau","Panama","Papua New Guinea","Paraguay","Peru","Philippines","Poland","Portugal","Qatar","Romania","Russia","Rwanda","Saint Kitts and Nevis","Saint Lucia","Saint Vincent and the Grenadines","Samoa","San Marino","Sao Tome and Principe","Saudi Arabia","Senegal","Serbia","Seychelles","Singapore","Slovakia","Slovenia","Solomon Islands","Somalia","South Africa","South Sudan","Spain","Sri Lanka","Sudan","Suriname","Swaziland","Sweden","Switzerland","Syria","Taiwan","Tajikistan","Tanzania","Thailand","Togo","Tonga","Trinidad and Tobago","Tunisia","Turkey","Turkmenistan","Tuvalu","Uganda","Ukraine","United Arab Emirates","United Kingdom","United States of America","Uruguay","Uzbekistan","Vanuatu","Vatican City","Venezuela","Vietnam","Yemen","Zambia","Zimbabwe")
        val adapter: ArrayAdapter<String?> = ArrayAdapter<String?>(this, android.R.layout.simple_spinner_dropdown_item, items)
        spinner1.setAdapter(adapter)
        spinner2.setAdapter(adapter)
        spinner3.setAdapter(adapter)

        //adding more destinations

        plus1.setOnClickListener(){
            plus1.visibility= View.GONE
            spinner2.visibility=View.VISIBLE
            plus2.visibility=View.VISIBLE
        }

        plus2.setOnClickListener(){
            spinner3.visibility=View.VISIBLE
            plus2.visibility=View.GONE
           // plus3.visibility=View.VISIBLE

        }

    }
}
