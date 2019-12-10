package com.kizio.imgurtest.imgur

import android.content.Context
import com.google.gson.GsonBuilder
import com.kizio.imgurtest.R
import com.kizio.imgurtest.data.Gallery
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ImgurController : Callback<Gallery> {

	fun onStart(context: Context) {
		val clientId = context.getString(R.string.client_id)
		val gson = GsonBuilder()
			.setLenient()
			.create()
		val retrofit = Retrofit.Builder()
			.baseUrl(context.getString(R.string.imgur_url))
			.addConverterFactory(GsonConverterFactory.create(gson))
			.build()
		val imgurService = retrofit.create(ImgurService::class.java)
		val call = imgurService.getTopImages(clientId)

		call.enqueue(this)
	}

	/**
	 * Invoked when a network exception occurred talking to the server or when an unexpected
	 * exception occurred creating the request or processing the response.
	 */
	override fun onFailure(call: Call<Gallery>, t: Throwable) {
		TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
	}

	/**
	 * Invoked for a received HTTP response.
	 *
	 * Note: An HTTP response may still indicate an application-level failure such as a 404 or 500.
	 * Call [Response.isSuccessful] to determine if the response indicates success.
	 */
	override fun onResponse(call: Call<Gallery>, response: Response<Gallery>) {
		if (response.isSuccessful) {
			response.body()?.let {
				val gallery = it
			}
		}
	}
}