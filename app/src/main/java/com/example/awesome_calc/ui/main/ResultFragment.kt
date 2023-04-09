package com.example.awesome_calc.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.awesome_calc.R

class ResultFragment(val viewModel: MainViewModel) : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_result, container, false)
        var result = viewModel.getOperationResult()

        view.findViewById<TextView>(R.id.resultTextView).text = result.toString()

        viewModel.clear()
        return view
    }
}