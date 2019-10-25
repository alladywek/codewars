package io.kotlintest.provided

import io.kotlintest.AbstractProjectConfig
import io.kotlintest.IsolationMode

object ProjectConfig: AbstractProjectConfig() {

    override fun parallelism(): Int = 4
    override fun isolationMode(): IsolationMode? = IsolationMode.SingleInstance
}