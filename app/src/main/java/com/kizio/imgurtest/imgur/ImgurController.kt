package com.kizio.imgurtest.imgur

import android.util.Log
import com.google.gson.GsonBuilder
import com.kizio.imgurtest.data.Gallery
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ImgurController : Callback<Gallery> {

	companion object {
		/**
		 * Logging [TAG] for debug messages.
		 */
		private val TAG = ImgurController::class.java.name

		/**
		 * The base [URL] for the Imgur API.
		 */
		private const val URL = "https://api.imgur.com"
	}

	fun onStart() {
		val gson = GsonBuilder()
			.setLenient()
			.create()
		val retrofit = Retrofit.Builder()
			.baseUrl(URL)
			.addConverterFactory(GsonConverterFactory.create(gson))
			.build()
		val imgurService = retrofit.create(ImgurService::class.java)
		val call = imgurService.getTopImages()

		call.enqueue(this)
	}

	/**
	 * Invoked when a network exception occurred talking to the server or when an unexpected
	 * exception occurred creating the request or processing the response.
	 *
	 * @param call The [Call] object used to make the request
	 * @param t The [Throwable] containing the error data
	 */
	override fun onFailure(call: Call<Gallery>, t: Throwable) {
		Log.e(TAG, "Failed to retrieve image data", t)
	}

	/**
	 * Invoked for a received HTTP response.
	 *
	 * Note: An HTTP response may still indicate an application-level failure such as a 404 or 500.
	 * Call [Response.isSuccessful] to determine if the response indicates success.
	 *
	 * @param call The [Call] object used to make the request
	 * @param response The [Response] from the server
	 */
	override fun onResponse(call: Call<Gallery>, response: Response<Gallery>) {
		if (response.isSuccessful) {
			response.body()?.let {
				val gallery = it
			}
		}
	}
}