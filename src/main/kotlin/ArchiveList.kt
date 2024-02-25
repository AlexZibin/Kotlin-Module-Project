//open class MenuItemList(name: String, mainLogic: () -> Unit = ::process) : NamedList<MenuItemList>(name) {
//open class MenuItemList(name: String, mainLogic: () -> Unit = ::process) : NamedList<MenuItemList>(name) {
class ArchiveList(name: String): NamedList<ArchiveList>(name) {
    override fun process() {
        do {
            val iInput = getUserInput()
            println(iInput)
            if (iInput == 0) { // 0. Создать
                createNewItem()
                continue
            }
            if (iInput == size + 1) { // 3. Выход
                println("Выход")
                break
            }
            println("Выбран элемент $iInput")
            println(this[iInput-1])
            this[iInput-1].process()
        } while (true)
    }

    override fun createNewItem() {
        add(ArchiveList(getNonEmptyText()))
    }
}
