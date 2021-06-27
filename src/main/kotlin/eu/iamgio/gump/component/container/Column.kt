package eu.iamgio.gump.component.container

import eu.iamgio.gump.component.DrawableComponent
import eu.iamgio.gump.component.position.Orientation

/**
 * A component that displays components one below the other.
 *
 * @param children children components
 * @author Giorgio Garofalo
 */
class Column(children: List<DrawableComponent>) : OrientedContainer(children, Orientation.VERTICAL) {

    constructor(vararg children: DrawableComponent) : this(children.toList())
}