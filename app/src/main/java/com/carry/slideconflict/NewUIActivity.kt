package com.carry.slideconflict

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.carry.slideconflict.databinding.ActivityNewUiactivityBinding
import com.carry.slideconflict.items.NewUIItem
import com.carry.slideconflict.utils.BindActivity
import com.fueled.reclaim.ItemsViewAdapter

class NewUIActivity : AppCompatActivity() {
    private val binding: ActivityNewUiactivityBinding by BindActivity(R.layout.activity_new_uiactivity)
    private val mAdapter = ItemsViewAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        // init rv
        binding.rvList.run {
            adapter = mAdapter
            layoutManager = LinearLayoutManager(this@NewUIActivity,RecyclerView.HORIZONTAL,false)
            addItemDecoration(
                DividerItemDecoration(
                    this@NewUIActivity,
                    DividerItemDecoration.HORIZONTAL
                ).apply {
                    setDrawable(
                        AppCompatResources.getDrawable(
                            this@NewUIActivity,
                            R.drawable.item_divider_horizontal
                        )!!
                    )
                }
            )
        }

        val imgList = arrayListOf(
            R.drawable.img_1,
            R.drawable.img_2,
            R.drawable.img_3,
            R.drawable.img_4,
            R.drawable.img_5,
        )
        // 一个item 显示的宽度，这里取手机屏幕的80%
        val  deviceWidth = resources.displayMetrics.widthPixels * 0.8
        mAdapter.replaceItems(
            imgList.map {
                NewUIItem(it,deviceWidth.toInt())
            }
        )

    }
}