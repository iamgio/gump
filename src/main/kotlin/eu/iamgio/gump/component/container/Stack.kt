package eu.iamgio.gump.component.container

import eu.iamgio.gump.component.DrawableComponent
import eu.iamgio.gump.component.MultipleChildrenComponent

/**
 * A component that overlaps other components one on top of the others.
 *
 * @param children children components
 * @author Giorgio Garofalo
 */
class Stack(children: List<DrawableComponent>) : MultipleChildrenComponent(children) {

    constructor(vararg children: DrawableComponent) : this(children.toList())
}