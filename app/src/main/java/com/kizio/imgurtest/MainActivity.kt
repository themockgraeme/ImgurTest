package com.kizio.imgurtest

import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.kizio.imgurtest.adapters.GalleryAdapter
import com.kizio.imgurtest.data.ImageCollection
import com.kizio.imgurtest.imgur.ImgurController
import com.kizio.imgurtest.interfaces.GalleryListener
import kotlinx.android.synthetic.main.activity_main.*


/**
 * Main activity for the app.
 *
 * The display is initially being done as a ListView because I've got a couple of hours to get the
 * UI working, and this is a lot quicker than cooking up a RecyclerView.
 */
class MainActivity : AppCompatActivity(), GalleryListener {

	/**
	 * The [ImgurController] used to trigger a download from the Imgur service.
	 */
	private val controller = ImgurController(this)

	/**
	 * Invoked when the activity is created.
	 *
	 * @param savedInstanceState A [Bundle] containing saved state for the activity
	 */
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		setContentView(R.layout.activity_main)

		search_text.setOnEditorActionListener { _: TextView, _, _ ->
			doSearch()

			true
		}
	}

	/**
	 * Invoked when an [ImageCollection] is received.
	 *
	 * @param images The received [List] or [ImageCollection] objects
	 */
	override fun onReceiveGallery(images: List<ImageCollection>) {
		val adapter = GalleryAdapter(this, images)

		list_view.adapter = adapter

		filter_toggle.isEnabled = true

		filter_toggle.isChecked = false

		filter_toggle.setOnCheckedChangeListener { _, isChecked ->
			if (isChecked) {
				adapter.filterImages()
			} else {
				adapter.showAllImages()
			}
		}
	}

	/**
	 * Called when the search button is clicked.
	 *
	 * @param view The [View] that was clicked
	 */
	fun onSearch(view: View) {
		doSearch()
	}

	/**
	 * Calls the search function from the Imgur API.
	 */
	private fun doSearch() {
		val searchTerm = search_text.text.toString()
		val view = findViewById<View>(android.R.id.content)
		val imm: InputMethodManager = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager

		imm.hideSoftInputFromWindow(view.getWindowToken(), 0)

		controller.search(searchTerm)
	}
}
