import org.testng.AssertJUnit.assertEquals
import org.testng.annotations.Test
import java.util.LinkedList
import java.awt.List

class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        val target = ListClass<Any>()
        val test = LinkedList<Any>()

        target.insert(0, 1)
        target.insert(1, 2)
        target.insert(2, 3)
        target.insert(3, 4)

        test.add(1)
        test.add(2)
        test.add(3)
        test.add(4)

        assertEquals(test.size, target.size())

        target.remove(2)
        test.remove(2)

        assertEquals(test.size, target.size())
        assertEquals(test.get(2), target.get(2))

        target.insert(0, 5)

        test.add(0, 5)

        assertEquals(test.size, target.size())
        assertEquals(test.get(0), target.get(0))

        target.poll()
        target.print()
        test.poll()

        assertEquals(test.size, target.size())
        assertEquals(test.get(0), target.get(0))

    }
}

class Node<T>(
    val data: T,
    var next: Node<T>? = null, var previous: Node<T>? = null
)

class ListClass<T>: SimpleList {

    private var head: Node<Any>? = null
    private val firstIndex: Int = 0
    private var lastIndex: Int = 0

    override fun insert(index: Int, item: Any) {
        val newNode = Node(item)
        if (head == null) {
            head = newNode
            lastIndex = 0
        } else if(index == 0) {
            val currentHead = head
            newNode.next = currentHead
            currentHead?.previous = newNode
            head = newNode
            lastIndex++
        }else {
            var current = head
            while (current?.next != null) {
                current = current.next
                lastIndex = index
            }
            current?.next = newNode
        }
    }

    override fun get(index: Int): Any? {
        var current = head

        if (index > lastIndex) return null
        if (index <= lastIndex) {
            repeat(index) {
                current = current?.next
            }
        }

            return current?.data

    }

    override fun size(): Int { return lastIndex + 1 }

    override fun remove(item: Any): Any? {
        if (head == null) return print("No such item is present")

        if (head?.data == item || item == firstIndex) {
            head = head?.next
            lastIndex--
            return item
        }

        var current = head
        while (current?.next != null) {
            if (current.next?.data == item) {
                current.previous = current.next
                current.next = current.next?.next
                lastIndex--
                println("removed $item from the list")
                return item
            }
            println("failed to remove $item in this iteration, it was ${current.next?.data}")
            current = current.next
        }
        return null
    }

    override fun pop() {
        remove(0)
    }

    override fun poll() {
        if (head != null) {
            remove(0)
        } else {
            head = null
        }
    }

    fun print() {
        var current = head
        print(size())
        print("[")
        while (current != null) {
            print("${current.data}")
            if (current.next != null) {
                print(", ")
            } else {
                print("]\n")
                return
            }
            current = current.next
        }
    }
}

interface SimpleList {

    fun insert(index: Int, item: Any)

    fun get(index: Int): Any? // return null if there's no item at this index or index is out of bounds.

    fun size(): Int

    fun remove(item: Any): Any? // return null if there's no item to be removed, else - removed item

    fun pop()

    fun poll()
}
