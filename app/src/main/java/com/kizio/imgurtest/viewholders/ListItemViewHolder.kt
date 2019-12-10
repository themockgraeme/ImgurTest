package com.kizio.imgurtest.viewholders

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.kizio.imgurtest.R
import com.kizio.imgurtest.data.ImageCollection
import com.squareup.picasso.Picasso

/**
 * View holder class for the view_list_item layout. Unlike the usual version of the pattern, this
 * sets the data in the views, rather than just holding a reference to them.
 *
 * @author Graeme Sutherland
 * @since 10/12/2019
 * @constructor Creates an instance of the view holder.
 * @param title The [TextView] holding the image's title
 * @param date The [TextView] holding the image's date
 * @param numberImages The [TextView] holding the number of images
 * @param image The [ImageView] used to display the image
 */
class ListItemViewHolder(
	private val title: TextView,
	private val date: TextView,
	private val numberImages: TextView,
	private val image: ImageView)
{
	/**
	 * Sets the [ImageCollection] data to display in the view holder.
	 *
	 * @param context The [Context] the list is being displayed in
	 * @param collection The [ImageCollection] to display
	 */
	fun setImageCollection(context: Context, collection: ImageCollection) {
		val imageCount = collection.getNumberOfImages()
		val imageUrl = collection.getImageUrl()
		title.text = collection.title
		date.text = collection.getDate()

		if (imageCount > 0) {
			numberImages.text = context.getString(
				R.string.number_images,
				collection.getNumberOfImages())

			numberImages.visibility = View.VISIBLE
		} else {
			numberImages.visibility = View.GONE
		}

		if (imageUrl != null) {
			downloadImage(imageUrl)
		}
	}

	/**
	 * Downloads an image into the view holder. This could be put int a library class.
	 *
	 * @param url The URL [String] to download the image into
	 */
	private fun downloadImage(url: String) {
		Picasso.get().load(url).into(image)
	}
}