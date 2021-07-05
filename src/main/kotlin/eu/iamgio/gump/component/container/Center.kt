package eu.iamgio.gump.component.container

import eu.iamgio.gump.app.Canvas
import eu.iamgio.gump.component.DrawableComponent
import eu.iamgio.gump.component.SingleChildComponent

/**
 * A component that places its [child] in the center of it.
 *
 * @param child centered component
 * @author Giorgio Garofalo
 */
class Center(child: DrawableComponent) : SingleChildComponent(child) {

    @Suppress("SuspiciousVarProperty")
    override var width = .0
        get() = parent?.width ?: .0

    @Suppress("SuspiciousVarProperty")
    override var height = .0
        get() = parent?.height ?: .0

    override fun draw(canvas: Canvas) {
        // TODO child width is zero for non-shapes
        val translation = (width / 2 - child.width / 2).toFloat() to (height / 2 - child.height / 2).toFloat()
        println("$translation w[$width ${child.width}] h[$height ${child.height}]")

        canvas.translate(translation.first, translation.second)
        child.render(canvas)
        canvas.translate(-translation.first, -translation.second)
    }
}