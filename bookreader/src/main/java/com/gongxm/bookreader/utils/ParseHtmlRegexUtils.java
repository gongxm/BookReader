package com.gongxm.bookreader.utils;

import com.gongxm.bookreader.bean.ParseHtmlRegex;
import com.gongxm.bookreader.database.ParseHtmlRegexDao;

/**
 * Created by gongxm on 2017/8/1.
 */

public class ParseHtmlRegexUtils {
    public static void addRegex() {
        ParseHtmlRegexDao dao = ParseHtmlRegexDao.getInstance();
        dao.addRegex(new ParseHtmlRegex("luoqiu.com", "<div id=\"content\" name=\"content\">", "<script>read_select_do();</script>"));
        dao.addRegex(new ParseHtmlRegex("sanjiangge.com", "<div id=\"content\" name=\"content\">", "<div class=\"bottem\">"));
        dao.addRegex(new ParseHtmlRegex("79xs.com", "<div class=\"wrapper_main\">", "<div class=\"button_con\">"));
        dao.addRegex(new ParseHtmlRegex("book.qidian.com", "<div class=\"read-content j_readContent\">", "<div class=\"admire-wrap\">"));
        dao.addRegex(new ParseHtmlRegex("hunhun520.com", "<div id=\"content\">", "<div class=\"mb_29b\">"));
        dao.addRegex(new ParseHtmlRegex("book.zongheng.com", "<div id=\"readerFs\" class=\"\">", "<div id=\"dynamicUp\">"));
        dao.addRegex(new ParseHtmlRegex("leduwo.com", "<div id=\"content\">", "<div id=\"adbottom\">"));

        //有乱码
        dao.addRegex(new ParseHtmlRegex("xiaoxiaoshuwu.com", "<div id=\"chapterContent\" >", "<div class=\"style_sidebar\">"));
    }
}
