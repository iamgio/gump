package eu.iamgio.gump.app

import processing.core.PApplet

/**
 * Represents a Processing applet, used as a bridge between a [GumpApplication] and the Processing API.
 *
 * @author Giorgio Garofalo
 */
class Canvas : PApplet() {

    /**
     * Owner of this canvas.
     */
    lateinit var application: GumpApplication
        internal set

    /**
     * This is the start method from Processing.
     * Here settings are initialized.
     */
    override fun settings() {
        application.settings = application.createSettings()
        size(application.settings.width, application.settings.height)
    }

    /**
     * This is the initialization method from Processing.
     */
    override fun setup() {
        initListeners(application.settings)
    }

    /**
     * This is the render method from Processing.
     */
    override fun draw() {
        val root = application.buildRoot()
        root.draw(this)
    }

    /**
     * Launches the Processing program.
     */
    fun launch(vararg args: String) {
        runSketch(arrayOf(this::class.java.name) + args, this)
    }

    /**
     * Listeners that bind a setting to a window property are set.
     */
    private fun initListeners(settings: AppSettings) = with(settings) {
        title.listenAndCall { surface.setTitle(it) }
        icon.listenAndCall { if(it != null) surface.setIcon(it.toPImage(this@Canvas)) }
        isResizable.listenAndCall { surface.setResizable(it) }
    }
}