package eu.iamgio.gump.component.shape

import eu.iamgio.gump.app.Canvas
import eu.iamgio.gump.color.Color
import eu.iamgio.gump.component.DrawableComponent
import eu.iamgio.gump.component.properties.Fillable

/**
 * Represents a [DrawableComponent] that directly refers to the Processing API to draw itself.
 *
 * @author Giorgio Garofalo
 */
abstract class Shape : DrawableComponent(), Fillable {

    override var fill = Color()

    /**
     * Draws the shape via Processing functions.
     */
    abstract override fun draw(canvas: Canvas)
}