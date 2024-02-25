class Note(val name: String, val contents: String): Processable {
    override fun process() {
        println("Название: $name")
        println("Содержание: $contents")
    }

    override fun toString(): String {
        return name + ": (" + contents + ")"
    }
}