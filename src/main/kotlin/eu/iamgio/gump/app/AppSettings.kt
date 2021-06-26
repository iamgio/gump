package eu.iamgio.gump.app

import eu.iamgio.gump.image.Image
import eu.iamgio.gump.observable.observable

/**
 * This class stores the application settings a [GumpApplication] requires.
 *
 * @param title title of the program
 * @param icon icon of the program, `null` for the default one
 * @param isResizable whether the window can be resized
 * @param frameRate frames rendered per second
 * @param width window width
 * @param height window height
 * @author Giorgio Garofalo
 */
class AppSettings @JvmOverloads constructor(
        title: String = "Gump Application",
        icon: Image? = null,
        isResizable: Boolean = true,
        frameRate: Int = 60,
        /**
         * The width of the application window.
         */
        val width: Int = 640,
        /**
         * The height of the application window.
         */
        val height: Int = 360,

) {
    /**
     * The title of the application window.
     */
    val title = title.observable()

    /**
     * The icon of the application window.
     * If the wrapped value if `null` the default icon will be used.
     */
    val icon = icon.observable()

    /**
     * Whether the window can be resized by the user.
     */
    val isResizable = isResizable.observable()

    /**
     * How many frames are rendered in a second.
     */
    val frameRate = frameRate.observable()
}