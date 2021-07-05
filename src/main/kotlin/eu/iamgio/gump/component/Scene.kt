package eu.iamgio.gump.component

import eu.iamgio.gump.app.Canvas

/**
 * @author Giorgio Garofalo
 */
class Scene(private val canvas: Canvas) : DrawableComponent() {

    lateinit var root: DrawableComponent

    @Suppress("SuspiciousVarProperty")
    override var width = .0
        get() = canvas.width.toDouble()

    @Suppress("SuspiciousVarProperty")
    override var height = .0
        get() = canvas.height.toDouble()

    override fun draw(canvas: Canvas) = root.render(canvas)
}