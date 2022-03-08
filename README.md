[![Android Arsenal]( https://img.shields.io/badge/Android%20Arsenal-compose--html-green.svg?style=flat )]( https://android-arsenal.com/details/1/8382 )

# HtmlCompose

An Android library which provides HTML support for Jetpack Compose texts.

## Setup

Add to top level *gradle.build* file
```gradle
allprojects {
    repositories {
        maven { url "https://jitpack.io" }
    }
}
```

Add to app module *gradle.build* file.

```gradle
dependencies {
    implementation 'com.github.ireward:compose-html:1.0.2'
}
```

## Usage

For the time being, the composable `Text` layout doesn't provide any HTML support. This library fills that gap by exposing
the composable `HtmlText` layout, which is built on top of the `Text` layout and the `Span/Spannable` Android classes.
Its API goes as follows:

```kotlin
HtmlText(
    text = htmlString,
    linkClicked = { link ->
        Log.d("linkClicked", link)
    }
)
```

And these are all the available parameters that allows you to change the default behaviour:
```kotlin
fun HtmlText(
    text: String,
    modifier: Modifier = Modifier,
    style: TextStyle = TextStyle.Default,
    softWrap: Boolean = true,
    overflow: TextOverflow = TextOverflow.Clip,
    maxLines: Int = Int.MAX_VALUE,
    onTextLayout: (TextLayoutResult) -> Unit = {},
    linkClicked: (String) -> Unit = {},
    fontSize: TextUnit = 14.sp,
    flags: Int = HtmlCompat.FROM_HTML_MODE_COMPACT,
    URLSpanStyle: SpanStyle = SpanStyle(
        color = linkTextColor(),
        textDecoration = TextDecoration.Underline
    )
)
```

`HtmlText` supports almost as many [HTML tags as `android.widget.TextView` does](https://stackoverflow.com/questions/44410675/supported-html-tags-on-android-textview
), with the exception of `<img>` tag and `<ul>`, being the latter partially supported, as `HtmlText`
renders properly the elements of the list but it does not add the bullet (•)

What follows are screenshots taken from the companion showcase app hosted in this same repo, where all
the HTML tags are rendered side by side to compare `HtmlText` with `android.widget.TextView`:

![Alt text](/imgs/1.png?raw=true "") ![Alt text](/imgs/2.png?raw=true "") ![Alt text](/imgs/3.png?raw=true "")
![Alt text](/imgs/4.png?raw=true "") ![Alt text](/imgs/5.png?raw=true "") ![Alt text](/imgs/6.png?raw=true "")
![Alt text](/imgs/7.png?raw=true "")
