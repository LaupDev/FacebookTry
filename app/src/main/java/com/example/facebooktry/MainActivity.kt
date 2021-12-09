package com.example.facebooktry

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.facebooktry.databinding.ActivityMainBinding
import com.facebook.FacebookSdk
import com.facebook.LoggingBehavior
import com.facebook.appevents.AppEventsConstants
import com.facebook.appevents.AppEventsLogger

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var facebookLogger: AppEventsLogger

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        FacebookSdk.setIsDebugEnabled(true)
        FacebookSdk.addLoggingBehavior(LoggingBehavior.APP_EVENTS)

        facebookLogger = AppEventsLogger.newLogger(this)

        binding.triggerEvent.setOnClickListener {
            val facebookParams = Bundle().apply {
                putString(AppEventsConstants.EVENT_PARAM_CURRENCY, "UAH")
                putString(AppEventsConstants.EVENT_PARAM_CONTENT_ID, "121")
                putString(AppEventsConstants.EVENT_PARAM_CONTENT, "[{\"id\": \"121\", \"quantity\": 2}]")
            }
            facebookLogger.logEvent(AppEventsConstants.EVENT_NAME_ADDED_TO_CART, 129.0, facebookParams)
        }


    }
}