package logic

import org.junit.Assert.*
import org.junit.Test

class BeeperTest {
    @Test
    fun dropOneBeeper() {
        val beforeDrop = World.emptyWorld
        val afterDrop = beforeDrop.dropBeeper(1, 2)

        assertFalse(beforeDrop.beeperAt(1, 2))
        assertTrue(afterDrop.beeperAt(1, 2))
    }

    @Test(expected = CellIsFull::class)
    fun dropAnotherBeeper() {
        val one = World.emptyWorld.dropBeeper(1, 2)
        one.dropBeeper(1, 2)
    }

    @Test
    fun dropFourCornerBeepers() {
        val beforeDrop = World.emptyWorld
        val afterDrop = beforeDrop.dropBeeper(0, 0).dropBeeper(9, 0).dropBeeper(0, 9).dropBeeper(9, 9)

        assertEquals(0, beforeDrop.countBeepers())
        assertEquals(4, afterDrop.countBeepers())
    }

    @Test
    fun pickOneBeeper() {
        val beforePick = KarelWorld(0, 1, FloorPlan.empty)
        val afterPick = beforePick.pickBeeper(0, 0)

        assertTrue(beforePick.beeperAt(0, 0))
        assertFalse(afterPick.beeperAt(0, 0))
    }

    @Test(expected = CellIsEmpty::class)
    fun pickImaginaryBeeper() {
        World.emptyWorld.pickBeeper(0, 0)
    }
}
