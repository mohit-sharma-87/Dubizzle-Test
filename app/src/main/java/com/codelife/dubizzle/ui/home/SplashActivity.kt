package com.codelife.dubizzle.ui.home

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.content.Intent



/**
 * Created by mohitsharma on 23/05/18.
 */
class SplashActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
        finish()
    }

}