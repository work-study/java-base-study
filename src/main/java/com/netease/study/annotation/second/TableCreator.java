package com.netease.study.annotation.second;


import org.apache.commons.lang3.StringUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class TableCreator {
    public static void main(String[] args) throws ClassNotFoundException {
        String className="com.netease.study.annotation.second.Member";
        Class clazz = Class.forName(className);
        DBTable dbTable = (DBTable) clazz.getAnnotation(DBTable.class);
        if (dbTable==null)
        {
            System.out.println("没有这个注解");
            return;
        }
        String tableName=dbTable.name();
        if (StringUtils.isEmpty(tableName))
            tableName = clazz.getName().toUpperCase();
        else
            tableName = tableName.toUpperCase();
        ArrayList<String> clumnNameDefs = new ArrayList<>();
        for (Field field:clazz.getDeclaredFields())
        {
            String columName=null;
            Annotation[] anno = field.getDeclaredAnnotations();
            if (anno.length<1)
            {
                System.out.println("这个域没有注解");
                continue;
            }
            if(anno[0] instanceof SQLInteger)
            {
                SQLInteger sInt = (SQLInteger)anno[0];
                if(sInt.name().length()<1)
                    columName = field.getName().toUpperCase();
                else
                    columName = sInt.name();

                clumnNameDefs.add(columName+" INT"+getConstraints(sInt.constraints()));
            }
            if(anno[0] instanceof SQLString)
            {
                SQLString sString = (SQLString)anno[0];
                if(sString.name().length()<1)
                    columName = field.getName().toUpperCase();
                else
                    columName = sString.name();

                clumnNameDefs.add(columName+" VARCHAR("+sString.value()+")"+getConstraints(sString.constraints()));
            }
        }
        StringBuilder createCommand = new StringBuilder("CREATE TABLE "+tableName+"(");
        for(String columnDef:clumnNameDefs)
        {
            createCommand.append("\n    "+columnDef+",");
        }
        String tableCreate = createCommand.substring(0, createCommand.length()-1)+")";
        System.out.println("Table Creation SQL for "+className +"is:\n"+tableCreate );
    }
    private static String getConstraints(Constraints con) {
        String constraints="";
        if(!con.allowNull())
            constraints +=" NOT NULL";
        if(con.primaryKey())
            constraints +=" PRIMARY KEY";
        if(con.unique())
            constraints +=" UNIQUE";
        return constraints;
    }
}
