package com.carry.slideconflict.items

import android.view.View
import com.carry.slideconflict.R
import com.carry.slideconflict.databinding.ItemOuterBinding
import com.carry.slideconflict.utils.BindListItem
import com.fueled.reclaim.AdapterItem
import com.fueled.reclaim.BaseViewHolder

/**
 * Create by SunnyDay /08/19 21:18:52
 */

data class OuterItem(val imgSrc: Int) : AdapterItem<OuterViewHolder>() {
    override val layoutId: Int = R.layout.item_outer
    override fun onCreateViewHolder(view: View) = OuterViewHolder(view)
    override fun updateItemViews(viewHolder: OuterViewHolder) {
        viewHolder.binding.run {

        }
    }
}


data class OuterViewHolder(val view: View) : BaseViewHolder(view) {
    val binding: ItemOuterBinding by BindListItem(view)
}
