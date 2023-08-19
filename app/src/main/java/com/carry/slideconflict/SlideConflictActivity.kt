package com.carry.slideconflict

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.carry.slideconflict.databinding.ActivitySlideConflictBinding
import com.carry.slideconflict.utils.BindActivity
import com.fueled.reclaim.ItemsViewAdapter

class SlideConflictActivity : AppCompatActivity() {
    private val binding: ActivitySlideConflictBinding by BindActivity(R.layout.activity_slide_conflict)
    private val mAdapter = ItemsViewAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.rvList.run {
            adapter = mAdapter
            layoutManager = LinearLayoutManager(this@SlideConflictActivity)
            addItemDecoration(
                DividerItemDecoration(
                    this@SlideConflictActivity,
                    DividerItemDecoration.VERTICAL
                ).apply {
                    setDrawable(AppCompatResources.getDrawable(this@SlideConflictActivity,R.drawable.item_divider_vertical)!!)
                }
            )
        }

    }
}