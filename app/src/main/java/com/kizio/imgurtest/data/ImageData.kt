package com.kizio.imgurtest.data

import java.util.*

/**
 * Represents an image or collection of images downloaded from the Imgur
 */
data class ImageData(
	val title: String,
	val datetime: Long,
	val points: Int,
	val score: Int,
	val topic_id: Int) {

	/**
	 *
	 */
	fun showImage() : Boolean {
		return (points + score + topic_id) % 2 == 0
	}

	/**
	 * Conversion function to transform the [datetime] [Long] into a [String].
	 *
	 * If I was spending more time on this, I'd build a GSON converter to do the transformation as
	 * the data is read. But it's a quick and dirty piece of code for a test, so I'm taking a
	 * shortcut. :)
	 *
	 * @return The [datetime] value as a [String] in the format DD/MM/YYYY h:mm a
	 */
	fun getDate() : String {
		val date = Date(datetime)
	}
}