package org.mybatis.generator.api;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.JavaVisibility;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.Parameter;
import org.mybatis.generator.api.dom.java.PrimitiveTypeWrapper;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.Document;
import org.mybatis.generator.api.dom.xml.Element;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.codegen.AbstractJavaGenerator;

/**
 * mybatis代码生成
 * Created by lixuebao on 17-7-11.
 */
@SuppressWarnings({"unused","rawtypes"})
public class GeneratorPlugin extends PluginAdapter {

    private String  LIMITSTART = "limitStart";
    private String  LIMITSIZE = "limitSize";
    private String  VERSION_FILED = "optimistic";
    private String  BASE_ENTITY = "wang.sunce.common.entity.BaseEntity";
    private String  BASE_DAO = "wang.sunce.common.dao.BaseDao";
    private String  BASE_SERVICE = "wang.sunce.common.service.BaseService";
    private String  BASE_CONTROLLER = "wang.sunce.common.web.BaseController";
    private String  PACKAGE_DAO = "wang.sunce.customer.dao";
    private String  PACKAGE_ENTITY = "wang.sunce.customer.entity";
    private String  PACKAGE_SERVICE = "wang.sunce.customer.service";
    private String  PACKAGE_CONTROLLER = "wang.sunce.customer.web";
    /**
     * 生成dao
     */
	@Override
    public boolean clientGenerated(Interface interfaze, TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        String columnsType="java.lang.String";
        //动态获取当前表的主键类型，如果有联合主键，默认取联合主键的第一列（可能存在问题）
        //主键为空则默认为String类型
        if(introspectedTable.getPrimaryKeyColumns()!=null && introspectedTable.getPrimaryKeyColumns().size()>0){
            columnsType=introspectedTable.getPrimaryKeyColumns().get(0).getFullyQualifiedJavaType().toString();
        }
        FullyQualifiedJavaType fqjt = new FullyQualifiedJavaType("BaseDao<" + introspectedTable.getBaseRecordType()+","
                +introspectedTable.getExampleType()+">");
        FullyQualifiedJavaType imp = new FullyQualifiedJavaType(BASE_DAO);
        interfaze.addSuperInterface(fqjt);// 添加 extends BaseDao<user>
        interfaze.addImportedType(imp);// 添加import common.BaseDao;
        interfaze.getMethods().clear();
        return true;
    }

    /**
     * 生成实体中每个属性
     */
    @Override
    public boolean modelGetterMethodGenerated(Method method, TopLevelClass topLevelClass,
                                              IntrospectedColumn introspectedColumn,
                                              IntrospectedTable introspectedTable, ModelClassType modelClassType) {
        return true;
    }

    /**
     * 生成实体
     */
    @Override
    public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
//        creteServiceController(topLevelClass.getType().getShortName());
        String columnsType="java.lang.String";
        //动态获取当前表的主键类型，如果有联合主键，默认取联合主键的第一列（可能存在问题）
        //主键为空则默认为String类型
        if(introspectedTable.getPrimaryKeyColumns()!=null && introspectedTable.getPrimaryKeyColumns().size()>0){
            columnsType=introspectedTable.getPrimaryKeyColumns().get(0).getFullyQualifiedJavaType().toString();
        }
        FullyQualifiedJavaType imp = new FullyQualifiedJavaType(BASE_ENTITY);
        FullyQualifiedJavaType fqjt = new FullyQualifiedJavaType("BaseEntity<"+columnsType+">");

        topLevelClass.addImportedType(imp);
        topLevelClass.setSuperClass(fqjt);
        clearBaseField(topLevelClass);
        return super.modelBaseRecordClassGenerated(topLevelClass, introspectedTable);
    }

    /**
     * 生成mapping，每次更新版本号加1
     */
	@Override
    public boolean sqlMapGenerated(GeneratedXmlFile sqlMap, IntrospectedTable introspectedTable) {
        Document document = sqlMap.getDocument();
        document.getRootElement();
        XmlElement root = document.getRootElement();
        List<Element> list1 =  root.getElements();
        for (Iterator i = list1.iterator();i.hasNext();){
            XmlElement xml = (XmlElement) i.next();
            if("update".equals(xml.getName())){
                if ("updateByExample".equals(xml.getAttributes().get(0).getValue())){
                    i.remove();
                }else if ("updateByPrimaryKeySelective".equals(xml.getAttributes().get(0).getValue())){
                    XmlElement xml2  = (XmlElement) xml.getElements().get(1);
                    List<Element> list2 =  xml2.getElements();
                    for (Iterator j = list2.iterator();j.hasNext();){
                        XmlElement xml3 = (XmlElement) j.next();
                        TextElement text = (TextElement) xml3.getElements().get(0);
                        if (text.getContent().startsWith("optimistic")){
                            j.remove();
                        }
                    }
                    TextElement text = new TextElement(VERSION_FILED+" = "+ VERSION_FILED +" + 1,");
                    xml2.addElement(text);
                    
                    TextElement textElement = (TextElement) xml.getElements().get(2);
                    xml.getElements().set(2, new TextElement(textElement.getContent() + " and optimistic = #{optimistic,jdbcType=INTEGER}"));
                    
                }else if ("updateByExampleSelective".equals(xml.getAttributes().get(0).getValue())){
                    XmlElement xml2  = (XmlElement) xml.getElements().get(1);
                    List<Element> list2 =  xml2.getElements();
                    for (Iterator j = list2.iterator();j.hasNext();){
                        XmlElement xml3 = (XmlElement) j.next();
                        TextElement text = (TextElement) xml3.getElements().get(0);
                        if (text.getContent().startsWith(VERSION_FILED)){
                            j.remove();
                        }
                    }
                    TextElement text = new TextElement(VERSION_FILED+" = "+ VERSION_FILED +" + 1,");
                    xml2.addElement(text);
                }
            }
        }
        return super.sqlMapGenerated(sqlMap, introspectedTable);
    }

    /**
     * 生成mapping 添加自定义sql
     */
    /*@Override
    public boolean sqlMapDocumentGenerated(Document document, IntrospectedTable introspectedTable) {
        String tableName = introspectedTable.getAliasedFullyQualifiedTableNameAtRuntime();// 数据库表名
        List<IntrospectedColumn> columns = introspectedTable.getAllColumns();
        XmlElement parentElement = document.getRootElement();

        // 添加sql——where
        XmlElement sql = new XmlElement("sql");
        sql.addAttribute(new Attribute("id", "sql_where"));
        XmlElement where = new XmlElement("where");
        StringBuilder sb = new StringBuilder();
        for (IntrospectedColumn introspectedColumn : introspectedTable.getNonPrimaryKeyColumns()) {
            XmlElement isNotNullElement = new XmlElement("if"); //$NON-NLS-1$
            sb.setLength(0);
            sb.append(introspectedColumn.getJavaProperty());
            sb.append(" != null"); //$NON-NLS-1$
            isNotNullElement.addAttribute(new Attribute("test", sb.toString())); //$NON-NLS-1$
            where.addElement(isNotNullElement);

            sb.setLength(0);
            sb.append(" and ");
            sb.append(MyBatis3FormattingUtilities.getEscapedColumnName(introspectedColumn));
            sb.append(" = "); //$NON-NLS-1$
            sb.append(MyBatis3FormattingUtilities.getParameterClause(introspectedColumn));
            isNotNullElement.addElement(new TextElement(sb.toString()));
        }
        sql.addElement(where);
        parentElement.addElement(sql);

        //添加getList
        XmlElement select = new XmlElement("select");
        select.addAttribute(new Attribute("id", "getList"));
        select.addAttribute(new Attribute("resultMap", "BaseResultMap"));
        select.addAttribute(new Attribute("parameterType", introspectedTable.getBaseRecordType()));
        select.addElement(new TextElement(" select * from "+ introspectedTable.getFullyQualifiedTableNameAtRuntime()));

        XmlElement include = new XmlElement("include");
        include.addAttribute(new Attribute("refid", "sql_where"));

        select.addElement(include);
        parentElement.addElement(select);

        return super.sqlMapDocumentGenerated(document, introspectedTable);
    }*/

    @Override
    public boolean sqlMapUpdateByPrimaryKeyWithoutBLOBsElementGenerated(XmlElement element,
                                                                        IntrospectedTable introspectedTable) {
        return false;
    }

    @Override
    public boolean sqlMapInsertElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
        return false;
    }

    @Override
    public boolean modelExampleClassGenerated(TopLevelClass topLevelClass,
                                              IntrospectedTable introspectedTable) {
        addLimit(topLevelClass, introspectedTable, LIMITSTART);
        addLimit(topLevelClass, introspectedTable, LIMITSIZE);
        return super.modelExampleClassGenerated(topLevelClass,
                introspectedTable);
    }
    @Override
    public boolean sqlMapSelectByExampleWithoutBLOBsElementGenerated(XmlElement element,
                                                                     IntrospectedTable introspectedTable) {

        XmlElement isNotNullElement = new XmlElement("if");
        isNotNullElement.addAttribute(new Attribute("test",
                LIMITSTART+" != null and "+LIMITSIZE+" !=null "));
        isNotNullElement.addElement(new TextElement(
                "limit #{"+LIMITSTART+"} , #{"+LIMITSIZE+"}"));
        element.addElement(isNotNullElement);
        return super.sqlMapSelectByExampleWithoutBLOBsElementGenerated(element, introspectedTable);
    }



    /*
     * 实体中添加属性
     */
    private void addLimit(TopLevelClass topLevelClass, IntrospectedTable introspectedTable, String name) {
        CommentGenerator commentGenerator = context.getCommentGenerator();
        /**
         * 创建类成员变量 如protected Integer limitStart;
         */
        Field field = new Field();
        field.setVisibility(JavaVisibility.PROTECTED);
        field.setType(PrimitiveTypeWrapper.getIntegerInstance());
        field.setName(name);
        commentGenerator.addFieldComment(field, introspectedTable);
        topLevelClass.addField(field);
        /**
         * 首字母大写
         */
        char[] c = name.toCharArray();
        c[0] -= 32;
        /**
         * 添加Setter方法
         */
        Method method = new Method();
        method.setVisibility(JavaVisibility.PUBLIC);
        method.setName("set" + String.valueOf(c));
        method.addParameter(new Parameter(PrimitiveTypeWrapper
                .getIntegerInstance(), name));
        StringBuilder sb = new StringBuilder();
        sb.append("this.");
        sb.append(name);
        sb.append(" = ");
        sb.append(name);
        sb.append(";");
        /**
         * 如 this.limitStart = limitStart;
         */
        method.addBodyLine(sb.toString());
        commentGenerator.addGeneralMethodComment(method, introspectedTable);
        topLevelClass.addMethod(method);
        /**
         * 添加Getter Method 直接调用AbstractJavaGenerator的getGetter方法
         */
        Method getterMethod = AbstractJavaGenerator.getGetter(field);
        commentGenerator.addGeneralMethodComment(getterMethod,
                introspectedTable);
        topLevelClass.addMethod(getterMethod);
    }

    @Override
    public boolean validate(List<String> arg0) {
        return true;
    }
    /**
     * 清除baseentity中的属性和方法
     * @param topLevelClass
     * @return
     */
    public void clearBaseField(TopLevelClass topLevelClass) {
        List<Field> fieldList = topLevelClass.getFields();
        for (Iterator i = fieldList.iterator();i.hasNext();){
            Field field = (Field) i.next();
            if("id".equals(field.getName())||"optimistic".equals(field.getName())||
                    "createTime".equals(field.getName())||"lastUpdateTime".equals(field.getName())){
                i.remove();
            }
        }

        List<Method> methodList = topLevelClass.getMethods();
        for (Iterator i = methodList.iterator();i.hasNext();){
            Method method = (Method) i.next();
            if ("getId".equals(method.getName())||"setId".equals(method.getName())
                    ||"getOptimistic".equals(method.getName())||"setOptimistic".equals(method.getName())
                    ||"getCreateTime".equals(method.getName())||"setCreateTime".equals(method.getName())
                    ||"getLastUpdateTime".equals(method.getName())||"setLastUpdateTime".equals(method.getName())){
                i.remove();
            }
        }

    }


    public void creteServiceController(String entityName){
        VelocityEngine ve = new VelocityEngine();
        ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        ve.setProperty(Velocity.ENCODING_DEFAULT, "UTF-8");
        ve.init();
        Template t = ve.getTemplate("templates/generate/service.java.vm");
        VelocityContext ctx = new VelocityContext();
        ctx.put("packageService", PACKAGE_SERVICE);
        ctx.put("packageEntity",PACKAGE_ENTITY);
        ctx.put("entity",entityName);
        ctx.put("example",entityName+"Example");
        ctx.put("author","lixuebao");
        ctx.put("date","");
        ctx.put("serviceName",entityName+"Service");
        ctx.put("baseServiceName","BaseService");
        ctx.put("baseService",BASE_SERVICE);
        ctx.put("daoName",entityName+"Dao");
        ctx.put("varDao",entityName.substring(0, 1).toLowerCase() +entityName.substring(1) +"Dao");
        ctx.put("packageDao",PACKAGE_DAO);
        ctx.put("dao",entityName+"Dao");
        String rootPath = GeneratorPlugin.class.getClassLoader().getResource("").getFile().split("target")[0] + "/src/main";
        
        merge(t, ctx, rootPath + "/java/" + PACKAGE_SERVICE.replace(".", "/") + "/",entityName+"Service.java");

        Template t1 = ve.getTemplate("templates/generate/controller.java.vm");
        VelocityContext ctx1 = new VelocityContext();
        ctx1.put("packageController", PACKAGE_CONTROLLER);
        ctx1.put("packageEntity",PACKAGE_ENTITY);
        ctx1.put("entity",entityName);
        ctx1.put("example",entityName+"Example");
        ctx1.put("author","lixuebao");
        ctx1.put("date","");
        ctx1.put("request",entityName.toLowerCase());
        ctx1.put("controllerName",entityName+"Controller");
        ctx1.put("baseControllerName","BaseController");
        ctx1.put("baseController",BASE_CONTROLLER);
        ctx1.put("serviceName",entityName+"Service");
        ctx1.put("varService",entityName.substring(0, 1).toLowerCase()+entityName.substring(1)+"Service");
        ctx1.put("packageService",PACKAGE_SERVICE);
        ctx1.put("service",entityName+"Service");
        
        
        
        merge(t1, ctx1, rootPath + "/java/" + PACKAGE_CONTROLLER.replace(".", "/") + "/", entityName + "Controller.java");
    }

    /**
     * 创建文件
     * @param template
     * @param ctx
     * @param path
     * @param fileName
     */
    public void merge(Template template, VelocityContext ctx, String path,String fileName) {
        PrintWriter writer = null;
        try {
            File f = new File(path);
            // 创建文件夹
            if (!f.exists()) {
                f.mkdirs();
            }
            f = new File(path+fileName);
            // 创建文件
            if (!f.exists()) {
                try {
                    f.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            writer = new PrintWriter(path+fileName);
            template.merge(ctx, writer);
            writer.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            writer.close();
        }
    }

    public static void generate() {
        String config = GeneratorPlugin.class.getClassLoader().getResource("mysqlGenerator.xml").getFile();
        String[] arg = { "-configfile", config, "-overwrite" };
        ShellRunner.main(arg);
    }

    public static void main(String[] args) {
        generate();

    }
}
