package com.example.awesome_calc.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.awesome_calc.model.op.Operation

class MainViewModel : ViewModel() {
    private var _operationText = MutableLiveData<String?>()
    val operationText: LiveData<String?>
        get() = _operationText

    private var _inputText = MutableLiveData<String?>()
    val inputText: LiveData<String?>
        get() = _inputText

    private var _currentOperation: Operation? = null
    private var currentOperation: Operation?
        get() = _currentOperation
        private set(value) {
            _currentOperation = value
            updateOperationText()
        }

    fun updateOperationText() {
        _operationText.value = currentOperation?.getText()
    }

    fun inputIsZero(): Boolean {
        return _inputText.value == null || _inputText.value == "0";
    }

    fun addInput(input: Int){
        addInput(input.toString())
    }

    fun addDecimalSymbol() {
        // TODO distinguir entre regiones. Algunas usan comas
        var decimalSymbol : String = ".";
        if(_inputText.value == null || _inputText.value == "0") {
            _inputText.value = "0$decimalSymbol"
            return
        }

        if(_inputText.value != null && !(_inputText.value as String).contains(decimalSymbol)) {
            _inputText.value += decimalSymbol;
        }
    }

    fun addZero(doubleZero: Boolean = false) {
        if(inputIsZero()) {
            return;
        }

        addInput("0")
        if(doubleZero) {
            addInput("0")
        }
    }

    fun addInput(input: String){
        // TODO implementar resultados con mensajes para mostrar al usuario en caso de que las cosas no van bien
        _inputText.value = if (inputIsZero()) input else "${_inputText.value}$input"
        println("Added! $input ${_inputText.value}")
    }

    fun eraseLeft() {
        if(inputIsZero()) {
            return
        }

        if((_inputText.value as String).length == 1) {
            _inputText.value = null
            return
        }

        _inputText.value = (_inputText.value as String).dropLast(1)
    }

    fun clear() {
        _inputText.value = null
        currentOperation = null
    }

    fun currentOperationSet(): Boolean {
        return currentOperation != null
    }

    fun setCurrentOperation(factoryFun: (Double) -> Operation) {
        var firstValue = 0.0;
        if(_inputText.value != null) {
            firstValue = if(currentOperation == null) (_inputText.value as String).toDouble()
                else (currentOperation as Operation).firstValue
        }

        currentOperation = factoryFun(firstValue)
        _inputText.value = null
    }

    fun submitSecondCurrentOperationValue() {
        if (!currentOperationSet()) {
            throw UnsupportedOperationException("No current operation found")
        }

        var secondValue = if (_inputText.value == null) 0.0 else (_inputText.value as String).toDouble();
        (currentOperation as Operation).secondValue = secondValue
    }

    fun getOperationResult(): Double {
        if (!currentOperationSet()) {
            throw UnsupportedOperationException("No current operation found")
        }

        var currentOperation = currentOperation as Operation
        if (currentOperation.secondValue == null) {
            // Mirar la función submitSecondCurrentOperationValue()
            throw UnsupportedOperationException("Submit a second value before attempting a calculation")
        }

        return currentOperation.execute()
    }
}