package org.apache.spi;

import org.apache.dubbo.common.extension.ExtensionLoader;
import org.junit.jupiter.api.Test;

import java.util.ServiceLoader;


/**
 * @author by Mr. Li 2020/11/21 14:44
 */
public class RobotTest {


    /**
     * java de SPI
     *
     * @throws Exception
     */
    @Test
    public void sayHello() throws Exception {
        ServiceLoader<Robot> serviceLoader = ServiceLoader.load(Robot.class);
        System.out.println("Java SPI");
        serviceLoader.forEach(Robot::sayHello);
    }

    /**
     * Dubbo 的SPI
     * <p>
     * Dubbo 的SPI文件中是以键值对的形式，这样方便根据类型进行初始化
     *
     * @throws Exception
     */
    @Test
    public void sayHelloByDubbo() throws Exception {
        // 1. 获取所有该类全路径目录下的所有扩展类型
        ExtensionLoader<Robot> extensionLoader = ExtensionLoader.getExtensionLoader(Robot.class);
        // 2. 根据类型加载 指定的扩展类
        System.out.println("Dubbo SPI");
        Robot optimusPrime = extensionLoader.getExtension("optimusPrime");
        optimusPrime.sayHello();
        Robot bumblebee = extensionLoader.getExtension("bumblebee");
        bumblebee.sayHello();
    }
}