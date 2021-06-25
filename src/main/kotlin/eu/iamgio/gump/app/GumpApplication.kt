package eu.iamgio.gump.app

import processing.core.PApplet

/**
 * This is the class that, when extended, represents the main class of an application/program.
 *
 * @author Giorgio Garofalo
 */
abstract class GumpApplication : PApplet() {

    /**
     * Settings of this application.
     */
    lateinit var settings: AppSettings
        private set

    /**
     * This is the start method from Processing.
     * Here settings are initialized.
     */
    override fun settings() {
        settings = createSettings()
        size(settings.width, settings.height)
    }

    /**
     * This is the initialization method from Processing.
     * Here listeners that bind a setting to a window property are set.
     */
    override fun setup() {
        with(settings) {
            title.listenAndCall { surface.setTitle(it) }
            icon.listenAndCall  { if(it != null) surface.setIcon(it.toPImage(this@GumpApplication)) }
        }
    }

    /**
     * Launches the application.
     * @param args program arguments
     */
    fun launch(vararg args: String) {
        main(this::class.java, *args)
    }

    /**
     * This method creates the new initial settings of the application.
     * It can be overridden to specify new values. If not, the default ones are used.
     * @return application settings
     */
    open fun createSettings(): AppSettings = AppSettings()
}