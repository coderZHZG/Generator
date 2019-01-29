package ${BasePackageName}${ServiceImpPackageName}.impl;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import ${BasePackageName}${DaoPackageName}.${ClassName}Dao;
import ${BasePackageName}${ServicePackageName}.${ClassName}Service;
import ${BasePackageName}${EntityPackageName}.${ClassName};

import java.util.HashMap;
import java.util.List;

/**
* Author ${Author}
* Date  ${Date}
*/
@Service("${EntityName}Service")
@Transactional
public class ${ClassName}ServiceImp implements ${ClassName}Service {

    @Autowired
    private ${ClassName}Dao ${EntityName}Dao;

    @Override
    public int insertSelective(${ClassName} ${EntityName}) {
    return ${EntityName}Dao.insertSelective(${EntityName});
    }

    @Override
    public int insertSelectiveBatch(List<${ClassName}> ${EntityName}s){
    return ${EntityName}Dao.insertSelectiveBatch(${EntityName}s);
    }

    @Override
    public List<${ClassName}> findList(HashMap<String, Object> param) {
    return ${EntityName}Dao.findList(param);
    }

    @Override
    public int findListCount(HashMap<String, Object> param) {
    return ${EntityName}Dao.findListCount(param);
    }

    @Override
    public ${ClassName} findById(Integer id){
        return ${EntityName}Dao.findById(id);
    }

    @Override
    public int updateSelective(${ClassName} ${EntityName}) {
        return ${EntityName}Dao.updateSelective(${EntityName});
    }

    @Override
    public int delete(${ClassName} ${EntityName}) {
        return ${EntityName}Dao.delete(${EntityName});
    }

}
