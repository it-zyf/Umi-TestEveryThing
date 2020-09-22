package com.example.xyy.simle;

import cn.hutool.extra.emoji.EmojiUtil;
import org.junit.Test;

/**
 * @author yayu
 * @title: EmojiTest
 * @description: TODO
 * @date 2020/9/2210:53
 */
public class EmojiTest {
    @Test
    public void test() {
        String alias = EmojiUtil.toAlias("😄");//:smile:
        System.out.println(alias);

        String emoji = EmojiUtil.toUnicode(":smile:");//😄
        System.out.println(emoji);

    }

}
