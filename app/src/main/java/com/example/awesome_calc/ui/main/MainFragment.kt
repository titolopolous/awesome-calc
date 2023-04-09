package com.example.awesome_calc.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import com.example.awesome_calc.R
import com.example.awesome_calc.model.op.*

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    private lateinit var resultFragment: ResultFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        resultFragment = ResultFragment(viewModel)
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
        // Explicar que el espacio en blanco de arriba es con intención
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

        // Borradores
        view.findViewById<Button>(R.id.eraseLeftButton).setOnClickListener { viewModel.eraseLeft() }
        view.findViewById<Button>(R.id.clearButton).setOnClickListener { viewModel.clear() }

        // Operaciones
        view.findViewById<Button>(R.id.perButton).setOnClickListener { viewModel.setCurrentOperation { firstValue -> PerOperation(firstValue) } }
        view.findViewById<Button>(R.id.divButton).setOnClickListener { viewModel.setCurrentOperation { firstValue -> DivOperation(firstValue) } }
        view.findViewById<Button>(R.id.mulButton).setOnClickListener { viewModel.setCurrentOperation { firstValue -> MulOperation(firstValue) } }
        view.findViewById<Button>(R.id.subButton).setOnClickListener { viewModel.setCurrentOperation { firstValue -> SubOperation(firstValue) } }
        view.findViewById<Button>(R.id.sumButton).setOnClickListener { viewModel.setCurrentOperation { firstValue -> SumOperation(firstValue) } }

        // Resultado
        view.findViewById<Button>(R.id.resultButton).setOnClickListener { submit() }
    }

    fun submit() {
        viewModel.submitSecondCurrentOperationValue();
        var fm = (activity as FragmentActivity).supportFragmentManager;
        var ft = fm.beginTransaction()
        ft.replace(R.id.main, resultFragment)
        ft.addToBackStack(null)
        ft.commit()
    }
}