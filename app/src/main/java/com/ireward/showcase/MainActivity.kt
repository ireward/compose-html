package com.ireward.showcase

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.text.Html
import android.text.method.LinkMovementMethod
import android.view.Gravity
import android.widget.TextView
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ScrollableTabRow
import androidx.compose.material.Tab
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import com.google.accompanist.pager.*
import com.ireward.htmlcompose.HtmlText
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    @ExperimentalPagerApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MainActivityContent()
        }
    }
}

@ExperimentalPagerApi
@Composable
@Preview
fun MainActivityContentPreview() {
    MainActivityContent()
}

@ExperimentalPagerApi
@Composable
fun MainActivityContent() {
    val htmlTags = HtmlTag.values().toList().sortedBy { it.name }
    val pagerState = rememberPagerState()

    Column(
        modifier = Modifier
            .background(colorResource(id = R.color.white))
            .fillMaxSize()
    ) {
        TabRowContent(htmlTags, pagerState)
        PagerContent(htmlTags, pagerState)
    }
}

@ExperimentalPagerApi
@Composable
private fun TabRowContent(
    htmlTags: List<HtmlTag>,
    pagerState: PagerState
) {
    val coroutineScope: CoroutineScope = rememberCoroutineScope()

    ScrollableTabRow(
        edgePadding = 0.dp,
        divider = {},
        contentColor = colorResource(id = R.color.blue),
        backgroundColor = colorResource(id = R.color.background),
        selectedTabIndex = pagerState.currentPage,
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                Modifier.pagerTabIndicatorOffset(pagerState, tabPositions)
            )
        }
    ) {
        htmlTags.forEachIndexed { index, htmlTag ->
            val selected = pagerState.currentPage == index
            Tab(
                text = {
                    Text(
                        text = htmlTag.tag,
                        style = TextStyle(
                            fontSize = 16.sp,
                            color = colorResource(
                                id = if (selected) {
                                    R.color.black
                                } else {
                                    R.color.blue
                                }
                            ),
                            fontWeight = FontWeight.Bold
                        )
                    )
                },
                selected = selected,
                onClick = {
                    coroutineScope.launch {
                        pagerState.scrollToPage(index)
                    }
                },
            )
        }
    }
}

@ExperimentalPagerApi
@Composable
private fun PagerContent(
    htmlTags: List<HtmlTag>,
    pagerState: PagerState
) {
    HorizontalPager(
        modifier = Modifier
            .fillMaxWidth()
            .background(colorResource(id = R.color.background)),
        count = htmlTags.count(),
        state = pagerState
    ) { page ->
        val htmlTag = htmlTags[page]

        Column(modifier = Modifier.fillMaxSize()) {
            HtmlTextItem(LocalContext.current, htmlTag.content)
            AndroidLegacyTextView(htmlTag.content)
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(colorResource(id = R.color.white))
            )
        }
    }
}

@Composable
private fun AndroidLegacyTextView(html: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
            .background(colorResource(id = R.color.white), shape = RoundedCornerShape(10))
    ) {
        AndroidView(
            modifier = Modifier
                .align(Alignment.Center)
                .padding(10.dp),
            factory = { ctx ->
                TextView(ctx).apply {
                    gravity = Gravity.CENTER
                    setLinkTextColor(ContextCompat.getColorStateList(context, R.color.blue))
                    text = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                        Html.fromHtml(html, Html.FROM_HTML_MODE_COMPACT)
                    } else {
                        Html.fromHtml(html)
                    }
                    movementMethod = LinkMovementMethod.getInstance()
                    setOnClickListener {
                        Toast.makeText(
                            context,
                            context.getText(R.string.textview_link_clicked_message),
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
            })
        Image(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(5.dp)
                .size(16.dp),
            painter = painterResource(id = R.drawable.ic_android_logo),
            contentDescription = null
        )
    }
}

@Composable
private fun HtmlTextItem(context: Context, html: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .padding(top = 20.dp)
            .background(colorResource(id = R.color.white), shape = RoundedCornerShape(10))
    ) {
        HtmlText(
            modifier = Modifier
                .align(Alignment.Center)
                .padding(10.dp),
            text = html,
            style = TextStyle(
                textAlign = TextAlign.Center,
                color = colorResource(id = R.color.text),
                fontWeight = FontWeight.Normal
            ),
            linkClicked = { link ->
                context.startActivity(
                    Intent(Intent.ACTION_VIEW).apply {
                        data = Uri.parse(link)
                    }
                )
            },
            onClicked = {
                Toast.makeText(
                    context,
                    context.getText(R.string.html_text_clicked_message),
                    Toast.LENGTH_LONG
                ).show()
            },
            URLSpanStyle = SpanStyle(
                color = colorResource(id = R.color.blue),
                textDecoration = TextDecoration.Underline
            )
        )
        Image(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(5.dp)
                .size(20.dp),
            painter = painterResource(id = R.drawable.ic_compose_logo),
            contentDescription = null
        )
    }
}