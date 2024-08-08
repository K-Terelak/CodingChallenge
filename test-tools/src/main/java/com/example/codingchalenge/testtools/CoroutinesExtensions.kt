package com.example.codingchalenge.testtools

import app.cash.turbine.Event
import app.cash.turbine.ReceiveTurbine
import app.cash.turbine.TurbineContext
import app.cash.turbine.turbineScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.runCurrent
import kotlinx.coroutines.test.runTest
import kotlin.coroutines.CoroutineContext
import kotlin.time.Duration.Companion.seconds

interface CompoundTestScope : CoroutineScope, TurbineContext {
    fun runCurrent()
}

fun runCompoundTest(body: suspend CompoundTestScope.() -> Unit) = runTest(timeout = 3L.seconds) {
    turbineScope(timeout = 3L.seconds) {
        CompoundTestScopeImpl(
            testScope = this@runTest,
            turbineContext = this@turbineScope
        ).body()
    }
}

@OptIn(ExperimentalCoroutinesApi::class)
private class CompoundTestScopeImpl(
    private val testScope: TestScope,
    private val turbineContext: TurbineContext,
) : CompoundTestScope, TurbineContext by turbineContext {

    override val coroutineContext: CoroutineContext
        get() = testScope.coroutineContext

    override fun runCurrent() {
        testScope.runCurrent()
    }
}

suspend fun <T> ReceiveTurbine<T>.cancelAndConsumeItems(): List<T> = cancelAndConsumeRemainingEvents()
    .map { event ->
        if (event is Event.Item<T>) {
            event.value
        } else {
            throw AssertionError("Flow contains non-item event $event")
        }
    }
