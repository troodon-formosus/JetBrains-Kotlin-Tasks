package heroes

data class Stack private constructor(val quantity: Int, val name: String) {
    companion object {
        fun of(quantity: Int, name: String): Stack {
            if (quantity < 1) throw IllegalArgumentException("Quantity must be greater than 0!")
            return Stack(quantity, name)
        }
    }
}

class Army private constructor(val stacks: Array<Stack?>) {

    //val stacks = Array<Stack?>(7) { null }

    companion object {
        fun ofStacks(vararg initialStacks: Stack): Army {
            if (initialStacks.size > 7) throw IllegalArgumentException("No more than 7 stacks are allowed!")
            val actualStacks = Array<Stack?>(7) { null }
            for (i in initialStacks.indices) {
                actualStacks[i] = initialStacks[i]
            }
            return Army(actualStacks)
        }
    }
}

interface ArmyManager {
    fun tryInsertOrMergeStack(stack: Stack, army: Army)
}

class ArmyManagerImpl () {

}