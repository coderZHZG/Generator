package ${BasePackageName}${ServicePackageName};

import ${BasePackageName}${EntityPackageName}.${ClassName};

import java.util.HashMap;
import java.util.List;

/**
* Author ${Author}
* Date  ${Date}
*/
public interface ${ClassName}Service {

    //增
    public int insertSelective(${ClassName} ${EntityName});
    //批量新增
    public int insertSelectiveBatch(List<${ClassName}> ${EntityName}s);
    //查-列表
    public List<${ClassName}> findList(HashMap<String, Object> param);
    //查-总数
    public int findListCount(HashMap<String, Object> param);
    //查-byId
    public ${ClassName} findById(Integer id);
    //改
    public int updateSelective(${ClassName} ${EntityName});
    //删
    public int delete(${ClassName} ${EntityName});

}
