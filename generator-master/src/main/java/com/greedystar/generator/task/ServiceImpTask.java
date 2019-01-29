package com.greedystar.generator.task;

import com.greedystar.generator.task.base.BaseTask;
import com.greedystar.generator.utils.ConfigUtil;
import com.greedystar.generator.utils.FileUtil;
import com.greedystar.generator.utils.FreemarketConfigUtils;
import com.greedystar.generator.utils.StringUtil;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Author GreedyStar
 * Date   2018/4/20
 */
public class ServiceImpTask extends BaseTask {

    public ServiceImpTask(String className) {
        super(className);
    }

    @Override
    public void run() throws IOException, TemplateException {
        // 生成Service填充数据
        System.out.println("Generating " + className + "ServiceImp.java");
        Map<String, String> serviceData = new HashMap<>();
        serviceData.put("BasePackageName", ConfigUtil.getConfiguration().getPackageName());
        serviceData.put("ServiceImpPackageName", ConfigUtil.getConfiguration().getPath().getService());
        serviceData.put("ServicePackageName", ConfigUtil.getConfiguration().getPath().getService());
        serviceData.put("EntityPackageName", ConfigUtil.getConfiguration().getPath().getEntity());
        serviceData.put("DaoPackageName", ConfigUtil.getConfiguration().getPath().getDao());
        serviceData.put("Author", ConfigUtil.getConfiguration().getAuthor());
        serviceData.put("Date", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        serviceData.put("ClassName", className);
        serviceData.put("EntityName", StringUtil.firstToLowerCase(className));
        String filePath = FileUtil.getSourcePath() + StringUtil.package2Path(ConfigUtil.getConfiguration().getPackageName()) + StringUtil.package2Path(ConfigUtil.getConfiguration().getPath().getServiceImp());
        String fileName = className + "ServiceImp.java";
        // 生成ServiceImp文件
        FileUtil.generateToJava(FreemarketConfigUtils.TYPE_SERVICE_IMP, serviceData, filePath + fileName);
    }
}
