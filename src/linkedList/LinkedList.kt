package linkedList

data class SinglyNode<T>(val data: T?, var nextNode: SinglyNode<T>? = null)

class SinglyLinkedList<T> {

    private var head: SinglyNode<T>? = null

    private fun insertAtHead(data: T) : SinglyNode<T>? {
        val newNode = SinglyNode(data)
        if(head == null) {
            head = newNode
        } else {
            newNode.nextNode = head
            head = newNode
        }
        return head
    }

    fun insertAtTail(data: T) : SinglyNode<T>? {
        val newNode = SinglyNode(data)
        if(head == null) {
            head = newNode
        } else {
            var currentNode = head
            while(currentNode?.nextNode != null) {
                currentNode = currentNode.nextNode
            }
            currentNode?.nextNode = newNode
        }
        return head
    }

    fun insertAtPosition(data: T, position: Int) : SinglyNode<T>? {
        val newNode: SinglyNode<T> = SinglyNode(data)

        // Handle position 1 (insert at head)
        if (position == 1) {
            return insertAtHead(data)
        }

        if (head == null) {
            println("Position is out of bounds")
            return null
        } else {
            var currentNode = head
            var positionCounter = 1 // Start from position 1

            // Traverse the list until the desired position
            while (currentNode?.nextNode != null && positionCounter < position - 1) {
                currentNode = currentNode.nextNode
                positionCounter++
            }

            // If the position is valid, insert the node at the desired position
            if (currentNode == null || currentNode.nextNode == null && positionCounter < position - 1) {
                println("Position is out of bounds")
                return null
            }

            newNode.nextNode = currentNode.nextNode
            currentNode.nextNode = newNode
        }
        return head
    }

    fun deleteAtHead() {
        if (head != null) {
            head = head?.nextNode
        }
    }

    fun deleteAtTail() {
        if (head != null) {
            var currentNode = head
            while (currentNode?.nextNode?.nextNode != null) {
                currentNode = currentNode.nextNode
            }
            currentNode?.nextNode = null
        }
    }

    fun deleteAtPosition(position: Int) {
        if (head == null || position < 1) {
            println("Position is out of bounds or list is empty")
            return
        }

        if (position == 1) {
            deleteAtHead()  // Delete from the head if position is 1
        } else {
            var currentNode = head
            var positionCounter = 1 // Start from position 1

            // Traverse the list to find the node at position-1
            while (currentNode?.nextNode != null && positionCounter < position - 1) {
                currentNode = currentNode.nextNode
                positionCounter++
            }

            // If the position is valid, delete the node at the desired position
            if (currentNode?.nextNode == null) {
                println("Position is out of bounds")
            } else {
                currentNode.nextNode = currentNode.nextNode?.nextNode
            }
        }
    }

    fun getElementAt(position: Int): SinglyNode<T>? {
        if (position < 1 || head == null) {
            println("Invalid position or list is empty")
            return null
        }

        var currentNode = head
        var currentIndex = 1 // Start from position 1

        // Traverse the list until the desired position
        while (currentNode != null && currentIndex < position) {
            currentNode = currentNode.nextNode
            currentIndex++
        }

        // Return the node at the given position, or null if not found
        return currentNode
    }
}