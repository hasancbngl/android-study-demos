package com.sumzed.background_stuff

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sumzed.background_stuff.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        MyIntentService.startActionFoo(this, "ex", "param2")
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}