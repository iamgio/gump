package eu.iamgio.gump.image

import eu.iamgio.gump.app.GumpApplication
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
     * @param application application instance
     * @return Image as Processing [PImage]
     */
    fun toPImage(application: GumpApplication): PImage = application.loadImage(path)
}