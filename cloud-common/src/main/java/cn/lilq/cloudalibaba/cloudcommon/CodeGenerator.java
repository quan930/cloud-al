package cn.lilq.cloudalibaba.cloudcommon;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.Scanner;

/**
 * @auther: Li Liangquan
 * @date: 2021/4/18 15:21
 * mybatis-plus 代码生成器
 */
public class CodeGenerator {
    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    private static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotBlank(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    /**
     * 代码生成器
     * @param ip 数据库地址 eg:localhost:5432
     * @param model 模块名
     * @param dbName 数据库名字
     */
    public static void execute(String ip,String model,String dbName) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath +"/"+ model + "/src/main/java");
        gc.setAuthor("Li Liangquan");
        gc.setOpen(false);
        gc.setFileOverride(false);//不允许覆盖
        gc.setSwagger2(true); //实体属性 Swagger2 注解
        gc.setServiceName("%sService");
        gc.setIdType(IdType.AUTO);//主键生成策略
        gc.setDateType(DateType.ONLY_DATE);//时间
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:postgresql://"+ip+"/"+dbName);
        // dsc.setSchemaName("public");
        dsc.setDriverName("org.postgresql.Driver");
        dsc.setUsername("postgres");
        dsc.setPassword("123456");
        dsc.setDbType(DbType.POSTGRE_SQL);
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setModuleName(model);
        pc.setParent("cn.lilq.cloudalibaba");
        pc.setEntity("model.entity");
        mpg.setPackageInfo(pc);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true);
        strategy.setInclude(scanner("表名，多个英文逗号分割").split(","));//映射表名
        strategy.setRestControllerStyle(true);
        strategy.setLogicDeleteFieldName("is_deleted");//逻辑删除
//        strategy.setControllerMappingHyphenStyle(true);
//        strategy.setTablePrefix( pc.getModuleName() + "_");
        mpg.setStrategy(strategy);
        mpg.execute();
    }
}
