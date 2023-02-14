package com.example.spannabletext

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.*
import android.view.View
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var textMsg1:TextView
    lateinit var textMsg2:TextView
    lateinit var textMsg3:TextView
    lateinit var textMsg4:TextView
    lateinit var textMsg5:TextView
    lateinit var textMsg6:TextView
    lateinit var textMsg7:TextView
    lateinit var textMsg8:TextView
    lateinit var textMsg9:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textMsg1 = findViewById(R.id.tvMessage)
        textMsg2 = findViewById(R.id.tvMessage1)
        textMsg3 = findViewById(R.id.tvMessage2)
        textMsg4 = findViewById(R.id.tvMessage3)
        textMsg5 = findViewById(R.id.tvMessage4)
        textMsg6 = findViewById(R.id.tvMessage5)
        textMsg7 = findViewById(R.id.tvMessage6)
        textMsg8 = findViewById(R.id.tvMessage7)
        textMsg9 = findViewById(R.id.tvMessage8)



//Change different colors for different words in a TextView

        val spannable = SpannableString("Hello Android!")
        spannable.setSpan(
            ForegroundColorSpan(Color.RED),
            6,
            14,
            Spannable.SPAN_EXCLUSIVE_INCLUSIVE
        )
        textMsg1.text = spannable


//Spannable Flags

        val spannableStringBuilder = SpannableStringBuilder("Android")
        spannableStringBuilder.setSpan(
            ForegroundColorSpan(Color.GREEN),
            2,
            5,
            Spannable.SPAN_INCLUSIVE_INCLUSIVE
        )
        textMsg2.text = spannableStringBuilder


//Spannable Flags

        val spannableStringBuilder1 = SpannableStringBuilder("Android")
        spannableStringBuilder1.setSpan(
            ForegroundColorSpan(Color.BLUE),
            1,
            4,
            Spannable.SPAN_INCLUSIVE_INCLUSIVE
        )
        spannableStringBuilder1.insert(4, "1")
        spannableStringBuilder1.insert(1, "1")
        textMsg3.text = spannableStringBuilder1



//Multiple Spans to the same text

        val spannable1 = SpannableString("Hello Android Developer")
        spannable1.setSpan(
            StyleSpan(Typeface.ITALIC),
            0,
            5,
            Spannable.SPAN_EXCLUSIVE_INCLUSIVE
        )
        spannable1.setSpan(
            StyleSpan(Typeface.BOLD),
            6,
            13,
            Spannable.SPAN_EXCLUSIVE_INCLUSIVE
        )
        spannable1.setSpan(
            StrikethroughSpan(),
            14,
            23,
            Spannable.SPAN_EXCLUSIVE_INCLUSIVE
        )
        textMsg4.text = spannable1



//Change the background color of some part of a TextView

        val spannable2 = SpannableString("Hello Android!")
        spannable2.setSpan(
            BackgroundColorSpan(Color.RED),
            6,
            14,
            Spannable.SPAN_EXCLUSIVE_INCLUSIVE
        )
        textMsg5.text = spannable2



//Different font size of the string in the same TextView

        val spannable3 = SpannableString("Hello Android!")
        spannable3.setSpan(
            RelativeSizeSpan(2f),
            6,
            14,
            Spannable.SPAN_EXCLUSIVE_INCLUSIVE
        )
        textMsg6.text = spannable3



//Underline a part of the text in TextView

        val spannable4 = SpannableString("Hello Android!")
        spannable4.setSpan(
            UnderlineSpan(),
            6,
            14,
            Spannable.SPAN_EXCLUSIVE_INCLUSIVE
        )
        textMsg7.text = spannable4



//Set some part of the TextView Clickable

        val spanText = SpannableStringBuilder("Android")

        val clickable = object : ClickableSpan() {
            override fun onClick(view: View) {
                Toast.makeText(view.context, "Clicked!", Toast.LENGTH_SHORT).show()
            }
        }
        spanText.setSpan(
            clickable,
            0,
            spanText.length,
            0
        )
        spanText.setSpan(
            ForegroundColorSpan(Color.RED),
            0,
            7,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        textMsg8.setText(spanText, TextView.BufferType.SPANNABLE)



//Bulleted list in Android

        fun convertToBulletList(stringList: List<String>): CharSequence {
            val spannableStringBuilder2 = SpannableStringBuilder("Android\n")
            stringList.forEachIndexed { index, text ->
                val line: CharSequence = text + if (index < stringList.size - 1) "\n" else ""
                val spannable5: Spannable = SpannableString(line)
                spannable5.setSpan(
                    BulletSpan(15, Color.RED),
                    0,
                    spannable5.length,
                    Spanned.SPAN_INCLUSIVE_EXCLUSIVE
                )
                spannableStringBuilder2.append(spannable5)
            }
            return spannableStringBuilder2
        }
        val androidResourceList = listOf("Android 1", "Android 2", "Android 3", "Android 4")
        textMsg9.text = convertToBulletList(androidResourceList)


    }
}