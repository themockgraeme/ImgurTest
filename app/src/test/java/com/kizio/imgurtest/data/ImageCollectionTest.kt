package com.kizio.imgurtest.data

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * Unit tests for the comparable interface on the [ImageCollection] class.
 *
 * @author Graeme Sutherland
 * @since 11/12/2019
 */
class ImageCollectionTest {

	/**
	 * Compares two [ImageCollection] objects with identical values.
	 */
	@Test
	fun compare_otherIsIdentical() {
		val list = ArrayList<ImageData>()
		val collectionA = ImageCollection("A", 1000, 0, 0, 0, list)
		val collectionB = ImageCollection("A", 1000, 0, 0, 0, list)

		assertEquals("Comparing identical objects", collectionA.compareTo(collectionB), 0)
	}

	/**
	 * Compares two [ImageCollection] references that point at the same object.
	 */
	@Test
	fun compare_otherIsSame() {
		val list = ArrayList<ImageData>()
		val collectionA = ImageCollection("A", 1000, 0, 0, 0, list)

		assertEquals("Comparing same object", collectionA.compareTo(collectionA), 0)
	}

	/**
	 * Compares two [ImageCollection] objects with an identical dateTime value.
	 */
	@Test
	fun compare_otherIsEqualDateTime() {
		val list = ArrayList<ImageData>()
		val collectionA = ImageCollection("A", 1000, 0, 0, 0, list)
		val collectionB = ImageCollection("B", 1000, 1, 1, 1, list)

		assertEquals("Comparing equal dateTime", collectionA.compareTo(collectionB), 0)
	}

	/**
	 * Compares two [ImageCollection] objects with a larger dateTime value in the second.
	 */
	@Test
	fun compare_otherIsGreaterDateTime() {
		val list = ArrayList<ImageData>()
		val collectionA = ImageCollection("A", 1000, 0, 0, 0, list)
		val collectionB = ImageCollection("B", 1001, 1, 1, 1, list)

		assertTrue("Comparing greater than", collectionA > collectionB)
	}

	/**
	 * Compares two [ImageCollection] objects with a larger dateTime value in the first.
	 */
	@Test
	fun compare_otherIsLesserDateTime() {
		val list = ArrayList<ImageData>()
		val collectionA = ImageCollection("A", 1001, 0, 0, 0, list)
		val collectionB = ImageCollection("B", 1000, 1, 1, 1, list)

		assertTrue("Comparing less than", collectionA < collectionB)
	}
}