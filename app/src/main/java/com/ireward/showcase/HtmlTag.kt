package com.ireward.showcase

enum class HtmlTag(val tag: String, val content: String) {
    SUP(
        tag = "<sup>",
        content = "This is a <sup>sup element</sup>"
    ),
    SUB(
        tag = "<sub>",
        content = "This is a <sub>sub element</sub>"
    ),
    STRIKE(
        tag = "<strike>",
        content = "This is a <strike>s element</strike>"
    ),
    S(
        tag = "<s>",
        content = "This is a <s>s element</s>"
    ),
    DEL(
        tag = "<del>",
        content = "This is a <del>del element</del>"
    ),
    U(
        tag = "<u>",
        content = "This is a <u>u element</u>"
    ),
    TT(
        tag = "<tt>",
        content = "This is a <tt>tt element</tt>"
    ),
    BLOCKQUOTE(
        tag = "<blockquote>",
        content = "This is a <blockquote>blockquote element</blockquote>"
    ),
    FONT(
        tag = "<font>",
        content = """This is a <font color="#7BB5D6" face="casual">font element</font>"""
    ),
    SMALL(
        tag = "<small>",
        content = "This is a <small>small element</small>"
    ),
    BIG(
        tag = "<big>",
        content = "This is a <big>big element</big>"
    ),
    I(
        tag = "<i>",
        content = "This is a <i>i element</i>"
    ),
    DFN(
        tag = "<dfn>",
        content = "This is a <dfn>dfn element</dfn>"
    ),
    CITE(
        tag = "<cite>",
        content = "This is a <cite>cite element</cite>"
    ),
    EM(
        tag = "<em>",
        content = "This is an <em>em element</em>"
    ),
    B(
        tag = "<b>",
        content = "This is a <b>b element</b>"
    ),
    STRONG(
        tag = "<strong>",
        content = "This is a <strong>strong element</strong>"
    ),
    SPAN(
        tag = "<span>",
        content = """This is a <span style="color: #7BB5D6;">blue span</span>"""
    ),
    DIV(
        tag = "<div>",
        content = "<div>This is a div.<div>This is another div.</div>"
    ),
    A(
        tag = "<a>",
        content = """This is an <a href="https://play.google.com/store">a element</a>"""
    ),
    UL(
        tag = "<ul>",
        content = "<ul><li><h4>List item</h4></li><li><h5>List item</h5></li><li><h6>List item</h6></li></ul>"
    ),
    P(
        tag = "<p>",
        content = "<p>This is a paragraph.</p><p>This is another paragraph.</p><p>This is the last paragraph.</p>"
    ),
    BR(
        tag = "<br>",
        content = "This is a line.<br>This is another line.<br>This is the last line."
    ),
    H1(
        tag = "<h1>",
        content = "<h1>This is h1</h1>"
    ),
    H2(
        tag = "<h2>",
        content = "<h2>This is h2</h2>"
    ),
    H3(
        tag = "<h3>",
        content = "<h3>This is h3</h3>"
    ),
    H4(
        tag = "<h4>",
        content = "<h4>This is h4</h4>"
    ),
    H5(
        tag = "<h5>",
        content = "<h5>This is h5</h5>"
    ),
    H6(
        tag = "<h6>",
        content = "<h6>This is h6</h6>"
    ),
    Z(
        tag = "mix",
        content = """
<p>Pellentesque habitant <b>morbi tristique senectus</b> et netus et <i>malesuada fames</i> ac turpis egestas.</p>
<p>Pellentesque habitant <sup>morbi tristique senectus</sup> et netus et <strong>malesuada fames</strong> ac turpis egestas.</p>
<ul>
   <li><h4>Lorem ipsum dolor sit amet, consectetuer adipiscing elit.</h4></li>
   <li><h5>Aliquam tincidunt mauris eu risus.</h5></li>
   <li><h6>Vestibulum auctor dapibus neque.</h6></li>
</ul>
""".trimIndent()
    )
}

