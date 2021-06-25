package eu.iamgio.gump.test

import eu.iamgio.gump.app.AppSettings
import eu.iamgio.gump.app.GumpApplication

/**
 * @author Giorgio Garofalo
 */
class GumpTest : GumpApplication() {

    override fun createSettings() = AppSettings()
}

fun main() {
    GumpTest().launch()
}