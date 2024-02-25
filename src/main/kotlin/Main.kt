import java.util.Scanner

fun main() {
    val list1 = MenuItemList<MenuItemList<String>>("Список архивов")
    list1.add (MenuItemList("Элемент1"))
    list1.add (MenuItemList("Элемент2"))
 //   println(list1)
    list1.process()
}

open class NamedList<T> (val name: String) : ArrayList<T>() {
    override fun toString(): String {
        return name.toString() + super.toString()
    }
}
open class MenuItemList<T> (name: String) : NamedList<T>(name) {
    fun displayMenu(){
        println("\n$name:")
        println("0. Создать")
        //super.forEach { element -> println( element) }
        forEachIndexed  { index, element -> println("${index+1}. ${element}") }
        println("${size + 1}. Выход")
    }

    fun getUserInput(): Int{
        val scanner = Scanner(System.`in`)
        //var correctInput = false
        var input: String
        var iInput: Int = -1
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

    fun process() {
        do {
            var iInput = getUserInput()
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
        } while (true)
    }

    fun createNewItem() {
        val scanner = Scanner(System.`in`)
        var input = ""
        println("\nСоздание нового элемента")
        do {
            print("Введите имя: ")
            input = scanner.nextLine()!!
            if (input.length == 0) {
                println("\nОшибка!\nИмя не должно быть пустым!")
                continue
            }
            add(input)
            break
        } while (true)
    }

    private fun add(element: String) {
        // super.add(element)
    }
}

