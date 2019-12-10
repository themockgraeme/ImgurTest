package com.kizio.imgurtest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kizio.imgurtest.imgur.ImgurController

class MainActivity : AppCompatActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		makeCall()
	}

	private fun makeCall() {
		val controller = ImgurController()

		controller.onStart(this)
	}
}
