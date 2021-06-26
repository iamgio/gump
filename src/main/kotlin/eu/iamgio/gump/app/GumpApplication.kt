package eu.iamgio.gump.app

import eu.iamgio.gump.component.Component

/**
 * This is the class that, when extended, represents the main class of an application/program.
 *
 * @author Giorgio Garofalo
 */
abstract class GumpApplication {

    /**
     * Settings of this application.
     */
    lateinit var settings: AppSettings
        internal set

    /**
     * The canvas that handles drawing on the application screen.
     */
    private val canvas = Canvas()

    /**
     * Launches the application.
     * @param args program arguments
     */
    fun launch(vararg args: String) {
        canvas.application = this
        canvas.launch(*args)
    }

    /**
     * This method creates the new initial settings of the application.
     * It can be overridden to specify new values. If not, the default ones are used.
     * @return application settings
     */
    open fun createSettings(): AppSettings = AppSettings()

    /**
     * This method generates the root content of the application.
     * @return application root
     */
    abstract fun buildRoot(): Component
}