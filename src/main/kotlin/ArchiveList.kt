class ArchiveList(name: String): NamedList<NoteList>(name), Processable {
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
            println("Выбран архив $iInput")
            println(this[iInput-1])
            this[iInput-1].process()
        } while (true)
    }

    override fun createNewItem() {
        add(NoteList(getNonBlankText("Имя архива")))
    }
}
