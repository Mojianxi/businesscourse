package com.jjcw.course.utils;

/**
 * @Description TODO
 * @Author:liuxiaodong
 * @Date 2019/8/9 16:33
 * @Company jjcw
 */
public class Comm {
    // 有效
    public final static int MARK_YES = 1;
    // 无效
    public final static int MARK_NO = 8;

    // 报销单状态
    // 报销但作废
    public final static int EXPPENSE_STATE_DELETE = -5;
    // 报销单初始状态
    public final static int EXPPENSE_STATE_ZERO = 0;
    // 部门经理审核
    public final static int EXPPENSE_STATE_ONE = 1;
    // 部门经理审核不通过
    public final static int EXPPENSE_STATE_REONE = -1;
    // 部门经理审核通过,财务经理审核
    public final static int EXPPENSE_STATE_TWO = 2;
    // 财务经理审核不通过
    public final static int EXPPENSE_STATE_RETWO = -2;
    // 财务经理审核通过
    public final static int EXPPENSE_STATE_OK = 3;
}
