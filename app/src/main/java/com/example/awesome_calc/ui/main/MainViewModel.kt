package com.example.awesome_calc.ui.main

import android.view.View
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

    fun addInput(input: String){
        _inputText.value = if (_inputText.value == null) input else "${_inputText.value}$input"
        println("Added! $input ${_inputText.value}")
    }
}