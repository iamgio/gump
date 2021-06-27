package eu.iamgio.gump.component.shape

import eu.iamgio.gump.app.Canvas
import eu.iamgio.gump.color.Color
import processing.core.PGraphics

/**
 * An ellipse shape.
 *
 * @param width width of the ellipse
 * @param height height of the ellipse
 * @author Giorgio Garofalo
 */
class Ellipse(width: Double, height: Double, override var fill: Color = Color(), var mode: EllipseMode = EllipseMode.CORNERS) : Shape() {

    @Suppress("RedundantSetter")
    override var width = width
        public set

    @Suppress("RedundantSetter")
    override var height = height
        public set

    override fun draw(canvas: Canvas) {
        canvas.ellipseMode(mode.value)
        canvas.ellipse(0F, 0F, width.toFloat(), height.toFloat())
    }
}

/**
 * Different relative positions of an ellipse.
 */
enum class EllipseMode(internal val value: Int) {
    RADIUS(PGraphics.RADIUS),
    CENTER(PGraphics.CENTER),
    CORNER(PGraphics.CORNER),
    CORNERS(PGraphics.CORNERS)
}