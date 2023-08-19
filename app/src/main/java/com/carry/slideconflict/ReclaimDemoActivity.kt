package com.carry.slideconflict

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.carry.slideconflict.databinding.ActivityReclaimDemoBinding
import com.carry.slideconflict.items.CommonListItem
import com.carry.slideconflict.utils.BindActivity
import com.fueled.reclaim.ItemsViewAdapter
import timber.log.Timber

/**
 * Create by SunnyDay /08/16 21:30:56
 */
class ReclaimDemoActivity : AppCompatActivity() {
    private val binding: ActivityReclaimDemoBinding by BindActivity(R.layout.activity_reclaim_demo)
    private val mAdapter = ItemsViewAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        // init rv
        binding.rvList.run {
            adapter = mAdapter
            layoutManager = LinearLayoutManager(this@ReclaimDemoActivity)
            addItemDecoration(
                DividerItemDecoration(
                    this@ReclaimDemoActivity,
                    DividerItemDecoration.VERTICAL
                ).apply {
                    // 不使用自定的drawable时默认分割线是一条灰色的线
                    setDrawable(
                        AppCompatResources.getDrawable(
                            this@ReclaimDemoActivity,
                            R.drawable.item_divider_vertical
                        )!!
                    )
                }
            )
        }

        // adapter 添加item
        val nameList = arrayListOf("张三", "李四", "王二")
        mAdapter.replaceItems(nameList.map {
            CommonListItem(it, ::onItemClicked)
        }, true)
    }

    private fun onItemClicked(name: String) {
        Timber.d("onItemClicked:$name")
    }
}