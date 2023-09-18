package com.carry.slideconflict.items

import android.view.MotionEvent
import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.carry.slideconflict.R
import com.carry.slideconflict.bean.Lyric
import com.carry.slideconflict.databinding.ItemOuterBinding
import com.carry.slideconflict.utils.BindListItem
import com.fueled.reclaim.AdapterItem
import com.fueled.reclaim.BaseViewHolder
import com.fueled.reclaim.ItemsViewAdapter

/**
 * Create by SunnyDay /08/19 21:18:52
 */

data class OuterItem(val lyric: Lyric) : AdapterItem<OuterViewHolder>() {
    override val layoutId: Int = R.layout.item_outer
    override fun onCreateViewHolder(view: View) = OuterViewHolder(view)
    override fun updateItemViews(viewHolder: OuterViewHolder) {
        viewHolder.binding.run {
            data = lyric

            viewHolder.mAdapter.replaceItems(
                lyric.lyrics.map {
                    SimpleTextItem(it)
                }
            )
        }
    }
}


data class OuterViewHolder(val view: View) : BaseViewHolder(view) {
    val binding: ItemOuterBinding by BindListItem(view)
    val mAdapter = ItemsViewAdapter()

    init {
        binding.subList.run {
            adapter = mAdapter
            layoutManager = LinearLayoutManager(binding.root.context)
            addItemDecoration(
                DividerItemDecoration(
                    binding.root.context,
                    DividerItemDecoration.VERTICAL
                )
            )
            this.setOnTouchListener { v, event ->
                view.parent.requestDisallowInterceptTouchEvent(true)
                when(event.action) {
                    MotionEvent.ACTION_UP ->{
                        view.parent.requestDisallowInterceptTouchEvent(false)
                        false

                    }
                    else ->
                        false
                }
            }
        }
    }
}
