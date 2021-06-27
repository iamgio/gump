package eu.iamgio.gump.component.container

import eu.iamgio.gump.app.Canvas
import eu.iamgio.gump.component.DrawableComponent

/**
 * A component that displays components one next to another.
 *
 * @param children children components
 * @author Giorgio Garofalo
 */
class Row(children: List<DrawableComponent>) : OrientedContainer(children) {

    constructor(vararg children: DrawableComponent) : this(children.toList())

    /**
     * Update the sub-[component] height value
     * in case it is lower than this container's height.
     */
    override fun handleSize(component: DrawableComponent) {
        height = height.coerceAtLeast(component.deltaY)
    }

    /**
     * Gets the sub-[component]'s width
     * and applies a X-translation to the [canvas] to that value
     * so that the component that follows will be
     * placed right next to it.
     */
    override fun handleNextPosition(canvas: Canvas, component: DrawableComponent) {
        val deltaX = component.deltaX + spacing
        canvas.translate(deltaX.toFloat(), 0F)
        width += deltaX
    }
}