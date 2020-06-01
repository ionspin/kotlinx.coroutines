/*
 *  Copyright 2016-2020 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license.
 */
import org.junit.*
import kotlinx.coroutines.*
import kotlinx.coroutines.debug.*
import java.io.*

class DebugAgentTest {
    @Ignore("I need to set up proper JDK 18")
    @Test
    fun agentDumpsCoroutines() = runBlocking {
        val baos = ByteArrayOutputStream()
        DebugProbes.dumpCoroutines(PrintStream(baos))
        // if the agent works, then dumps should contain something,
        // at least the fact that this test is running.
        Assert.assertTrue(baos.toString().contains("agentDumpsCoroutines"))
    }

}
