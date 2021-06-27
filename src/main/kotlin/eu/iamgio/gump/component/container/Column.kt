package eu.iamgio.gump.component.container

import eu.iamgio.gump.app.Canvas
import eu.iamgio.gump.component.DrawableComponent

/**
 * A component that displays components one below the other.
 *
 * @param children children components
 * @author Giorgio Garofalo
 */
class Column(children: List<DrawableComponent>) : OrientedContainer(children) {

    constructor(vararg children: DrawableComponent) : this(children.toList())

    /**
     * Update the sub-[component] width value
     * in case it is lower than this container's width.
     */
    override fun handleSize(component: DrawableComponent) {
        width = width.coerceAtLeast(component.deltaX)
    }

    /**
     * Gets the sub-[component]'s height
     * and applies a Y-translation to the [canvas] to that value
     * so that the component that follows will be
     * placed right below.
     */
    override fun handleNextPosition(canvas: Canvas, component: DrawableComponent) {
        val deltaY = component.deltaY + spacing
        canvas.translate(0F, deltaY.toFloat())
        height += deltaY
    }
}