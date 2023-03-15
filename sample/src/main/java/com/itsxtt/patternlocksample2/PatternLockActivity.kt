package com.itsxtt.patternlocksample2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.text.TextUtils
import android.widget.Toast
import com.itsxtt.patternlock2.PatternLockView
import kotlinx.android.synthetic.main.activity_pattern_9x9.*
import kotlinx.android.synthetic.main.activity_pattern_default.*
import kotlinx.android.synthetic.main.activity_pattern_jd.*
import kotlinx.android.synthetic.main.activity_pattern_with_indicator.*
import java.util.ArrayList


class PatternLockActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var type = intent.getIntExtra(MainActivity.KEY_PATTERN_TYPE, MainActivity.TYPE_DEFAULT)
        when(type) {
            MainActivity.TYPE_DEFAULT -> {
                setContentView(R.layout.activity_pattern_default)
                defaultPatternLockView.setOnPatternListener(listener)
            }
            MainActivity.TYPE_JD_STYLE -> {
                setContentView(R.layout.activity_pattern_jd)
                jdPatternLockView.setOnPatternListener(listener)
            }
            MainActivity.TYPE_WITH_INDICATOR -> {
                setContentView(R.layout.activity_pattern_with_indicator)
                indicatorPatternLockView.setOnPatternListener(listener)
            }
            MainActivity.TYPE_9x9 -> {
                setContentView(R.layout.activity_pattern_9x9)
                ninePatternLockView.setOnPatternListener(listener)
            }
            MainActivity.TYPE_SECURE_MODE -> {
                setContentView(R.layout.activity_pattern_default)
                defaultPatternLockView.enableSecureMode()
                defaultPatternLockView.setOnPatternListener(listener)
            }
        }

    }

    private var listener  = object : PatternLockView.OnPatternListener {

        override fun onStarted() {
            super.onStarted()
        }

        override fun onProgress(ids: ArrayList<Int>) {
            super.onProgress(ids)
        }

        override fun onComplete(ids: ArrayList<Int>): Boolean {
            // path should be = [12,9,5,1,7,11,]
            var isCorrect = TextUtils.equals("12,9,5,1,7,11,", getPatternString(ids))
            var tip: String
            if (isCorrect) {
                tip = "CORRECT"// + getPatternString(ids)
            } else {
                tip = "######WRONG######"// + getPatternString(ids)
            }
            Toast.makeText(this@PatternLockActivity, tip, Toast.LENGTH_SHORT).show()
            return isCorrect
        }
    }

    private fun getPatternString(ids: ArrayList<Int>) : String {
        var result = ""
        for (id in ids) {
            result += id.toString()
            result += ','
        }
        return result
    }
}