package eu.iamgio.gump.test

import eu.iamgio.gump.app.AppSettings
import eu.iamgio.gump.app.GumpApplication
import eu.iamgio.gump.color.toColor
import eu.iamgio.gump.component.Component
import eu.iamgio.gump.component.shape.Rectangle

/**
 * @author Giorgio Garofalo
 */
class GumpTest : GumpApplication() {

    override fun createSettings() = AppSettings()

    override fun buildRoot(): Component {
        return Rectangle(100.0, 50.0, java.awt.Color.BLUE.toColor())
    }
}

fun main() {
    GumpTest().launch()
}