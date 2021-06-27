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
            // Space between this component and the previous one
            when(orientation) {
                Orientation.VERTICAL -> {
                    val deltaWidth = component.deltaX
                    if(deltaWidth > width) width = deltaWidth
                }
                Orientation.HORIZONTAL -> {
                    val deltaHeight = component.deltaY
                    if(deltaHeight > height) height = deltaHeight
                }
            }

            // Draw the component
            component.draw(canvas)

            val spacing = if(index < children.size - 1) this.spacing else .0

            // Translate the position
            when(orientation) {
                Orientation.VERTICAL -> {
                    val delta = component.height + spacing
                    canvas.translate(0F, delta.toFloat())
                    height += delta
                }
                Orientation.HORIZONTAL -> {
                    val delta = component.width + spacing
                    canvas.translate(delta.toFloat(), 0F)
                    width += delta
                }
            }
        }

        // Load initial translation
        canvas.popMatrix()
    }
}