open class NamedList<T> (val name: String) : ArrayList<T>() {
    override fun toString(): String {
        return name + super.toString()
    }
}