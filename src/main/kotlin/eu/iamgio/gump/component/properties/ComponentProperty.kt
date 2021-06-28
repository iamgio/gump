package eu.iamgio.gump.component.properties

import eu.iamgio.gump.app.Canvas

/**
 * Represents a property a component has that has to be applied to the [Canvas].
 *
 * @author Giorgio Garofalo
 */
interface ComponentProperty {

    /**
     * Applies the property to the application [canvas].
     * @param canvas application canvas
     */
    fun apply(canvas: Canvas)
}