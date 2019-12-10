package com.kizio.imgurtest.imgur

import com.kizio.imgurtest.data.Gallery
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

/**
 * Provides the HTTP API for the Imgur server to access its services.
 */
interface ImgurService {

	/**
	 * Gets the top images of the week.
	 *
	 * @param clientId A [String] containing the client ID for this app
	 * @return A [Call] to access the downloaded data as a [Gallery] object
	 */
	@Headers("Authorization: Client-ID 3dd4b5a5d616392")
	@GET("/3/gallery/top/top")
	fun getTopImages(@Header("Client-ID") clientId: String) : Call<Gallery>
}