package net.yested.bootstrap

import net.yested.ParentComponent
import net.yested.HTMLParentComponent
import net.yested.Div
import net.yested.with
import net.yested.bootstrap.ButtonSize

public enum class PanelStyle(val code:String) {
    DEFAULT : PanelStyle("default")
    PRIMARY : PanelStyle("primary")
    SUCCESS : PanelStyle("success")
    INFO : PanelStyle("info")
    WARNING : PanelStyle("warning")
    DANGER : PanelStyle("danger")
}

public class Panel(style : PanelStyle = PanelStyle.DEFAULT) : ParentComponent("div") {

    private val heading = Div() with { clazz = "panel-heading" }
    private val body = Div() with { clazz = "panel-body" }
    private val footer = Div() with { clazz = "panel-footer" }

    {
        setAttribute("class", "panel panel-${style.code}")
        add(heading)
        add(body)
    }

    public fun heading(init: HTMLParentComponent.() -> Unit) {
        heading.init()
    }

    public fun content(init: HTMLParentComponent.() -> Unit) {
        body.init()
    }

    public fun footer(init: HTMLParentComponent.() -> Unit) {
        footer.init()
        add(footer)
    }

}

public fun HTMLParentComponent.panel(style:PanelStyle = PanelStyle.DEFAULT, init:Panel.() -> Unit) {
    val panel = Panel(style = style)
    panel.init()
    add(panel)
}
