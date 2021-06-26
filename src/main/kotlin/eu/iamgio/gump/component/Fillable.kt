package eu.iamgio.gump.component

import eu.iamgio.gump.app.Canvas
import eu.iamgio.gump.color.Color

/**
 * Represents a [Component] that has a mutable fill color.
 *
 * @author Giorgio Garofalo
 */
interface Fillable {

    /**
     * Fill color.
     */
    var fill: Color

    /**
     * Changes the current fill color to [fill].
     */
    fun Canvas.fill() {
        this.fill(fill.red.toFloat(), fill.green.toFloat(), fill.blue.toFloat(), fill.alpha.toFloat() * 255F)
    }
}