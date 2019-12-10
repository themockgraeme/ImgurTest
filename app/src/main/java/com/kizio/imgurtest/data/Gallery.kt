package com.kizio.imgurtest.data

/**
 * Represents the data for a [Gallery] downloaded from the Imgur server.
 *
 * @author Graeme Sutherland
 * @since 09/10/2019
 * @constructor Creates a new instance of the [Gallery] object.
 * @param data A [List] of [ImageCollection] objects.
 * @param success A [Boolean] indicating success or failure.
 * @param status An [Int] indicating the HTTP status of the call.
 */
data class Gallery (
	val data: List<ImageCollection>,
	val success: Boolean,
	val status: Int
)
