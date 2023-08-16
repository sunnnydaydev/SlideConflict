package com.carry.slideconflict

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.carry.slideconflict.databinding.ActivityMainBinding
import com.carry.slideconflict.utils.BindActivity

class MainActivity : AppCompatActivity(), MainUIListener {
    private val binding: ActivityMainBinding by BindActivity(R.layout.activity_main)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.run {
            listener = this@MainActivity
        }
    }

    override fun openReclaim(view: View) {
       startActivity(Intent(this,ReclaimDemoActivity::class.java))
    }
}

interface MainUIListener {
    fun openReclaim(view: View)
}