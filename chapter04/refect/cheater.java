package chapter04.refect;

import chapter04.refect.GuessingGame;

import java.lang.reflect.Field;

public class cheater {
    public static void main(String[] args) throws Exception {
        // 使用反射获取 secretNumber 字段
        Field secretNumberField = GuessingGame.class.getDeclaredField("secretNumber");
        secretNumberField.setAccessible(true); // 设置为可访问

        // 创建一个新线程来猜测答案

        Thread guessingThread = new Thread(() -> {

        });

        // 启动猜测线程
        guessingThread.start();
    }

    // 这是一个示例的猜测逻辑
    private static int makeGuess() {
        return (int) (Math.random() * 101); // 随机生成一个猜测
    }
}
