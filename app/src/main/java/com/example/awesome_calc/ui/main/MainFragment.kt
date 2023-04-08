package com.example.awesome_calc.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import com.example.awesome_calc.R

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        var view = inflater.inflate(R.layout.fragment_main, container, false)
        bindInputData(view)
        bindButtons(view)
        return view
    }

    fun bindInputData(view: View) {
        // TODO Mejorar qué sucede si los números son demasiado grandes
        var inputTextView: TextView = view.findViewById(R.id.inputTextView);
        viewModel.inputText.observe(viewLifecycleOwner, Observer { inputTextView.text = it ?: "0" })

        var operationTextView: TextView = view.findViewById(R.id.operationTextView);
        viewModel.operationText.observe(viewLifecycleOwner, Observer { operationTextView.text = it ?: "" })
    }

    fun bindButtons(view: View) {
        // Números
        view.findViewById<Button>(R.id.button0).setOnClickListener { viewModel.addZero() }
        view.findViewById<Button>(R.id.button00).setOnClickListener { viewModel.addZero(true) }
        view.findViewById<Button>(R.id.button1).setOnClickListener { viewModel.addInput(1) }
        view.findViewById<Button>(R.id.button2).setOnClickListener { viewModel.addInput(2) }
        view.findViewById<Button>(R.id.button3).setOnClickListener { viewModel.addInput(3) }
        view.findViewById<Button>(R.id.button4).setOnClickListener { viewModel.addInput(4) }
        view.findViewById<Button>(R.id.button5).setOnClickListener { viewModel.addInput(5) }
        view.findViewById<Button>(R.id.button6).setOnClickListener { viewModel.addInput(6) }
        view.findViewById<Button>(R.id.button7).setOnClickListener { viewModel.addInput(7) }
        view.findViewById<Button>(R.id.button8).setOnClickListener { viewModel.addInput(8) }
        view.findViewById<Button>(R.id.button9).setOnClickListener { viewModel.addInput(9) }
        view.findViewById<Button>(R.id.decimalButton).setOnClickListener { viewModel.addDecimalSymbol() }
    }
}