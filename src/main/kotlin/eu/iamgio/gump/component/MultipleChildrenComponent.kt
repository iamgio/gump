package eu.iamgio.gump.component

import eu.iamgio.gump.app.Canvas

/**
 * A [DrawableComponent] with only one child.
 *
 * @param children component children
 * @author Giorgio Garofalo
 */
open class MultipleChildrenComponent(val children: List<DrawableComponent>) : DrawableComponent() {

    override fun draw(canvas: Canvas) {
        children.forEach { it.draw(canvas) }
    }
}