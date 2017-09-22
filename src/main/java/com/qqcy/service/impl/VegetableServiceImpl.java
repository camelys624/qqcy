package com.qqcy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import com.qqcy.dao.SpeciesDao;
import com.qqcy.dao.VegetableDao;
import com.qqcy.po.Species;
import com.qqcy.po.Vegetable;
import com.qqcy.service.VegetableService;

/**
 * 蔬菜业务接口的实现类
 * @author Administrator
 *
 */
@Service
public class VegetableServiceImpl implements VegetableService {
	//一定要记住注入Dao类  要调试！！！！
	@Autowired
	private VegetableDao vegetableDao;
	@Autowired
	private SpeciesDao speciesDao;
	
	public void deleteVegetable(Vegetable vegetable) {
		vegetableDao.deleteVegetable(vegetable);
	}
		

	public void addVegetable(Vegetable vegetable) {
		vegetableDao.addVegetable(vegetable);
	}
	public List<Vegetable> getVegetableList(Vegetable vegetable) {
		
		if(vegetable.getV_name()!=null&&!vegetable.getV_name().equals(""))
		{
			vegetable.setV_name("%"+vegetable.getV_name()+"%");
		}
		List<Vegetable> vegetables=vegetableDao.getVegetableList(vegetable);
		//遍历每一个蔬菜，为他们设置种类名
		for(Vegetable v:vegetables)
		{
			Integer id=v.getSpecies().getSp_id();
			Species species=speciesDao.getSpeciesListById(id);
			v.setSpecies(species);
			
		}
		return vegetables;

	}
	
	public void updateVegetable(Vegetable vegetable) {
		
		vegetableDao.updateVegetable(vegetable);	
	}

	public Vegetable getVegetable(Vegetable vegetable) {
		
		return vegetableDao.getVegetable(vegetable);
	}

	public long getCount(Vegetable vegetable) {
		if(vegetable.getV_name()!=null&&!vegetable.getV_name().equals(""))
		{
			vegetable.setV_name("%"+vegetable.getV_name()+"%");
		}
		return vegetableDao.getCount(vegetable);
	}
	public Vegetable getVegetableById(Integer id) {
		
		return vegetableDao.getVegetableById(id);
	}


	public Vegetable getVegetableById(Vegetable vegetable) {
		return vegetableDao.getVegetableById(vegetable.getV_id());
	}

	public Vegetable getVegetableNumById(Integer id){
		
		return vegetableDao.getVegetableNumById(id);
	}
	public boolean validate(Vegetable vegetable){
		Vegetable pvegetable=vegetableDao.getVegetable(vegetable);
		if(pvegetable==null){
			return true;
		}
		return false;
	}
}
