package com.kizio.imgurtest.imgur

import com.kizio.imgurtest.data.Gallery
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

/**
 * Provides the HTTP API for the Imgur server to access its services.
 *
 * Note that the client secret is: 1943b3d7bb0e29bf28a359eb75f7acf8b6b738b8
 */
interface ImgurService {

	/**
	 * Gets the top images of the week.
	 *
	 * @return A [Call] to access the downloaded data as a [Gallery] object
	 */
	@Headers("Authorization: Client-ID 3dd4b5a5d616392")
	@GET("/3/gallery/search/top")
	fun searchTopImages(@Query("q") query: String) : Call<Gallery>
}