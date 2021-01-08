package com.example.xyy.test;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateUtil;
import com.example.xyy.test.utils.CopyObjectUtil;
import com.example.xyy.test.utils.TestModel;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * @author yayu
 * @title: DahtsysTest
 * @description: TODO
 * @date 2020/9/817:10
 */
public class DahtsysTest {
    public static void main(String[] args) {
        TestModel sourceModel = new TestModel();    //    第一个对象
        TestModel targetModel = new TestModel();    //    第二个model对象

        sourceModel.setProp1("1");
        sourceModel.setProp2("1");

        targetModel.setProp2("2");
        targetModel.setProp3("3");
        targetModel.setProp4("4");

//        DahtsysTest test = new DahtsysTest();
//        test.combineSydwCore(sourceModel, targetModel);
//        CopyObjectUtil.copyPropertiesIgnoreNull(sourceModel,targetModel);
        System.out.println(sourceModel);
        System.out.println(targetModel);
//        System.out.println(targetModel.toString());

    }


    private TestModel combineSydwCore(TestModel sourceBean, TestModel targetBean) {
        Class sourceBeanClass = sourceBean.getClass();
        Class targetBeanClass = targetBean.getClass();

        Field[] sourceFields = sourceBeanClass.getDeclaredFields();
        Field[] targetFields = targetBeanClass.getDeclaredFields();
        for (int i = 0; i < sourceFields.length; i++) {
            Field sourceField = sourceFields[i];
            if (Modifier.isStatic(sourceField.getModifiers())) {
                continue;
            }
            Field targetField = targetFields[i];
            if (Modifier.isStatic(targetField.getModifiers())) {
                continue;
            }
            sourceField.setAccessible(true);
            targetField.setAccessible(true);
            try {
                if (!(sourceField.get(sourceBean) == null) && !"serialVersionUID".equals(sourceField.getName().toString())) {
                    targetField.set(targetBean, sourceField.get(sourceBean));
                }
            } catch (IllegalArgumentException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return targetBean;
    }
}
