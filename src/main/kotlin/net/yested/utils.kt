package net.yested

import org.w3c.dom.Element
import kotlin.js.dom.html.document

public fun <T> T.with(init:T.()->Unit):T {
    this.init()
    return this
}

/**
 * Lookup element on a html page
 */
fun el(elementId:String):Element {
    return document.getElementById(elementId);
}

fun printMarkup(content:String):String =
    content.replaceAll("<", "&lt;").replaceAll(">", "&gt;")
