package com.example.awesome_calc.ui.main

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import com.example.awesome_calc.R
import kotlin.properties.Delegates

class ResultFragment(val viewModel: MainViewModel) : Fragment() {
    private var result by Delegates.notNull<Double>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_result, container, false)
        result = viewModel.getOperationResult()

        view.findViewById<TextView>(R.id.resultTextView).text = result.toString()
        view.findViewById<Button>(R.id.shareButton).setOnClickListener { shareResult() }
        view.findViewById<Button>(R.id.continueButton).setOnClickListener { doContinue() }

        viewModel.clear()
        return view
    }

    fun shareResult() {
        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, result.toString())
            type = "text/plain"
        }

        val shareIntent = Intent.createChooser(sendIntent, getString(R.string.share_title))
        startActivity(shareIntent)
    }

    fun doContinue() {
        var fm = (activity as FragmentActivity).supportFragmentManager;
        fm.popBackStackImmediate()
    }
}