package heroes

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.lang.IllegalArgumentException

class ArmyManagerTest {
    @Test
    fun stackContainsOnlyPositiveQuantityTest() {
        assertThrows<IllegalArgumentException> {
            Stack.of(-5, "Goblins")
        }
        Stack.of(2, "Goblins")
    }

    @Test
    fun armyIsNotTooLargeTest() {
        assertThrows<IllegalArgumentException> {
            Army.ofStacks(
                Stack.of(1, "Phoenix"),
                Stack.of(1, "Phoenix"),
                Stack.of(1, "Phoenix"),
                Stack.of(1, "Phoenix"),
                Stack.of(1, "Phoenix"),
                Stack.of(1, "Phoenix"),
                Stack.of(1, "Phoenix"),
                Stack.of(1, "Phoenix"),
            )
        }
        Army.ofStacks(
            Stack.of(1, "Phoenix"),
            Stack.of(1, "Phoenix"),
            Stack.of(1, "Phoenix"),
            Stack.of(1, "Phoenix"),
            Stack.of(1, "Phoenix"),
            Stack.of(1, "Phoenix"),
            Stack.of(1, "Phoenix"),
        )
    }

    @Test
    fun checkIfStacksAreAccurateTest() {
        val army = Army.ofStacks(
            Stack.of(1, "Phoenix"),
            Stack.of(1, "Phoenix"),
        )
        val expectedArray = arrayOf(
            Stack.of(1, "Phoenix"),
            Stack.of(1, "Phoenix"),
            null,
            null,
            null,
            null,
            null,
        )
        assertThat(army.stacks).isEqualTo(expectedArray)
    }


    @Test
    fun tryInsertAndMergeTest() {
        val gremlinStack = Stack.of(50, "Gremlins")
        val army = Army.ofStacks(
            Stack.of(120, "Gremlins")
        )
        val armyManager = ArmyManagerImpl()
        val armyAfterMerge = armyManager.tryInsertOrMergeStack(gremlinStack, army)
        assertThat(armyAfterMerge.stacks).isEqualTo(arrayOf(
            Stack.of(170, "Gremlins"),
            null,
            null,
            null,
            null,
            null,
            null,
        ))
    }
}