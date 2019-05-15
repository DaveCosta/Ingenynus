package org.mephys.ingenyus

import android.app.Activity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import java.net.URL
import java.util.concurrent.Executors


class IngenyusActivity() : Activity() {
    protected override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var result :String? = null

       Executors.newSingleThreadExecutor().execute {
           result = URL("https://httpbin.org/get").readText()
        }

        Thread(Runnable {
            // (1)
            //This is in the onCreate method
            val lView = LinearLayout(this)

            val myText = TextView(this)
            myText.setText(result)

            lView.addView(myText)

            setContentView(lView)
        }).start()                       // (3)
    }

}

