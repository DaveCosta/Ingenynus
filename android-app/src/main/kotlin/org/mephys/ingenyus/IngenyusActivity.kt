package org.mephys.ingenyus



import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import java.net.URL
import java.nio.charset.Charset


class IngenyusActivity() : Activity() {

    var result: String? = null

    lateinit var  text: String

    var background = object : Thread(){
        override fun run() {
            val urlConnection = URL("http://192.168.4.1")
            text = urlConnection.readText(Charset.defaultCharset())
        }
    }.start()

    protected override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = TextView(this)
        textView.setText("text")

        /*  Thread { */

        /*    }.start()*/

        val ll_main_layout = findViewById(R.id.main) as LinearLayout

        ll_main_layout.addView(textView)

    }

    override fun onReq

}

