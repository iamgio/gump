package eu.iamgio.gump.component

import eu.iamgio.gump.app.Canvas
import eu.iamgio.gump.app.GumpApplication
import eu.iamgio.gump.component.properties.ComponentProperty

/**
 * Represents an element in the scene of a [GumpApplication] that draws itself through Processing functions.
 *
 * @author Giorgio Garofalo
 */
abstract class DrawableComponent {

    var parent: DrawableComponent? = null

    /**
     * X translation of this component.
     */
    var x = 0.0

    /**
     * Y translation of this component.
     */
    var y = 0.0

    /**
     * Width of this component.
     */
    abstract var width: Double
        protected set

    /**
     * Height of this component.
     */
    abstract var height: Double
        protected set

    /**
     * Total width occupied by this component.
     */
    internal val deltaX
        get() = x + width

    /**
     * Total height occupied by this component.
     */
    internal val deltaY
        get() = y + height

    /**
     * Draws the content to the canvas via [draw] after applying component-specific properties.
     * @param canvas application canvas
     */
    fun render(canvas: Canvas) {
        // Set child's parent if this is a SingleChildComponent.
        // This has to be done manually for MultipleChildrenComponent
        // for optimization purposes.
        if(this is SingleChildComponent) child.parent = this

        // Save the initial translation
        canvas.pushMatrix()

        // Apply translation to x and y.
        canvas.translate(x.toFloat(), y.toFloat())

        // Apply component properties such as Fillable and Padding.
        if(this is ComponentProperty) apply(canvas)

        // Draw the content.
        draw(canvas)

        // Restore the initial translation.
        canvas.popMatrix()
    }

    /**
     * Draws the content to the canvas.
     * By default it draws the [DrawableComponent] built in [build],
     * but it can be overridden to call raw Processing functions.
     * @param canvas application canvas
     */
    protected abstract fun draw(canvas: Canvas)
}