package eu.iamgio.gump.component.container

import eu.iamgio.gump.app.Canvas
import eu.iamgio.gump.component.DrawableComponent
import eu.iamgio.gump.component.MultipleChildrenComponent

/**
 * A component that displays components one next to another in a direction specified by the sub-class.
 *
 * @param children children components
 * @see Column
 * @see Row
 * @author Giorgio Garofalo
 */
abstract class OrientedContainer(children: List<DrawableComponent>) : MultipleChildrenComponent(children) {

    override var width = .0
    override var height = .0

    /**
     * Space between children.
     */
    var spacing = .0

    override fun draw(canvas: Canvas) {
        width = .0
        height = .0

        // Store initial translation
        canvas.pushMatrix()

        // Draw children
        children.forEachIndexed { index, component ->
            // Set parent
            component.parent = this

            // Draw the component
            component.render(canvas)

            // Find width (for vertical) or height (for horizontal)
            // and translate the component's position
            handleSize(component)

            // Define the next component position if this is not the last one
            // and translate the canvas
            if(index < children.size) {
                handleNextPosition(canvas, component)
            }
        }

        // Restore initial translation
        canvas.popMatrix()
    }

    /**
     * Updates this container's size.
     * For instance, if this is a [Column], it will check [component] width,
     * compare it to [width] and update its value.
     * @param component component to compare size with
     */
    abstract fun handleSize(component: DrawableComponent)

    /**
     * Updates the canvas translation for the next component.
     * For instance, if this is a [Column],
     * the next component will be placed right below [component].
     * @param canvas application canvas
     * @param component current component
     */
    abstract fun handleNextPosition(canvas: Canvas, component: DrawableComponent)
}