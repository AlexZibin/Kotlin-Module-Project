import java.util.Scanner

open class MenuItemList(name: String) : NamedList<MenuItemList>(name) {
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

    fun process() {
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

    fun createNewItem() {
        val scanner = Scanner(System.`in`)
        var input: String
        println("\nСоздание нового элемента")
        do {
            print("Введите имя: ")
            input = scanner.nextLine()!!
            if (input.isEmpty()) {
                println("\nОшибка!\nИмя не должно быть пустым!")
                continue
            }
            add(MenuItemList(input))
            break
        } while (true)
    }
}
