import net.yested.bootstrap.page
import net.yested.bootstrap.CheckBox
import net.yested.bootstrap.btsButton
import net.yested.bootstrap.ButtonLook
import net.yested.bootstrap.ButtonSize
import net.yested.text
import net.yested.bootstrap.row
import net.yested.bootstrap.Navbar
import net.yested.bootstrap.navbar
import net.yested.registerHashChangeListener
import net.yested.div
import bootstrap.boostrapPage
import basics.basicPage
import html.htmlPage
import ajax.ajaxPage
import complex.masterDetail
import gettingstarted.gettingStartedSection

fun main(args: Array<String>) {

    val navbar = navbar {
        brand(href = "#") { +"Yested" }
        item(href = "#/gettingstarted") { +"Getting Started" }
        dropdown(label = { +"Examples" }) {
            item(href = "#/html") { +"Basic HTML" }
            item(href = "#/bootstrapComponents") { +"Twitter Bootstrap" }
            item(href = "#/ajax") { +"Ajax Call" }
            item(href = "#/masterdetail") { +"Master/Detail"}
        }
    }

    val divContainer = div {}

    registerHashChangeListener {
        hash ->
        when {
            hash.size() == 1  -> divContainer.fade(basicPage())
            hash.get(1) == "gettingstarted" -> divContainer.fade(gettingStartedSection())
            hash.get(1) == "html" -> divContainer.fade(htmlPage())
            hash.get(1) == "bootstrapComponents" -> divContainer.fade(boostrapPage())
            hash.get(1) == "ajax" -> divContainer.fade(ajaxPage())
            hash.get(1) == "masterdetail" -> divContainer.fade(masterDetail())
        }
    }

    page("page") {
        topMenu(navbar)
        content {
            div {
                br(); br();
                +divContainer
            }
        }
        footer {
            small {
                emph { +"Contact: " }
                a(href = "mailto:jan.kovar79@gmail.com") { +"jan.kovar79@gmail.com" }
            }
            br(); br()
        }
    }

}