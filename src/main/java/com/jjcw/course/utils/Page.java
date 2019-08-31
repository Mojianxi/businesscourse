package com.jjcw.course.utils;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description TODO
 * @Author:liuxiaodong
 * @Date 2019/8/9 16:35
 * @Company jjcw
 */
public class Page {
    /**
     * 起始记录数
     */
    private int pageNo = 0;


    /**
     * 每页显示记录数
     */
    public final static  int PAGE_NUM_BIG = 10;

    /**
     * 初始化分页信息
     */
    public void initPage(HttpServletRequest request){
        String page_str = request.getParameter("pager.offset");
        if(page_str!=null && !page_str.equals("")){
            pageNo = Integer.parseInt(page_str);
        }
    }
    public int getPageNo() {
        return pageNo;
    }
    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }
    public static int getPageNumBig() {
        return PAGE_NUM_BIG;
    }
}
