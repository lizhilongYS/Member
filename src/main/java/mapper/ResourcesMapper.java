package mapper;

import java.util.List;

import entity.Resources;

public interface ResourcesMapper {
   public void add(Resources resources);
   public List<Resources> selectCategory(Resources resources);
   public void delete(Resources resources);
   public void update(Resources resources);
   public Resources updateResource(int id);
   public List<Resources> selectBoth();
   public List<Resources> selectCachapter(Resources resources);
}
