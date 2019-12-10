package com.kizio.imgurtest.data

import java.text.SimpleDateFormat
import java.util.*

/**
 * Represents an image or collection of images downloaded from the Imgur web service.
 *
 * @author Graeme Sutherland
 * @since 09/12/2019
 * @constructor Creates a new instance of the [ImageCollection] class.
 * @param title A [String] containing the title of the image collection
 * @param datetime A [Long] containing the date and time the image was uploaded
 * @param points An [Int] giving the number of points for the image
 * @param score An [Int] giving the score for the image
 * @param topic_id An [Int] giving the topic ID for the image
 * @param images A [List] of [ImageData] downloaded from the server
 */
data class ImageCollection(
	val title: String,
	val datetime: Long,
	val points: Int,
	val score: Int,
	val topic_id: Int,
	val images: List<ImageData>?) {

	companion object {
		/**
		 * The format [String] for generating a human readable date and time.
		 */
		private const val DATE_FORMAT = "DD/MM/yyyy hh:mm a"

		/**
		 * A [SimpleDateFormat] used to convert the [datetime] variable into a human readable
		 * [String].
		 */
		private val FORMATTER = SimpleDateFormat(DATE_FORMAT, Locale.ENGLISH)
	}

	/**
	 * Gets whether or not to show the image if the toggle is flipped. This is based on the sum of
	 * the [points], [score], and [topic_id] being even.
	 *
	 * @return True if the image should be shown, false otherwise
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
		return FORMATTER.format(Date(datetime))
	}

	/**
	 * Gets the number of images in this collection.
	 */
	fun getNumberOfImages() : Int {
		return images?.size ?: 0
	}

	/**
	 * Gets the URL to download the first image in the collection from.
	 *
	 * @return The first image's URL
	 */
	fun getImageUrl() : String? {
		return images?.let {
			if (it.isNotEmpty()) {
				it [0].link
			} else {
				null
			}
		}
	}
}