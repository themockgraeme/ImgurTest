package com.kizio.imgurtest.interfaces

import com.kizio.imgurtest.data.ImageCollection

/**
 * Provides a callback for receiving an [ImageCollection].
 *
 * @author Graeme Sutherland
 * @since 10/12/2019
 */
interface GalleryListener {

	/**
	 * Invoked when an [ImageCollection] is received.
	 *
	 * @param images The received [List] or [ImageCollection] objects
	 */
	fun onReceiveGallery(images: List<ImageCollection>)
}