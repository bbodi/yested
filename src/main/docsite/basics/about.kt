package basics

import net.yested.bootstrap.row
import net.yested.bootstrap.pageHeader
import net.yested.div
import net.yested.Div
import net.yested.bootstrap.btsButton
import net.yested.bootstrap.ButtonLook
import net.yested.bootstrap.btsAnchor
import net.yested.bootstrap.ButtonSize
import net.yested.bootstrap.alert
import net.yested.bootstrap.AlertStyle

val latestVersion = "0.0.3"

fun aboutSection(): Div {

    return div {
        row {
            col(12) {
                pageHeader { h3 { +"What is Yested" } }
            }
        }
        row {
            col(6) {
                div {
                    p {
                        +"Yested is a Kotlin framework for building single-page web applications in Javascript."
                    }
                    p {
                        alert(style = AlertStyle.SUCCESS) {
                            +"This page is developed in Yested framework"
                            br()
                            a(href = "https://github.com/jean79/yested/tree/master/src/main/docsite") {
                                +"Check the source code for this site here!"
                            }
                        }
                    }
                    p {
                        h4 { +"Main features" }
                        ul {
                            li { +"Strongly typed development of Web applications" }
                            li { +"Minimalistic code" }
                            li { +"DSL for layout construction"}
                            li { +"Debugging within browser"}
                            li { +"Component style of development" }
                            li { +"Simple re-use of 3rd party Javascript libraries" }
                            li { +"Simple creation and re-use of custom components" }
                            li { +"Built-in support for Twitter Bootstrap for a quick start" }
                        }
                    }
                    br()
                    p {
                        h4 { +"What is missing"}
                        ul {
                            li { +"Data binding" }
                            li { +"HTML templates"}
                            p {
                                +"Let's wait for web components to do the difficult job for us. "
                                +"Fortunately DSL way of layout coding is almost as comfortable is HTML coding."
                            }
                        }
                    }
                }
            }
            col(6) {
                p {
                    btsAnchor(size = ButtonSize.LARGE, look = ButtonLook.PRIMARY, href = "https://github.com/jean79/yested") { +"Get on GitHub"}
                }
                p {
                    emph  { +"Binaries: "}
                    a(href = "http://jankovar.net:8081/nexus/content/repositories/releases/net/yested/Yested/${latestVersion}/Yested-${latestVersion}.jar") {
                        + "Yested-${latestVersion}.jar"
                    }
                }
                p {
                    h4 { +"Maven Repository" }
                    code(lang="xml", content =
"""<repository>
  <id>Yested</id>
  <url>http://jankovar.net:8081/nexus/content/repositories/releases/</url>
</repository>

<dependency>
    <groupId>net.yested</groupId>
    <artifactId>Yested</artifactId>
    <version>${latestVersion}</version>
</dependency>
""")
                }
            }
        }
    }

}