package eu.iamgio.gump.component

/**
 * A [DrawableComponent] with only one child.
 *
 * @param child component child
 * @author Giorgio Garofalo
 */
abstract class SingleChildComponent(val child: DrawableComponent) : DrawableComponent()