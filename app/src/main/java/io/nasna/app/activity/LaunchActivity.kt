package io.nasna.app.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import io.nasna.app.R

class LaunchActivity : AppCompatActivity() {

    lateinit var handler: Handler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launch)

        handler = Handler()
        handler.postDelayed(
            {
                val intent = Intent(baseContext, AuthenticationActivity::class.java)
                startActivity(intent)
                finish()
            }, 3000
        )

    }
}