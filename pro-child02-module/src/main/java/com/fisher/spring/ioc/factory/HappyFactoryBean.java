package com.fisher.spring.ioc.factory;

import com.fisher.spring.ioc.component.HappyMachine;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.FactoryBean;

/**
 * 实现FactoryBean`<`T`>`接口的组件
 * 泛型类型就是当前工厂要生产的对象类型
 * @author fisher
 * @version 1.0.1 2023/6/5 - 16:31
 */
@Setter
@Getter
public class HappyFactoryBean extends HappyMachine implements FactoryBean<HappyMachine> {

    private String machineName;

    @Override
    public HappyMachine getObject() {
        // 方法内部模拟创建、设置一个对象的复杂过程
        HappyMachine happyMachine = new HappyMachine();
        happyMachine.setHappyMachineName(this.machineName);
        return happyMachine;
    }

    @Override
    public Class<?> getObjectType() {
        //返回要生产的对象的类型
        return HappyMachine.class;
    }
}
