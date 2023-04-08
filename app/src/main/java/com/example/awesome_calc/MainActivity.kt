package com.example.awesome_calc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.awesome_calc.ui.main.MainFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        // TODO Corregir el título de la aplicación en pantalla
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow()
        }
    }
}