package net.yested.bootstrap

import jquery.JQuery
import net.yested.HTMLParentComponent
import net.yested.div
import net.yested.Div
import net.yested.with
import jquery.jq

public native fun JQuery.modal(options: String):Unit = noImpl;

/**
 * <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                <h4 class="modal-title" id="myModalLabel">Modal title</h4>
            </div>
            <div class="modal-body">
            ...
            </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary">Save changes</button>
                </div>
            </div>
        </div>
    </div>
 */

public class Dialog {

    var dialog:Div? = null
    var header: Div? = null
    var body: Div? = null
    var footer: Div? = null

    fun header(init: HTMLParentComponent.() -> Unit) {

        header = div(clazz = "modal-header") {
            tag("button") { clazz = "close"; "type".."button"; "data-dismiss".."modal"
                span {
                    "aria-hidden".."true"
                    +Glyphicon("remove");
                }
                span(clazz = "sr-only") {
                    + "Close"
                }
            }
            tag("h4") { clazz = "modal-title"} with { init() }
        }

    }

    fun body(init: HTMLParentComponent.() -> Unit) {
        body = div(clazz = "modal-body", init = init)
    }

    fun footer(init: HTMLParentComponent.() -> Unit) {
        footer = div(clazz = "modal-footer", init = init)
    }

    fun open() {
        dialog = div(clazz = "modal fade") { "aria-hidden".."true"; role = "dialog"
            div(clazz = "modal-dialog") {
                div(clazz = "modal-content") {
                    + header!!
                    + body!!
                    footer?.let { + footer!! }
                }
            }
        }
        jq(dialog!!.element).modal("show")
    }

    fun close() {
        dialog?.let {
            jq(dialog!!.element).modal("hide")
        }
    }

}
