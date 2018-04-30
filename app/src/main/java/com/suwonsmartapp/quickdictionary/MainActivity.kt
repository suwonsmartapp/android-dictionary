package com.suwonsmartapp.quickdictionary

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.inputmethod.EditorInfo
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        word_edit.setOnEditorActionListener { v, actionId, _ ->
            when (actionId) {
                EditorInfo.IME_ACTION_SEARCH -> {
                    val intent = Intent(this, ResultActivity::class.java)
                    intent.putExtra("query", v.text.toString())
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }
    }
}
