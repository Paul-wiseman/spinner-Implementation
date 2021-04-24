package com.sriyank.paul.spinnerimplementation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import com.sriyank.paul.viewpager2.CountryArrayAdapter
import com.sriyank.viewpager.Countries

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupSimpleSpinner()
        setupCustomSpinner()
    }
    fun setupCustomSpinner(){
        val adapter = CountryArrayAdapter(this, Countries.list!!)
        findViewById<Spinner>(R.id.customSpinner).adapter = adapter
    }

    fun setupSimpleSpinner(){
        val  adapter = ArrayAdapter.createFromResource(this, R.array.countries, android.R.layout.simple_spinner_item)

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        findViewById<Spinner>(R.id.simpleSpinner).adapter = adapter
        findViewById<Spinner>(R.id.simpleSpinner).onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedItem = parent!!.getItemAtPosition(position)
                Toast.makeText(this@MainActivity, "Selected", Toast.LENGTH_SHORT).show()
            }

        }
    }
}