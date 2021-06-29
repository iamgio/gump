package eu.iamgio.gump.component.container

import eu.iamgio.gump.app.Canvas
import eu.iamgio.gump.color.Color
import eu.iamgio.gump.component.DrawableComponent
import eu.iamgio.gump.component.SingleChildComponent
import eu.iamgio.gump.component.properties.Fillable
import eu.iamgio.gump.component.properties.Insets
import eu.iamgio.gump.component.properties.Padding

/**
 * A container wraps a child and serves properties like [fill] and [padding].
 * @author Giorgio Garofalo
 */
class Container(child: DrawableComponent, override var fill: Color = Color.TRANSPARENT, override val padding: Insets = Insets()) : SingleChildComponent(child), Padding, Fillable {

    // Used to check if the size was changed externally
    private var _width = .0
    private var _height = .0

    override var width = .0
        public set(value) {
            field = value + padding.horizontal
        }

    override var height = .0
        public set(value) {
            field = value + padding.vertical
        }

    override fun draw(canvas: Canvas) {
        if(_width == width) {
            width = child.width
            _width = width
        }
        if(_height == height) {
            height = child.height
            _height = height
        }

        // Fill background.
        canvas.rect(0F, 0F, width.toFloat(), height.toFloat())

        // Apply padding translation.
        super<Padding>.apply(canvas)

        child.render(canvas)
    }

    override fun apply(canvas: Canvas) {
        super<Fillable>.apply(canvas)
    }
}