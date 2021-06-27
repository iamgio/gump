package eu.iamgio.gump.component

/**
 * A [DrawableComponent] with multiple children.
 *
 * @param children component children
 * @author Giorgio Garofalo
 */
abstract class MultipleChildrenComponent(val children: List<DrawableComponent>) : DrawableComponent()