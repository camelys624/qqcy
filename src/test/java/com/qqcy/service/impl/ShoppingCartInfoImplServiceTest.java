package com.qqcy.service.impl;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.qqcy.po.ShoppingCartInfo;
import com.qqcy.po.User;
import com.qqcy.po.Vegetable;
import com.qqcy.service.ShoppingCartInfoService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class ShoppingCartInfoImplServiceTest {

	@Autowired
	private ShoppingCartInfoService shoppingCartInfoService;
	
	@Test
	public void testGetCartInfoListInConditions(){
		ShoppingCartInfo shoppingCartInfo = new ShoppingCartInfo();
		User user = new User();
		user.setU_id(1);
		shoppingCartInfo.setUser(user);
		Vegetable vegetable = new Vegetable();
		vegetable.setV_name("%绿色%");
		shoppingCartInfo.setVegetable(vegetable);
		List<ShoppingCartInfo> shoppingCartInfos = shoppingCartInfoService.getCartInfoListInConditions(shoppingCartInfo);
		for (ShoppingCartInfo info : shoppingCartInfos) {
			System.out.println("info.getShi_id() = " + info.getShi_id());
			System.out.println("info.getShi_vegenum() = " + info.getShi_vegenum());
			System.out.println("getU_id()) = " + info.getShi_status());
			System.out.println("info.getUser().getU_id() = " + info.getUser().getU_id());
			System.out.println("info.getVegetable().getV_id() = " + info.getVegetable().getV_id());
			System.out.println("info.getVegetable().getV_name() = " + info.getVegetable().getV_name());
			System.out.println("-----------------------------");
		}
	}
	
	@Test
	public void testIncrementVege_numAnDecrementVege_num(){
		ShoppingCartInfo shoppingCartInfo = new ShoppingCartInfo();
		User user = new User();
		user.setU_id(1);
		shoppingCartInfo.setUser(user);
		Vegetable vegetable = new Vegetable();
		vegetable.setV_id(1);
		shoppingCartInfo.setVegetable(vegetable);
//		shoppingCartInfoService.incrementVege_num(shoppingCartInfo);
		shoppingCartInfoService.decrementVege_num(shoppingCartInfo);
	}
	
	@Test
	public void testGetCartInfoList(){
		ShoppingCartInfo shoppingCartInfo = new ShoppingCartInfo();
		User user = new User();
		user.setU_id(1);
		shoppingCartInfo.setUser(user);
		List<ShoppingCartInfo> shoppingCartInfos = shoppingCartInfoService.getCartInfoList(shoppingCartInfo);
		for (ShoppingCartInfo info : shoppingCartInfos) {
			System.out.println("info.getShi_id() = " + info.getShi_id());
			System.out.println("info.getShi_vegenum() = " + info.getShi_vegenum());
			System.out.println("getU_id()) = " + info.getShi_status());
			System.out.println("info.getUser().getU_id() = " + info.getUser().getU_id());
			System.out.println("info.getVegetable().getV_id() = " + info.getVegetable().getV_id());
			System.out.println("info.getVegetable().getV_name() = " + info.getVegetable().getV_name());
			System.out.println("-----------------------------");
		}
	}

}
