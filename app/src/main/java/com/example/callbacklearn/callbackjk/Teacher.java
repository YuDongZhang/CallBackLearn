package com.example.callbacklearn.callbackjk;


/**
 * 老师对象，原文出处http://www.cnblogs.com/xrq730/p/6424471.html
 * 定义一个老师对象，实现Callback接口：
 *
 * （1）回调接口tellAnswer(int answer)，即学生回答完毕问题之后，老师要做的事情
 * （2）问问题方法askQuestion()，即向学生问问题
 */
public class Teacher implements Callback {

    private XuSheng student;
    
    public Teacher(XuSheng student) {
        this.student = student;
    }
    
    public void askQuestion() {
        student.resolveQuestion(this);
    }

    //回调接口tellAnswer(int answer)，即学生回答完毕问题之后，老师要做的事情
    //即为接口中的方法,
    @Override
    public void tellAnswer(int answer) {
        System.out.println("知道了，你的答案是" + answer);
    }
    
}