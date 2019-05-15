package org.mephys.ingenyus

import android.app.Activity
import android.os.Bundle

class IngenyusActivity() : Activity() {
    protected override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}

