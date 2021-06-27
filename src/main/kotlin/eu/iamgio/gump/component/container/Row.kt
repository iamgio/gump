package eu.iamgio.gump.component.container

import eu.iamgio.gump.component.DrawableComponent
import eu.iamgio.gump.component.position.Orientation

/**
 * A component that displays components one next to another.
 *
 * @param children children components
 * @author Giorgio Garofalo
 */
class Row(children: List<DrawableComponent>) : OrientedContainer(children, Orientation.HORIZONTAL) {

    constructor(vararg children: DrawableComponent) : this(children.toList())
}