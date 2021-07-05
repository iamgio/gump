package eu.iamgio.gump.test

import eu.iamgio.gump.app.GumpApplication
import eu.iamgio.gump.color.Color
import eu.iamgio.gump.component.DrawableComponent
import eu.iamgio.gump.component.container.Center
import eu.iamgio.gump.component.container.Stack
import eu.iamgio.gump.component.shape.Rectangle

/**
 * @author Giorgio Garofalo
 */
class CenterTest : GumpApplication() {

    override fun buildRoot(): DrawableComponent {
        //return Center(Rectangle(200.0, 200.0, Color(255, 255, 0)))
        return Center(
                Stack(
                        Rectangle(200.0, 200.0, Color(255, 255, 0)),
                        /*Center(
                                Rectangle(100.0, 50.0)
                        )*/
                )
        )
    }
}

fun main() {
    CenterTest().launch()
}