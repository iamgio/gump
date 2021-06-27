package eu.iamgio.gump.component.shape

import eu.iamgio.gump.app.Canvas
import eu.iamgio.gump.color.Color

/**
 * A circle shape.
 *
 * @param radius radius of the circle
 * @author Giorgio Garofalo
 */
class Circle(var radius: Double, override var fill: Color = Color(), var mode: EllipseMode = EllipseMode.CORNERS) : Shape() {

    override var width: Double
        get() = radius * 2
        set(value) { radius = value / 2 }

    override var height: Double
        get() = radius * 2
        set(value) { radius = value / 2 }

    override fun draw(canvas: Canvas) {
        canvas.ellipseMode(mode.value)
        canvas.ellipse(0F, 0F, radius.toFloat(), radius.toFloat())
    }
}