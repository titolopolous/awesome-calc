package com.example.awesome_calc.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private var _operationText = MutableLiveData<String>()
    val operationText: LiveData<String>
        get() = _operationText

    private var _inputText = MutableLiveData<String>()
    val inputText: LiveData<String>
        get() = _inputText

    fun addInput(input: Int){
        addInput(input.toString())
    }

    fun addDecimalSymbol() {
        // TODO distinguir entre regiones. Algunas usan comas
        var decimalSymbol : String = ".";
        if(_inputText.value != null && !(_inputText.value as String).contains(decimalSymbol)) {
            _inputText.value += decimalSymbol;
        }
    }

    fun addZero(doubleZero: Boolean = false) {
        if(_inputText.value == null || _inputText.value == "0") {
            return;
        }

        addInput("0")
        if(doubleZero) {
            addInput("0")
        }
    }

    fun addInput(input: String){
        // TODO implementar resultados con mensajes para mostrar al usuario en caso de que las cosas no van bien
        _inputText.value = if (_inputText.value == null) input else "${_inputText.value}$input"
        println("Added! $input ${_inputText.value}")
    }
}