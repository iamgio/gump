package eu.iamgio.gump.image

import eu.iamgio.gump.app.Canvas
import processing.core.PImage

/**
 * A pixel-based image.
 *
 * @param path image file path
 * @author Giorgio Garofalo
 */
data class Image(val path: String) {

    /**
     * Converts this image to a Processing [PImage].
     * @param canvas canvas instance
     * @return Image as Processing [PImage]
     */
    fun toPImage(canvas: Canvas): PImage = canvas.loadImage(path)
}