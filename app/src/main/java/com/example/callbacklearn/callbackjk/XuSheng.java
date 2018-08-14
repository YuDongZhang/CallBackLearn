package com.example.callbacklearn.callbackjk;

/**
 * 学生接口，原文出处http://www.cnblogs.com/xrq730/p/6424471.html
 * 接着定义一个学生接口，学生当然是解决问题，但是接收一个Callback参数，这样学生就知道解决完毕问题向谁报告：
 */
public interface XuSheng {
    
    public void resolveQuestion(Callback callback);
    
}