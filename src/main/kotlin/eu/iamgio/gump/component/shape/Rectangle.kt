package eu.iamgio.gump.component.shape

import eu.iamgio.gump.app.Canvas
import eu.iamgio.gump.color.Color

/**
 * A rectangle shape.
 *
 * @param width width of the rectangle
 * @param height height of the rectangle
 * @author Giorgio Garofalo
 */
data class Rectangle(var width: Double, var height: Double, override var fill: Color = Color()) : Shape() {

    override fun draw(canvas: Canvas) {
        canvas.fill()
        canvas.rect(0F, 0F, width.toFloat(), height.toFloat())
    }
}