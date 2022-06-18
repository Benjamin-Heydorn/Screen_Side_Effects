package com.example.screensideeffects

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class ScreenSlidePageFragment : Fragment() {

    var textView : TextView? = null
    var index : Int = 0;

    private fun button_fun() {
        val text = fragList[(index + 1) % NUM_PAGES]?.textView?.text.toString() + "Click"
        fragList[(index + 1) % NUM_PAGES]?.textView?.text = text
        textList[(index + 1) % NUM_PAGES] = text
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        super.onCreateView(inflater, container, savedInstanceState)
        println("Create view")
        val view = inflater.inflate(R.layout.fragment_screen_slide_page, container, false)
        val button = view.findViewById<Button>(R.id.button)
        textView = view.findViewById<TextView>(R.id.textView)
        textView?.text = textList[index]
        button.setOnClickListener { button_fun() }
        return view
    }
}