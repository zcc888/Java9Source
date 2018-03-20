package com.sun.tools.doclint.resources;

public final class doclint_zh_CN extends java.util.ListResourceBundle {
    protected final Object[][] getContents() {
        return new Object[][] {
            { "dc.anchor.already.defined", "\u951A\u5B9A\u70B9\u5DF2\u5B9A\u4E49: \"{0}\"" },
            { "dc.anchor.value.missing", "\u6CA1\u6709\u4E3A\u951A\u5B9A\u70B9\u6307\u5B9A\u503C" },
            { "dc.attr.lacks.value", "\u5C5E\u6027\u7F3A\u5C11\u503C" },
            { "dc.attr.not.number", "\u5C5E\u6027\u503C\u4E0D\u662F\u6570\u5B57" },
            { "dc.attr.not.supported.html4", "\u5C5E\u6027\u5728 HTML4 \u4E2D\u4E0D\u53D7\u652F\u6301: {0}" },
            { "dc.attr.not.supported.html5", "\u5C5E\u6027\u5728 HTML5 \u4E2D\u4E0D\u53D7\u652F\u6301: {0}" },
            { "dc.attr.obsolete", "\u5C5E\u6027\u5DF2\u8FC7\u65F6: {0}" },
            { "dc.attr.obsolete.use.css", "\u5C5E\u6027\u5DF2\u8FC7\u65F6, \u8BF7\u6539\u7528 CSS: {0}" },
            { "dc.attr.repeated", "\u5C5E\u6027\u91CD\u590D: {0}" },
            { "dc.attr.table.border.html5", "\u8868\u7684\u5C5E\u6027\u8FB9\u6846\u53EA\u63A5\u53D7 \"\" \u6216 \"1\", \u6539\u4E3A\u4F7F\u7528 CSS: {0}" },
            { "dc.attr.unknown", "\u672A\u77E5\u5C5E\u6027: {0}" },
            { "dc.bad.option", "\u9009\u9879\u9519\u8BEF: {0}" },
            { "dc.bad.value.for.option", "\u9009\u9879\u7684\u503C\u9519\u8BEF: {0} {1}" },
            { "dc.empty", "@{0} \u6CA1\u6709\u8BF4\u660E" },
            { "dc.entity.invalid", "\u5B9E\u4F53 &{0}; \u65E0\u6548" },
            { "dc.exception.not.thrown", "\u672A\u629B\u51FA\u5F02\u5E38\u9519\u8BEF: {0}" },
            { "dc.exists.param", "\u5DF2\u6307\u5B9A @param \"{0}\"" },
            { "dc.exists.return", "\u5DF2\u6307\u5B9A @return" },
            { "dc.invalid.anchor", "\u951A\u5B9A\u70B9\u7684\u540D\u79F0\u65E0\u6548: \"{0}\"" },
            { "dc.invalid.param", "@param \u7684\u7528\u6CD5\u65E0\u6548" },
            { "dc.invalid.provides", "@provides \u7684\u7528\u6CD5\u65E0\u6548" },
            { "dc.invalid.return", "@return \u7684\u7528\u6CD5\u65E0\u6548" },
            { "dc.invalid.throws", "@throws \u7684\u7528\u6CD5\u65E0\u6548" },
            { "dc.invalid.uri", "URI \u65E0\u6548: \"{0}\"" },
            { "dc.invalid.uses", "@uses \u7684\u7528\u6CD5\u65E0\u6548" },
            { "dc.main.ioerror", "IO \u9519\u8BEF: {0}" },
            { "dc.main.no.files.given", "\u672A\u6307\u5B9A\u6587\u4EF6" },
            { "dc.main.usage", "\u7528\u6CD5:\n    doclint [options] source-files...\n\n\u9009\u9879:\n  -Xmsgs  \n    \u4E0E -Xmsgs:all \u76F8\u540C\n  -Xmsgs:values\n    \u6307\u5B9A\u8981\u68C0\u67E5\u7684\u95EE\u9898\u7684\u7C7B\u522B, \u5176\u4E2D ''values''\n    \u662F\u4EFB\u610F\u4EE5\u4E0B\u5185\u5BB9\u7684\u4EE5\u9017\u53F7\u5206\u9694\u7684\u5217\u8868:\n      reference      \u663E\u793A\u5305\u542B\u5BF9 Java \u6E90\u4EE3\u7801\u5143\u7D20\n                     \u9519\u8BEF\u5F15\u7528\u7684\u6CE8\u91CA\u7684\u4F4D\u7F6E\n      syntax         \u663E\u793A\u6CE8\u91CA\u4E2D\u7684\u57FA\u672C\u8BED\u6CD5\u9519\u8BEF\n      html           \u663E\u793A HTML \u6807\u8BB0\u548C\u5C5E\u6027\u95EE\u9898\n      accessibility  \u663E\u793A\u53EF\u8BBF\u95EE\u6027\u7684\u95EE\u9898\n      missing        \u663E\u793A\u7F3A\u5C11\u6587\u6863\u7684\u95EE\u9898\n      all            \u6240\u6709\u4EE5\u4E0A\u5185\u5BB9\n    \u5728\u503C\u4E4B\u524D\u4F7F\u7528 ''-'' \u53EF\u4F7F\u7528\u5176\u53CD\u503C\n    \u53EF\u4EE5\u4F7F\u7528\u4EE5\u4E0B\u4E00\u9879\u6765\u9650\u5B9A\u7C7B\u522B:\n      /public /protected /package /private\n    \u5BF9\u4E8E\u6B63\u7C7B\u522B (\u4E0D\u4EE5 ''-'' \u5F00\u5934)\n    \u9650\u5B9A\u7B26\u9002\u7528\u4E8E\u8BE5\u8BBF\u95EE\u7EA7\u522B\u53CA\u66F4\u9AD8\u7EA7\u522B\u3002\n    \u5BF9\u4E8E\u8D1F\u7C7B\u522B (\u4EE5 ''-'' \u5F00\u5934)\n    \u9650\u5B9A\u7B26\u9002\u7528\u4E8E\u8BE5\u8BBF\u95EE\u7EA7\u522B\u53CA\u66F4\u4F4E\u7EA7\u522B\u3002\n    \u5982\u679C\u6CA1\u6709\u9650\u5B9A\u7B26, \u5219\u8BE5\u7C7B\u522B\u9002\u7528\u4E8E\n    \u6240\u6709\u8BBF\u95EE\u7EA7\u522B\u3002\n    \u4F8B\u5982, -Xmsgs:all,-syntax/private\n    \u8FD9\u5C06\u5728\u4E13\u7528\u65B9\u6CD5\u7684\u6587\u6863\u6CE8\u91CA\u4E2D\n    \u542F\u7528\u9664\u8BED\u6CD5\u9519\u8BEF\u4E4B\u5916\u7684\u6240\u6709\u6D88\u606F\u3002\n    \u5982\u679C\u672A\u63D0\u4F9B -Xmsgs \u9009\u9879, \u5219\u9ED8\u8BA4\u503C\n    \u7B49\u540C\u4E8E -Xmsgs:all/protected, \u8868\u793A\n    \u4EC5\u62A5\u544A\u53D7\u4FDD\u62A4\u548C\u516C\u5171\u58F0\u660E\u4E2D\u7684\n    \u6240\u6709\u6D88\u606F\u3002\n  -XcheckPackage:<packages>\n    \u5728\u7279\u5B9A\u7684\u7A0B\u5E8F\u5305\u4E2D\u542F\u7528\u6216\u7981\u7528\u68C0\u67E5\u3002\n    <packages> \u662F\u9017\u53F7\u5206\u9694\u7684\u7A0B\u5E8F\u5305\u8BF4\u660E\u7B26\u5217\u8868\u3002\n    \u7A0B\u5E8F\u5305\u8BF4\u660E\u7B26\u662F\u7A0B\u5E8F\u5305\u7684\u9650\u5B9A\u540D\u79F0\n    \u6216\u7A0B\u5E8F\u5305\u540D\u79F0\u524D\u7F00\u540E\u8DDF ''.*'', \u5B83\u6269\u5C55\u5230\n    \u7ED9\u5B9A\u7A0B\u5E8F\u5305\u7684\u6240\u6709\u5B50\u7A0B\u5E8F\u5305\u3002\u5728\u7A0B\u5E8F\u5305\u8BF4\u660E\u7B26\u524D\u9762\n    \u52A0\u4E0A ''-'' \u53EF\u4EE5\u4E3A\u6307\u5B9A\u7A0B\u5E8F\u5305\u7981\u7528\u68C0\u67E5\u3002\n  -stats\n    \u62A5\u544A\u6240\u62A5\u544A\u95EE\u9898\u7684\u7EDF\u8BA1\u4FE1\u606F\u3002\n  -h -help --help -usage -?\n    \u663E\u793A\u6B64\u6D88\u606F\u3002\n\n\u8FD8\u652F\u6301\u4EE5\u4E0B javac \u9009\u9879\n  -bootclasspath, -classpath, -cp, -sourcepath, -Xmaxerrs, -Xmaxwarns\n\n\u8981\u5728\u9879\u76EE\u7684\u4E00\u90E8\u5206\u4E0A\u8FD0\u884C doclint, \u8BF7\u5C06\u9879\u76EE\u4E2D\u5DF2\u7F16\u8BD1\u7684\u7C7B\n\u653E\u5728\u7C7B\u8DEF\u5F84 (\u6216\u5F15\u5BFC\u7C7B\u8DEF\u5F84) \u4E0A, \u7136\u540E\u5728\u547D\u4EE4\u884C\u4E0A\u6307\u5B9A\n\u8981\u68C0\u67E5\u7684\u6E90\u6587\u4EF6\u3002" },
            { "dc.missing.comment", "\u6CA1\u6709\u6CE8\u91CA" },
            { "dc.missing.param", "{0}\u6CA1\u6709 @param" },
            { "dc.missing.return", "\u6CA1\u6709 @return" },
            { "dc.missing.throws", "{0}\u6CA1\u6709 @throws" },
            { "dc.no.alt.attr.for.image", "\u56FE\u50CF\u6CA1\u6709 \"alt\" \u5C5E\u6027" },
            { "dc.no.summary.or.caption.for.table", "\u8868\u6CA1\u6709\u6982\u8981\u6216\u6807\u9898" },
            { "dc.param.name.not.found", "@param name \u672A\u627E\u5230" },
            { "dc.ref.not.found", "\u627E\u4E0D\u5230\u5F15\u7528" },
            { "dc.service.not.found", "\u627E\u4E0D\u5230\u670D\u52A1\u7C7B\u578B" },
            { "dc.tag.code.within.code", "'{@code'} \u5728 <code> \u4E2D" },
            { "dc.tag.empty", "<{0}> \u6807\u8BB0\u4E3A\u7A7A" },
            { "dc.tag.end.not.permitted", "\u65E0\u6548\u7684\u7ED3\u675F\u6807\u8BB0: </{0}>" },
            { "dc.tag.end.unexpected", "\u610F\u5916\u7684\u7ED3\u675F\u6807\u8BB0: </{0}>" },
            { "dc.tag.header.sequence.1", "\u4F7F\u7528\u7684\u6807\u9898\u8D85\u51FA\u5E8F\u5217: <{0}>" },
            { "dc.tag.header.sequence.2", "\u4F7F\u7528\u7684\u6807\u9898\u8D85\u51FA\u5E8F\u5217: <{0}>" },
            { "dc.tag.nested.not.allowed", "\u4E0D\u5141\u8BB8\u4F7F\u7528\u5D4C\u5957\u6807\u8BB0: <{0}>" },
            { "dc.tag.not.allowed", "\u6587\u6863\u6CE8\u91CA\u4E2D\u4E0D\u5141\u8BB8\u4F7F\u7528\u5143\u7D20: <{0}>" },
            { "dc.tag.not.allowed.here", "\u6B64\u5904\u4E0D\u5141\u8BB8\u4F7F\u7528\u6807\u8BB0: <{0}>" },
            { "dc.tag.not.allowed.inline.element", "\u5185\u5D4C\u5143\u7D20 <{1}> \u4E2D\u4E0D\u5141\u8BB8\u4F7F\u7528\u5757\u5143\u7D20: {0}" },
            { "dc.tag.not.allowed.inline.other", "\u6B64\u5904\u4E0D\u5141\u8BB8\u4F7F\u7528\u5757\u5143\u7D20: {0}" },
            { "dc.tag.not.allowed.inline.tag", "@{1} \u4E2D\u4E0D\u5141\u8BB8\u4F7F\u7528\u5757\u5143\u7D20: {0}" },
            { "dc.tag.not.closed", "\u5143\u7D20\u672A\u5173\u95ED: {0}" },
            { "dc.tag.not.supported", "\u6807\u8BB0\u5728\u751F\u6210\u7684 HTML \u7248\u672C\u4E2D\u4E0D\u53D7\u652F\u6301: {0}" },
            { "dc.tag.p.in.pre", "<pre> \u5143\u7D20\u5185\u90E8\u610F\u5916\u5730\u4F7F\u7528\u4E86 <p>" },
            { "dc.tag.requires.heading", "\u672A\u627E\u5230 </{0}> \u7684\u6807\u9898" },
            { "dc.tag.self.closing", "\u4E0D\u5141\u8BB8\u4F7F\u7528\u81EA\u5173\u95ED\u5143\u7D20" },
            { "dc.tag.start.unmatched", "\u7F3A\u5C11\u7ED3\u675F\u6807\u8BB0: </{0}>" },
            { "dc.tag.unknown", "\u672A\u77E5\u6807\u8BB0: {0}" },
            { "dc.text.not.allowed", "<{0}> \u5143\u7D20\u4E2D\u4E0D\u5141\u8BB8\u4F7F\u7528\u6587\u672C" },
            { "dc.type.arg.not.allowed", "\u6B64\u5904\u4E0D\u5141\u8BB8\u4F7F\u7528\u7C7B\u578B\u53C2\u6570" },
            { "dc.unexpected.comment", "\u6B64\u5904\u672A\u9884\u671F\u6587\u6863\u6CE8\u91CA" },
            { "dc.value.not.a.constant", "\u503C\u4E0D\u5F15\u7528\u5E38\u91CF" },
            { "dc.value.not.allowed.here", "\u6B64\u5904\u4E0D\u5141\u8BB8\u4F7F\u7528 '{@value}'" },
        };
    }
}
