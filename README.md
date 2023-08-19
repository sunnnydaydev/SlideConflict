# RecyclerView 练习

# reclaim

###### 1、依赖引入

```groovy
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        //指定maven仓库
        maven { url "https://jitpack.io" }
    }
}
```

```groovy
dependencies {
    implementation 'com.github.fueled:reclaim:2.1.1'
}
```

###### 2、初始化

```kotlin
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
                    setDrawable(AppCompatResources.getDrawable(this@ReclaimDemoActivity,R.drawable.item_divider_vertical)!!)
                }
            )
        }
    }
}
```

###### 3、创建Item

```kotlin
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
```

###### 4、添加item

```kotlin
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
```

其实1个Item就是1种布局类型，若我们想要添加头布局或如电商首页那样多样的类型布局只需要添加不同的item即可。

感觉用着还不错这里记录下~

# rv嵌套滑动冲突

一种解决方案