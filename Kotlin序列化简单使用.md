# 一、依赖引入

build.gradle

```groovy
plugins {
    id 'com.android.application' version '7.2.0' apply false
    id 'com.android.library' version '7.2.0' apply false
    id 'org.jetbrains.kotlin.android' version '1.6.10' apply false
    // add this
    id 'org.jetbrains.kotlin.plugin.serialization' version '1.9.0' apply false
}
```

app/build.gradle

```groovy
plugins {
    id 'com.android.application'
    id 'org.jetbrains.kotlin.android'
    // add this
    id 'org.jetbrains.kotlin.plugin.serialization'
}

dependencies {
    // add this
    implementation 'org.jetbrains.kotlinx:kotlinx-serialization-json:1.5.1'
}
```
# 二、使用

###### 1、简单配置

```kotlin
/**
 * Create by SunnyDay /09/16 12:34:06
 */
object KtsClient {
    @OptIn(ExperimentalSerializationApi::class)
    val serialization = Json {
        prettyPrint = true
        encodeDefaults = true
        ignoreUnknownKeys = true
        isLenient = true
        allowStructuredMapKeys = true
        useAlternativeNames = false
        explicitNulls = false
    }
}
```

###### 2、mock a json

```json
  {
  "lyricList": [
    {
      "lyricTitle": "烟花易冷片段",
      "lyrics": [
        "城郊牧笛声 落在那座野村",
        "缘分落地生根是 我们",
        "缘分落地生根是 我们",
        "珈蓝寺听雨声盼 永恒"
      ]
    }
  ]
}
```

###### 3、add annotation for class

```kotlin
@Serializable
data class LyricData(
    val lyricList: List<Lyric>
)
@Serializable
data class Lyric(
    val lyricTitle: String,
    val lyrics: List<String>
)
```

###### 4、finally

```kotlin
val data = KtsClient.serialization.decodeFromString<LyricData>(json)
```