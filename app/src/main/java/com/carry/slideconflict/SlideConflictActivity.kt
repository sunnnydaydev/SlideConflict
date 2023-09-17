package com.carry.slideconflict

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.carry.slideconflict.bean.LyricData
import com.carry.slideconflict.databinding.ActivitySlideConflictBinding
import com.carry.slideconflict.items.OuterItem
import com.carry.slideconflict.utils.BindActivity
import com.carry.slideconflict.utils.KtsClient
import com.fueled.reclaim.ItemsViewAdapter

class SlideConflictActivity : AppCompatActivity() {
    companion object {
        val json = "{\n" +
                "  \"lyricList\": [\n" +
                "    {\n" +
                "      \"lyricTitle\": \"烟花易冷Live片段\",\n" +
                "      \"lyrics\": [\n" +
                "        \"城郊牧笛声 落在那座野村\",\n" +
                "        \"缘分落地生根是 我们\",\n" +
                "        \"缘分落地生根是 我们\",\n" +
                "        \"珈蓝寺听雨声盼 永恒\",\n" +
                "        \"<烟花易冷end>\",\n" +
                "        \"<烟花易冷end>\",\n" +
                "        \"<烟花易冷end>\",\n" +
                "        \"<烟花易冷end>\",\n" +
                "        \"<烟花易冷end>\"\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"lyricTitle\": \"烟花易冷0.8版\",\n" +
                "      \"lyrics\": [\n" +
                "        \"城郊牧笛声 落在那座野村\",\n" +
                "        \"缘分落地生根是 我们\",\n" +
                "        \"缘分落地生根是 我们\",\n" +
                "        \"珈蓝寺听雨声盼 永恒\",\n" +
                "        \"<烟花易冷end>\",\n" +
                "        \"<烟花易冷end>\",\n" +
                "        \"<烟花易冷end>\",\n" +
                "        \"<烟花易冷end>\",\n" +
                "        \"<烟花易冷end>\"\n" +
                "      ]\n" +
                "    },    {\n" +
                "      \"lyricTitle\": \"烟花易冷原版女生\",\n" +
                "      \"lyrics\": [\n" +
                "        \"城郊牧笛声 落在那座野村\",\n" +
                "        \"缘分落地生根是 我们\",\n" +
                "        \"缘分落地生根是 我们\",\n" +
                "        \"珈蓝寺听雨声盼 永恒\",\n" +
                "        \"<烟花易冷end>\",\n" +
                "        \"<烟花易冷end>\",\n" +
                "        \"<烟花易冷end>\",\n" +
                "        \"<烟花易冷end>\",\n" +
                "        \"<烟花易冷end>\"\n" +
                "      ]\n" +
                "    }\n" +
                "  ]\n" +
                "}"
        val data = KtsClient.serialization.decodeFromString<LyricData>(json)
    }

    private val binding: ActivitySlideConflictBinding by BindActivity(R.layout.activity_slide_conflict)
    private val mAdapter = ItemsViewAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.rvList.run {
            adapter = mAdapter
            layoutManager = LinearLayoutManager(binding.root.context)
            addItemDecoration(
                DividerItemDecoration(
                    binding.root.context,
                    DividerItemDecoration.VERTICAL
                ).apply {
                    // 不使用自定的drawable时默认分割线是一条灰色的线
                    setDrawable(
                        AppCompatResources.getDrawable(
                            binding.root.context,
                            R.drawable.item_divider_blue
                        )!!
                    )
                }
            )
        }

        mAdapter.replaceItems(
            data.lyricList.map {
                OuterItem(it)
            }
        )

    }
}