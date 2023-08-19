package com.carry.slideconflict.items

import android.view.View
import com.carry.slideconflict.R
import com.carry.slideconflict.databinding.ItemCommonListBinding
import com.carry.slideconflict.utils.BindListItem
import com.fueled.reclaim.AdapterItem
import com.fueled.reclaim.BaseViewHolder
import timber.log.Timber

/**
 * Create by SunnyDay /08/19 11:05:29
 */
data class CommonListItem(
    val name: String,
    val onItemClicked: (String) -> Unit = {}
) :
    AdapterItem<CommonListViewHolder>(),CommonListItemUIListener {

    override val layoutId: Int = R.layout.item_common_list

    /**
     * 创建ViewHolder
     * */
    override fun onCreateViewHolder(view: View) = CommonListViewHolder(view)

    /**
     * onBindViewHolder中会调用这个方法
     * */
    override fun updateItemViews(viewHolder: CommonListViewHolder) {
        viewHolder.binding.run {
            itemName = name
            listener = this@CommonListItem
        }
    }

    /**
     * 这两个方法用于控制item是否刷新。使用这两个方法时要开启diff算法。
     *
     * 通常有多个Item类型时，ItemA的数据未发生改变时不需要刷新ItemA
     * */
    override fun isContentsTheSame(newItem: AdapterItem<*>): Boolean {
        return newItem is CommonListItem && newItem.name == name
    }

    override fun isTheSame(newItem: AdapterItem<*>): Boolean {
        return newItem is CommonListItem
    }

    override fun onItemClicked(view: View) {
        Timber.d("test1")
        onItemClicked.invoke(name)
    }

}

data class CommonListViewHolder(val view: View) : BaseViewHolder(view) {
    val binding: ItemCommonListBinding by BindListItem(view)
}

interface CommonListItemUIListener{
    fun onItemClicked(view:View)
}