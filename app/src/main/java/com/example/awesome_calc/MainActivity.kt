package com.example.awesome_calc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.awesome_calc.ui.main.MainFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        // TODO Añadir documentación a clases y métodos
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow()
        }
    }
}