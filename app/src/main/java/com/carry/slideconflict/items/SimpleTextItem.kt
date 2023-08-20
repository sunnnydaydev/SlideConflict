package com.carry.slideconflict.items

import android.view.View
import com.carry.slideconflict.R
import com.carry.slideconflict.databinding.ItemOuterBinding
import com.carry.slideconflict.databinding.ItemSimpleTextBinding
import com.carry.slideconflict.utils.BindListItem
import com.fueled.reclaim.AdapterItem
import com.fueled.reclaim.BaseViewHolder

/**
 * Create by SunnyDay /08/19 21:18:52
 */

data class SimpleTextItem(val textStr: String) : AdapterItem<SimpleTextViewHolder>() {
    override val layoutId: Int = R.layout.item_simple_text
    override fun onCreateViewHolder(view: View) = SimpleTextViewHolder(view)
    override fun updateItemViews(viewHolder: SimpleTextViewHolder) {
        viewHolder.binding.tvText.text = textStr
    }
}


data class SimpleTextViewHolder(val view: View) : BaseViewHolder(view) {
    val binding: ItemSimpleTextBinding by BindListItem(view)
}
