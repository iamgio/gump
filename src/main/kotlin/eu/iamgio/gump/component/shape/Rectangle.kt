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
class Rectangle(width: Double, height: Double, override var fill: Color = Color()) : Shape() {

    @Suppress("RedundantSetter")
    override var width = width
        public set

    @Suppress("RedundantSetter")
    override var height = height
        public set

    override fun draw(canvas: Canvas) {
        canvas.rect(0F, 0F, width.toFloat(), height.toFloat())
    }
}