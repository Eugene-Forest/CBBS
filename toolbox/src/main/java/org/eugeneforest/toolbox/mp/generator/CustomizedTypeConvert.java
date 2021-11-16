package org.eugeneforest.toolbox.mp.generator;

import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.converts.SqlServerTypeConvert;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.IColumnType;

/**
 * 不同数据库的特殊类型的转换
 * @author Eugene-Forest
 * @date 2021/11/9
 **/
public class CustomizedTypeConvert {

    /**
     * mssql的字段类型转换
     */
    public static final SqlServerTypeConvert MSSQL_DEFAULT_TYPE_CONVERT= new SqlServerTypeConvert(){

        @Override
        public IColumnType processTypeConvert(GlobalConfig config, String fieldType) {
            //自定义类型转换
            String type=fieldType.toLowerCase();
            if (type.contains("date") || type.contains("datetime")){
                return DbColumnType.DATE;
            }
            return super.processTypeConvert(config, fieldType);
        }
    };

    /**
     * mysql的字段类型转换
     */
    public static final MySqlTypeConvert MYSQL_DEFAULT_TYPE_CONVERT= new MySqlTypeConvert(){
        @Override
        public IColumnType processTypeConvert(GlobalConfig config, String fieldType) {
            //自定义类型转换
            String type=fieldType.toLowerCase();
            if (type.contains("date") || type.contains("datetime")){
                return DbColumnType.DATE;
            }
            return super.processTypeConvert(config, fieldType);
        }
    };
}
