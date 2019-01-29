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
public class ServiceTask extends BaseTask {

    public ServiceTask(String className) {
        super(className);
    }

    @Override
    public void run() throws IOException, TemplateException {
        // 生成Service填充数据
        System.out.println("Generating " + className + "Service.java");
        Map<String, String> serviceImpData = new HashMap<>();
        serviceImpData.put("BasePackageName", ConfigUtil.getConfiguration().getPackageName());
        serviceImpData.put("ServicePackageName", ConfigUtil.getConfiguration().getPath().getService());
        serviceImpData.put("EntityPackageName", ConfigUtil.getConfiguration().getPath().getEntity());
        serviceImpData.put("Author", ConfigUtil.getConfiguration().getAuthor());
        serviceImpData.put("Date", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        serviceImpData.put("ClassName", className);
        serviceImpData.put("EntityName", StringUtil.firstToLowerCase(className));
        String filePath = FileUtil.getSourcePath() + StringUtil.package2Path(ConfigUtil.getConfiguration().getPackageName()) + StringUtil.package2Path(ConfigUtil.getConfiguration().getPath().getService());
        String fileName = className + "Service.java";
        // 生成service文件
        FileUtil.generateToJava(FreemarketConfigUtils.TYPE_SERVICE, serviceImpData, filePath + fileName);
    }
}
