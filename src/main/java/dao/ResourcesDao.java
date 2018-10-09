package dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entity.Resources;
import mapper.ResourcesMapper;
@Service
public class ResourcesDao {

	@Autowired
	ResourcesMapper resourceMapper;
	
	public void add(Resources resources){
		resourceMapper.add(resources);
	}
	
	public List<Resources> selectCategory(Resources resources){
	   return resourceMapper.selectCategory(resources);
		
	}
	public List<Resources> selectBoth(){
		
		return resourceMapper.selectBoth();
	}
	public List<Resources> selectCachapter(Resources resources){
		
		return resourceMapper.selectCachapter(resources);
	}
	
	public void delete(Resources resources){
		
		resourceMapper.delete(resources);
	}
	
    public void update(Resources resources){
		
		resourceMapper.update(resources);
	}
    public Resources updateResource(int id){
    	return resourceMapper.updateResource(id);
    }
}
