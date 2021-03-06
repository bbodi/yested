package bootstrap

import net.yested.Div
import net.yested.bootstrap.TextInput
import net.yested.bootstrap.Validator
import net.yested.bootstrap.BtsButton
import net.yested.div
import net.yested.bootstrap.row
import net.yested.bootstrap.pageHeader
import net.yested.bootstrap.form
import net.yested.bootstrap.panel
import net.yested.bootstrap.PanelStyle

/**
 * Created by jean on 28.12.2014.
 */
fun createPanelSection(): Div {

    return div {
        row {
            col(12) {
                pageHeader { h3 { +"Panels" } }
            }
        }
        row {
            col(4) {
                div {
                    +"""
Please refer to Bootstrap Panels
"""
                }
                br()
                h4 { +"Demo" }

                panel(style = PanelStyle.SUCCESS) {
                    heading { +"Panel Header" }
                    content {
                        a(href="http://www.yested.net") { + "This site"}
                    }
                    footer { +"Panel Footer" }
                }

            }
            col(8) {
                h4 { +"Code" }
                code(lang = "kotlin", content="""panel {
    heading { +"Panel Header" }
    content {
        a(href="http://www.yested.net") { + "This site"}
    }
    footer { +"Panel Footer" }
}""")
            }
        }
    }

}