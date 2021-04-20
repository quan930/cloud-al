package cn.lilq.cloudalibaba.cloudbookserver;

import cn.lilq.cloudalibaba.cloudcommon.CodeGenerator;

/**
 * @auther: Li Liangquan
 * @date: 2021/4/18 17:09
 */
public class Abc {
    public static void main(String[] args) {
        CodeGenerator.execute("localhost:5430","cloudbookserver","postgres");
    }
}
