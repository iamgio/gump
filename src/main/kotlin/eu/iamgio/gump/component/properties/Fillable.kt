package eu.iamgio.gump.component.properties

import eu.iamgio.gump.app.Canvas
import eu.iamgio.gump.color.Color
import eu.iamgio.gump.component.DrawableComponent

/**
 * Represents a [DrawableComponent] that has a mutable fill color.
 *
 * @author Giorgio Garofalo
 */
interface Fillable : ComponentProperty {

    /**
     * Fill color.
     */
    var fill: Color

    /**
     * Changes the current fill color to [fill].
     */
    override fun apply(canvas: Canvas) {
        canvas.fill(fill.red.toFloat(), fill.green.toFloat(), fill.blue.toFloat(), fill.alpha.toFloat() * 255F)
    }
}