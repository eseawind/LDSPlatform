/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.leedarson.entities.pqc;

/**
 *
 * @author chenfeng
 */

public class TableList {
       
   
    private String questionType;
    private String tableName;

    public String getQuestionType() {
        return questionType;
    }

    public String getTableName() {
        return tableName;
    }

    public void setQuestionType(String questionType) {
        this.questionType = questionType;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }
    
    


    @Override
    public String toString() {
        return "com.leedarson.entities.TableList[ questionType=" + questionType + " ]";
    }
    
}
