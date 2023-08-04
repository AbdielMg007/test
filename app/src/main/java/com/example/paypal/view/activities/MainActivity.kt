package com.example.paypal.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import com.example.paypal.R
import com.example.paypal.view.fragments.ScreenFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setup()
    }

    private fun setup() {
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            add(R.id.fragment, ScreenFragment())
        }
    }
}