package eu.iamgio.gump.color

/**
 * An RGBA color. R, G and B are 0-255, alpha is 0-1.
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

        /**
         * @param hue 0-1 hue value
         * @param saturation 0-1 saturation value
         * @param brightness 0-1 brightness value
         * @return color from HSB
         */
        fun hsb(hue: Float, saturation: Float, brightness: Float) = java.awt.Color.getHSBColor(hue, saturation, brightness).toColor()

        /**
         * @param hex hexadecimal color value, with or without #
         * @return decoded color from hex
         */
        fun hex(hex: String) = java.awt.Color.decode(if(hex.startsWith("#")) hex else "#$hex").toColor()

        /**
         * @param rgb value for red, green and blue
         * @return grayscale color
         */
        fun grayscale(rgb: Int) = Color(rgb, rgb, rgb)
    }
}

/**
 * @return AWT color to Gump Color
 */
fun java.awt.Color.toColor() = Color.fromAWT(this)