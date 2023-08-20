package com.carry.slideconflict

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.carry.slideconflict.databinding.ActivitySlideConflictBinding
import com.carry.slideconflict.items.OuterItem
import com.carry.slideconflict.items.SimpleTextItem
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
                )
            )
        }

        val list = arrayListOf(
            "城郊牧笛声 落在那座野村",
            "缘分落地生根是 我们",
            "缘分落地生根是 我们",
            "珈蓝寺听雨声盼 永恒",
        )
        mAdapter.replaceItems(
            list.map {
                SimpleTextItem(it)
            }
        )

        val imgList = arrayListOf(
            R.drawable.img_1,
            R.drawable.img_2,
            R.drawable.img_3,
        )
        mAdapter.addItemsList(
            imgList.map {
                OuterItem(it)
            }
        )

    }
}