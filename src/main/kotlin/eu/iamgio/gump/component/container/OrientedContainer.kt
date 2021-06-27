package eu.iamgio.gump.component.container

import eu.iamgio.gump.app.Canvas
import eu.iamgio.gump.component.DrawableComponent
import eu.iamgio.gump.component.MultipleChildrenComponent
import eu.iamgio.gump.component.position.Orientation

/**
 * A component that displays components one next to another in a direction specified by [orientation].
 *
 * @param children children components
 * @param orientation where components should be displayed relatively to the previous one
 * @see Column
 * @see Row
 * @author Giorgio Garofalo
 */
open class OrientedContainer(children: List<DrawableComponent>, private val orientation: Orientation) : MultipleChildrenComponent(children) {

    override var width = .0
    override var height = .0

    var spacing = .0

    override fun draw(canvas: Canvas) {
        width = .0
        height = .0

        // Store initial translation
        canvas.pushMatrix()

        // Draw children
        children.forEachIndexed { index, component ->
            // Draw the component
            component.draw(canvas)

            // Spacing between this item and the next
            // by checking if this is the last component in its parent's children.
            val spacing = if(index < children.size - 1) this.spacing else .0

            // Find width (for vertical) or height (for horizontal)
            // and translate the component's position
            when(orientation) {
                Orientation.VERTICAL -> {
                    // Check if this component's width
                    // is higher than this container's width,
                    // in that case update its value
                    val deltaX = component.deltaX
                    if(deltaX > width) width = deltaX

                    // Get this component's height
                    // and apply a Y-translation to the canvas to that value
                    // so that the component that follows will be
                    // placed right below
                    val deltaY = component.deltaY + spacing
                    canvas.translate(0F, deltaY.toFloat())
                    height += deltaY
                }
                Orientation.HORIZONTAL -> {
                    // Check if this component's height
                    // is higher than this container's height,
                    // in that case update its value
                    val deltaY = component.deltaY
                    if(deltaY > height) height = deltaY

                    // Get this component's width
                    // and apply a X-translation to the canvas to that value
                    // so that the component that follows will be
                    // placed right next to it
                    val deltaX = component.deltaX + spacing
                    canvas.translate(deltaX.toFloat(), 0F)
                    width += deltaX
                }
            }
        }

        // Load initial translation
        canvas.popMatrix()
    }
}