package com.fisher.annotation.ioc.component;

import com.fisher.annotation.ioc.component.controller.SoldierController;
import com.fisher.annotation.ioc.component.repository.SoldierDao;
import com.fisher.annotation.ioc.component.service.SoldierService;
import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * IoC 容器中获取bean
 * @author fisher
 * @version 1.0.1 2023/6/5 - 18:54
 */
@Slf4j
public class CommonComponentTest extends TestCase {

    private ApplicationContext iocContainer = new ClassPathXmlApplicationContext("applicationContext.xml");

    @Test
    public void testAnnotationcScanBean() {
        CommonComponent commonComponent = iocContainer.getBean(CommonComponent.class);

        SoldierController soldierController = iocContainer.getBean(SoldierController.class);

        SoldierService soldierService = iocContainer.getBean(SoldierService.class);

        SoldierDao soldierDao = iocContainer.getBean(SoldierDao.class);

        log.debug("commonComponent = " + commonComponent);
        log.debug("soldierController = " + soldierController);
        log.debug("soldierService = " + soldierService);
        log.debug("soldierDao = " + soldierDao);
    }
}