package eu.iamgio.gump.observable

/**
 * A value wrapper with listener features.
 *
 * @param T type of the wrapped value
 * @param initialValue initial wrapped value
 * @author Giorgio Garofalo
 */
class Observable<T>(initialValue: T) {

    /**
     * Registered listeners
     */
    private val listeners = mutableListOf<(T, T) -> Unit>()

    /**
     * Wrapped value which calls each of [listeners] when changed.
     */
    var value: T = initialValue
        set(value) {
            val old = field
            field = value
            listeners.forEach { it(old, field) }
        }

    /**
     * Listens to [value] changes.
     * @param listener callback with the new value as a parameter.
     */
    fun listen(listener: (T) -> Unit) {
        listeners += { _, value -> listener(value) }
    }

    /**
     * Listens to [value] changes.
     * @param listener callback with old and new values as parameters.
     */
    fun listenChanges(listener: (T, T) -> Unit) {
        listeners += listener
    }

    /**
     * Listens to [value] changes and instantly calls the listener.
     * @param listener callback with the new value as a parameter.
     */
    fun listenAndCall(listener: (T) -> Unit) {
        listener(value)
        listen(listener)
    }
}

/**
 * Extension function that creates an [Observable] out of any object.
 * @return observable wrapper with the source object as the initial value
 */
fun <T> T.observable() = Observable(this)