package eu.iamgio.gump.color

/**
 * An RGBA color.
 *
 * @author Giorgio Garofalo
 */
data class Color(val red: Int, val green: Int, val blue: Int, val alpha: Double = 1.0) {

    constructor() : this(0, 0, 0)

    fun withOpacity(alpha: Double) = this.copy(alpha = alpha)

    companion object {
        /**
         * @return AWT color to Gump Color
         */
        fun fromAWT(color: java.awt.Color) = Color(color.red, color.green, color.blue)
    }
}

/**
 * @return AWT color to Gump Color
 */
fun java.awt.Color.toColor() = Color.fromAWT(this)