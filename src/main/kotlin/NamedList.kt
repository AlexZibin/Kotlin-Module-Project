import java.util.Scanner

abstract class NamedList<T> (val name: String) : ArrayList<T>() {
    abstract fun createNewItem()
    override fun toString(): String {
        return name + super.toString()
    }
    fun displayMenu(){
        if (isEmpty())
            println("\n(Пустой) $name:")
        else
            println("\n$name:")
        println("0. Создать")
        //super.forEach { element -> println( element) }
        forEachIndexed  { index, element -> println("${index+1}. $element") }
        println("${size + 1}. Выход")
    }

    fun getUserInput(): Int{
        val scanner = Scanner(System.`in`)
        //var correctInput = false
        var input: String
        var iInput: Int
        do {
            displayMenu()
            print("Ваш выбор: ")
            input = scanner.nextLine()!!
            if (input.toIntOrNull() == null) {
                println("\nОшибка!\nСледует вводить цифру!")
                continue
            }
            iInput = input.toInt()
            if (iInput < 0 || iInput >= size + 2) {
                println("\nОшибка!\nТакого пункта меню не существует!")
                continue
            }
            break
        } while (true)
        return iInput
    }
    fun getNonEmptyText(prompt: String = "Введите текст"): String {
        val scanner = Scanner(System.`in`)
        var input: String
        println("\nСоздание нового элемента")
        do {
            print("$prompt: ")
            input = scanner.nextLine()!!
            if (input.isEmpty()) {
                println("\nОшибка!\nПустые строки не разрешены!")
                continue
            }
            //add(ArchiveList(input))
            break
        } while (true)
        return input
    }
}