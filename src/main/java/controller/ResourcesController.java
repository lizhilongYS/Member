package controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import dao.CourseDAO;
import dao.ResourcesDao;
import entity.Category;
import entity.Course;
import entity.Resources;
import tools.Result;
@Controller
@RequestMapping("/resources")
public class ResourcesController {
   
	@Autowired
	ResourcesDao resourcesDao;
	@Autowired
	CourseDAO courseDAO;
	
	@ResponseBody
	@RequestMapping("/add.action")
	public String add(Resources resources,HttpSession session){
		resourcesDao.add(resources);
		session.setAttribute("updateResource", resources);
		
			return null;
	}
	
	
	
	@ResponseBody
	@RequestMapping("/initDate.action")
	public List<Resources> initDate(HttpSession session){
		//!null表示修改，否则新增
		if(session.getAttribute("updateResource")!=null){
			Resources res = (Resources) session.getAttribute("updateResource");
			return resourcesDao.selectCachapter(res);
		}
		//页面刚启动时updateResource为空
		session.setAttribute("both", resourcesDao.selectBoth());
		return resourcesDao.selectBoth();
	}
	
	
	
	
	@ResponseBody
	@RequestMapping("/selectCategory.action")
	public List<Course> selectCategory(int num,HttpSession session){
		//此处返回的是二级菜单的数据
		List<Course> getcachapter = courseDAO.getcachapter(num);
		return getcachapter;
	}
	
	@RequestMapping("/cachapter.action")
	@ResponseBody
	public Result selectCachapter(Resources resources,@RequestParam(defaultValue = "1")Integer pages,@RequestParam(defaultValue = "10") Integer rows){
		PageHelper.startPage(pages, rows);
		List<Resources> list;
		PageInfo<Resources> pageInfo;
		if(resources.getTitle()!=0){
			list = resourcesDao.selectCachapter(resources);
			pageInfo =new PageInfo<>(list);
			//数据，当前页，总页数
			return Result.ok(list, pageInfo.getPageNum(), pageInfo.getPages());
		}
		list=category(resources);
		pageInfo=new PageInfo<>(list);
		return Result.ok(list,pageInfo.getPageNum(),pageInfo.getPages());
	}
	
	
	@ResponseBody
	@RequestMapping("/initCategory.action")
	public List<Category> initCategory(HttpSession session){
		session.setAttribute("getcategory", courseDAO.getcategory());
		return courseDAO.getcategory();
	}
	@ResponseBody
	@RequestMapping("/initCachapter.action")
	public List<Course> initCachapter(Resources resources,HttpSession session){
		session.setAttribute("getcachapter", courseDAO.getcachapter(7));
		return courseDAO.getcachapter(7);
	}
	@ResponseBody
	@RequestMapping("/category.action")
	public List<Resources> category(Resources resources){
		
		return resourcesDao.selectCategory(resources);
	}
	@ResponseBody
	@RequestMapping("/update1.action")
	public String update1(int id,HttpSession session){
		@SuppressWarnings("unchecked")
		   List<Resources> resources = (List<Resources>) session.getAttribute("both");
		   List<Course> chapters = courseDAO.getChapters();
		   session.setAttribute("chapters", chapters);
		for (Resources res : resources) {
			if(res.getId()==id){
				System.out.println(res);
				session.setAttribute("updateResource", res);
				return null;
			}
		}
		session.setAttribute("updateResource", resourcesDao.updateResource(id));
		return null;
	}
	@ResponseBody
	@RequestMapping("/update2.action")
	public String update2(Resources resources,HttpSession session){
		Resources r = (Resources) session.getAttribute("updateResource");
		resources.setId(r.getId());
		resourcesDao.update(resources);
		session.setAttribute("updateResource", resources);
		return null;
		
		
	}
	@ResponseBody
	@RequestMapping("/delete.action")
	public List<Resources> delete(Resources resources ,HttpSession session){
		Resources updateResource = resourcesDao.updateResource(resources.getId());
		resourcesDao.delete(updateResource);
		return resourcesDao.selectCachapter(updateResource);
		
	}
	public List<Resources> selectBoth(){
		return resourcesDao.selectBoth();
	}
	
	
	
}
