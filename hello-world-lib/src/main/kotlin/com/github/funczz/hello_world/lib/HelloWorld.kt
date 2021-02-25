package com.github.funczz.hello_world.lib

/**
 * hello-world ライブラリ
 * @author funczz
 */
class HelloWorld : IGreeting {

    /**
     * 文字列 <pre>"hello world."</pre> を返す
     * @return 文字列
     */
    override fun get(): String = "hello world."

}