package com.li.youjiazhang;

import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import org.junit.Rule;
import org.junit.Test;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

/**
 * █████▒█    ██  ▄████▄   ██ ▄█▀       ██████╗ ██╗   ██╗ ██████╗
 * ▓██   ▒ ██  ▓██▒▒██▀ ▀█   ██▄█▒        ██╔══██╗██║   ██║██╔════╝
 * ▒████ ░▓██  ▒██░▒▓█    ▄ ▓███▄░        ██████╔╝██║   ██║██║  ███╗
 * ░▓█▒  ░▓▓█  ░██░▒▓▓▄ ▄██▒▓██ █▄        ██╔══██╗██║   ██║██║   ██║
 * ░▒█░   ▒▒█████▓ ▒ ▓███▀ ░▒██▒ █▄       ██████╔╝╚██████╔╝╚██████╔╝
 * ▒ ░   ░▒▓▒ ▒ ▒ ░ ░▒ ▒  ░▒ ▒▒ ▓▒       ╚═════╝  ╚═════╝  ╚═════╝
 * ░     ░░▒░ ░ ░   ░  ▒   ░ ░▒ ▒░
 * ░ ░    ░░░ ░ ░ ░        ░ ░░ ░
 * ░     ░ ░      ░  ░
 * ░
 * Created by lee on 2018/3/14 0014
 * <p/>
 * Description:  一个简单的单元测试用例，模拟控件点击，fragment之间的跳转
 * Author: lee
 * Update: lee(2018.03.14 14:37)
 */
public class MainActivityTest {

    /**
     * 测试规则，套路写法，表示将要测试的内容（button、textview点击事件等等）位于某一个页面或者从某一个页面开始
     */
    @Rule
    public ActivityTestRule rule = new ActivityTestRule<>(MainActivity.class);


    /**
     * 测试逻辑
     */
    @Test
    public void test(){

        //模拟两秒延迟
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //套路，根据id找到测试的控件，判断是否可见
        ViewInteraction myinforButton = onView(allOf(withId(R.id.myinfor), isDisplayed()));
        myinforButton.perform(click()); //模拟点击事件

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //根据控件文本内容找到控件并模拟点击
        ViewInteraction interactionButton = onView(allOf(withText("互动"),isDisplayed()));
        interactionButton.perform(click());

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        myinforButton.perform(click());

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        /**
         * 注意，必须保证测试的控件在当前页面直接找得到并且可见，不能在当前页面测试其他页面的控件，否则报错
         */
        ViewInteraction chooseClassButton = onView(allOf(withId(R.id.choose_course_class),isDisplayed()));
        chooseClassButton.perform(click());

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        ViewInteraction compusButton = onView(allOf(withId(R.id.campus), isDisplayed()));
        compusButton.perform(click());

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}