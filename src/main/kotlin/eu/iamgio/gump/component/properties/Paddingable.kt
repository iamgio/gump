package eu.iamgio.gump.component.properties

import eu.iamgio.gump.app.Canvas
import eu.iamgio.gump.component.DrawableComponent

/**
 * Represents a [DrawableComponent] that has a padding.
 *
 * @author Giorgio Garofalo
 */
interface Paddingable : ComponentProperty {
    val padding: Insets

    override fun apply(canvas: Canvas) {
        canvas.translate((padding.top - padding.bottom).toFloat(), (padding.right - padding.left).toFloat())
    }
}

/**
 * Mutable [top], [right], [bottom] and [left] insets.
 */
data class Insets(var top: Double = .0, var right: Double = .0, var bottom: Double = .0, var left: Double = .0) {
    constructor(topRightBottomLeft: Double) : this(topRightBottomLeft, topRightBottomLeft, topRightBottomLeft, topRightBottomLeft)

    fun setTRBL(topRightBottomLeft: Double) {
        top = topRightBottomLeft
        right = topRightBottomLeft
        bottom = topRightBottomLeft
        left = topRightBottomLeft
    }
}