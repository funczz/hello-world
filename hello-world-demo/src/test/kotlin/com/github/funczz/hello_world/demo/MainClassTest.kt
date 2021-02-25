package com.github.funczz.hello_world.demo

import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

internal class MainClassTest : StringSpec() {

    private val mainClass = MainClass()

    init {

        "get" {
            mainClass.get() shouldBe "hello world."
        }

    }

}