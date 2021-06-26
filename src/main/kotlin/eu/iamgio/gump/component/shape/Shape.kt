package eu.iamgio.gump.component.shape

import eu.iamgio.gump.app.Canvas
import eu.iamgio.gump.color.Color
import eu.iamgio.gump.component.Component
import eu.iamgio.gump.component.Fillable

/**
 * Represents a [Component] that directly refers to the Processing API to draw itself.
 *
 * @author Giorgio Garofalo
 */
abstract class Shape : Component(), Fillable {

    override var fill = Color()

    /**
     * @throws IllegalAccessError shapes rely on Processing functions only.
     */
    override fun build(canvas: Canvas) = throw IllegalAccessError("Shapes do not implement build method.")

    /**
     * Draws the shape via Processing functions.
     */
    abstract override fun draw(canvas: Canvas)
}