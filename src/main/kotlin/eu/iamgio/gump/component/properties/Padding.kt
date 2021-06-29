package eu.iamgio.gump.component.properties

import eu.iamgio.gump.app.Canvas
import eu.iamgio.gump.component.DrawableComponent
import eu.iamgio.gump.component.container.Container

/**
 * Represents a [DrawableComponent] that has a padding.
 *
 * @author Giorgio Garofalo
 */
interface Padding : ComponentProperty {
    val padding: Insets

    /**
     * Applies a translation equals to the [padding] value.
     * This needs further operations handled by the component.
     * @see Container
     */
    override fun apply(canvas: Canvas) {
        canvas.translate(padding.left.toFloat(), padding.top.toFloat())
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

    /**
     * Total horizontal offset.
     */
    val horizontal: Double
        get() = left + right

    /**
     * Total vertical offset.
     */
    val vertical: Double
        get() = top + bottom
}