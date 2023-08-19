package com.carry.slideconflict.items

import android.view.View
import com.carry.slideconflict.R
import com.carry.slideconflict.databinding.ItemNewUiBinding
import com.carry.slideconflict.utils.BindListItem
import com.fueled.reclaim.AdapterItem
import com.fueled.reclaim.BaseViewHolder


/**
 * Create by SunnyDay /08/19 15:23:01
 */
data class NewUIItem(
    val imageResId: Int,
    val deviceWidth: Int? = null
) : AdapterItem<NewUIViewHolder>() {
    override val layoutId: Int = R.layout.item_new_ui
    override fun onCreateViewHolder(view: View) = NewUIViewHolder(view)
    override fun updateItemViews(viewHolder: NewUIViewHolder) {
        viewHolder.binding.run {
            // 控制布局宽度
            root.layoutParams.run {
                deviceWidth?.let {
                    width = it
                }
            }
            img.setImageResource(imageResId)
        }
    }
}

data class NewUIViewHolder(val view: View) : BaseViewHolder(view) {
    val binding: ItemNewUiBinding by BindListItem(view)
}