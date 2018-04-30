package com.suwonsmartapp.quickdictionary

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val query = intent?.getStringExtra("query")

        web_view.settings.javaScriptEnabled = true
        web_view.webViewClient = WebViewClient()

        web_view.loadUrl("https://translate.google.com/?hl=ko#auto/ko/$query")

        val listener = View.OnClickListener {
            when (it.id) {
                R.id.google_button -> web_view.loadUrl("https://translate.google.com/?hl=ko#auto/ko/$query")
                R.id.naver_button -> web_view.loadUrl("http://dic.naver.com/search.nhn?dicQuery=$query}&x=0&y=0&query=word&target=dic&ie=utf8&query_utf=&isOnlyViewEE=")
                R.id.daum_button -> web_view.loadUrl("http://alldic.daum.net/search.do?q=$query")
            }
        }

        google_button.setOnClickListener(listener)
        naver_button.setOnClickListener(listener)
        daum_button.setOnClickListener(listener)
    }

}
