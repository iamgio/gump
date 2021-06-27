package eu.iamgio.gump.component.container

import eu.iamgio.gump.app.Canvas
import eu.iamgio.gump.component.DrawableComponent
import eu.iamgio.gump.component.MultipleChildrenComponent

/**
 * A component that overlaps other components one on top of the others.
 *
 * @param children children components
 * @author Giorgio Garofalo
 */
class Stack(children: List<DrawableComponent>) : MultipleChildrenComponent(children) {

    override var width = .0
    override var height = .0

    constructor(vararg children: DrawableComponent) : this(children.toList())

    override fun draw(canvas: Canvas) {
        width = .0
        height = .0
        children.forEach { component ->
            val deltaWidth = component.x + component.width
            if(deltaWidth > width) width = deltaWidth

            val deltaHeight = component.y + component.width
            height = deltaHeight

            component.draw(canvas)
        }
    }
}