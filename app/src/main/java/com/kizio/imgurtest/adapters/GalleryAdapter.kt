package com.kizio.imgurtest.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.kizio.imgurtest.R
import com.kizio.imgurtest.data.ImageCollection
import kotlinx.android.synthetic.main.view_list_item.view.*

/**
 * Adapter to display a [List] of [ImageCollection] objects.
 *
 * @author Graeme Sutherland
 * @since 10/12/2019
 */
class GalleryAdapter(private val context: Context, private val images: List<ImageCollection>)
	: BaseAdapter() {

	/**
	 * Holds the images displayed by the app.
	 */
	private val displayImages = ArrayList<ImageCollection> (images.size)

	init {
		showAllImages()
	}

	/**
	 * Creates the [View] to display for the specified position in the list.
	 *
	 * @param position An [Int] giving the position of the [View] in the list
	 * @param convertView A [View] to reuse if possible
	 * @param parent The parent [ViewGroup] to attach the [View] to
	 * @return The [View] to display in the list
	 */
	override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
		val imageCollection = getItem(position)
		val view = if (convertView != null) {
			convertView
		} else {
			val inflater = LayoutInflater.from(context)

			inflater.inflate(R.layout.view_list_item, parent, false)
		}

		view.title.text = imageCollection.title
		view.date.text = imageCollection.getDate()
		view.number_of_images.text = imageCollection.getNumberOfImages().toString()
		view.image.text = imageCollection.getImageUrl()

		return view
	}

	/**
	 * Gets the item at the specified position.
	 *
	 * @param position The position of the item in the list
	 * @return The [ImageCollection] at the specified position
	 */
	override fun getItem(position: Int): ImageCollection {
		return displayImages[position]
	}

	/**
	 * Gets the item ID at the specified position.
	 *
	 * @param position The position of the item in the list
	 * @return The item's ID as a [Long]
	 */
	override fun getItemId(position: Int): Long {
		return position.toLong()
	}

	/**
	 * Gets the number of items in the list.
	 *
	 * @return The number of items as an [Int]
	 */
	override fun getCount(): Int {
		return displayImages.size
	}

	/**
	 * Shows all images in the list.
	 */
	fun showAllImages() {
		displayImages.clear()

		displayImages.addAll(images)

		notifyDataSetChanged()
	}

	/**
	 * Filters the display images according to the method in the [ImageCollection] class.
	 */
	fun filterImages() {
		displayImages.clear()

		for (image in images) {
			if (image.showImage()) {
				displayImages.add(image)
			}
		}

		notifyDataSetChanged()
	}
}