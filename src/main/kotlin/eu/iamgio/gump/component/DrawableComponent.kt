package eu.iamgio.gump.component

import eu.iamgio.gump.app.Canvas
import eu.iamgio.gump.app.GumpApplication

/**
 * Represents an element in the scene of a [GumpApplication] that draws itself through Processing functions.
 *
 * @author Giorgio Garofalo
 */
abstract class DrawableComponent {

    /**
     * Draws the content to the canvas.
     * By default it draws the [DrawableComponent] built in [build],
     * but it can be overridden to call raw Processing functions.
     */
    abstract fun draw(canvas: Canvas)
}