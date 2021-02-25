package com.github.funczz.hello_world.lib

import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

internal class HelloWorldTest : StringSpec() {


    private val helloWorld = HelloWorld()

    init {

        "get" {
            helloWorld.get() shouldBe "hello world."
        }

    }
}