/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.leedarson.facades.pqc;

import com.leedarson.entities.pqc.HeaderInfo;
import static com.leedarson.entities.util.EntityUtil.objectToString;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author chenfeng
 */
@Stateless
public class HeaderInfoFacade implements HeaderInfoFacadeLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    @PersistenceContext(unitName = "LDSPlatform-ejbPU")
    private EntityManager em;

    @Override
    public List<HeaderInfo> getHeaderInfo(String workOrderNum) {
       
        List<HeaderInfo> result = new ArrayList<HeaderInfo>();
//  
//        String sql = "select lmo.make_order_num, --生产订单\n" +
//"       lmo.po_number, --销售订单\n" +
//"       lmo.so_number, --销售订单项目号\n" +
//"       lmo.po_qty, --销售数量\n" +
//"       lmo.customer,--客户简称\n" +
//"       hi.item_code, --ID,\n" +
//"       hi.descriptions, --短描述\n" +
//"       hi.long_descriptions, --长描述\n" +
//"       hic.one_item_group, --一阶物料组\n" +
//"       hplg.DESCRIPTIONS, --生产课别\n" +
//"       hpl.DESCRIPTIONS, --生产线别\n" +
//"       hp.DESCRIPTIONS --生产工厂\n" +
//"  from ldx_make_order            lmo,\n" +
//"       ldx_mo_wo_ref             lmwr,\n" +
//"       hcm_item                  hi,\n" +
//"       hcm_item_control          hic,\n" +
//"       hcm_production_line       hpl,\n" +
//"       hcm_production_line_group hplg,\n" +
//"       hme_work_order            hwo,\n" +
//"       hcm_plant                 hp\n" +
//" where 1 = 1\n" +
//"   and lmo.plant_id = hi.plant_id\n" +
//"   and hi.item_id = lmo.item_id\n" +
//"   and hi.plant_id = hic.plant_id(+)\n" +
//"   and hi.item_id = hic.item_id(+)\n" +
//"   and hwo.plant_id = hpl.plant_id\n" +
//"   and hwo.prod_line_id = hpl.prod_line_id\n" +
//"   and lmwr.make_order_id = lmo.make_order_id\n" +
//"   and lmwr.work_order_id = hwo.work_order_id\n" +
//"   and hpl.prod_line_group_id = hplg.prod_line_group_id\n" +
//"   and lmo.plant_id=hp.plant_id\n" +
//"   and hwo.WORK_ORDER_NUM = ?";
        
        String sql = "SELECT lmo.make_order_num, --生产订单\n" +
"       lmo.po_number, --销售订单\n" +
"       lmo.so_number, --销售订单项目号\n" +
"       lsl.so_line_qty, --销售数量\n" +
"       lmo.customer, --客户简称\n" +
"       hiv.item_code, --ID,\n" +
"       hiv.descriptions, --短描述\n" +
"       hiv.long_descriptions, --长描述\n" +
"       hiv.one_item_group, --一阶物料组\n" +
"       hplg.descriptions, --生产课别\n" +
"       hpl.descriptions, --生产线别\n" +
"       hp.descriptions --生产工厂\n" +
"  FROM ldx_make_order            lmo,\n" +
"       ldx_mo_wo_ref             lmwr,\n" +
"       hcm_item_v                hiv,\n" +
"       hcm_production_line       hpl,\n" +
"       hcm_production_line_group hplg,\n" +
"       hme_work_order            hwo,\n" +
"       hcm_plant                 hp,\n" +
"       ldx_so_line_mv lsl\n" +
"WHERE 1 = 1\n" +
"   AND lmo.plant_id = hiv.plant_id\n" +
"   AND hiv.item_id = lmo.item_id\n" +
"   AND hwo.prod_line_id = hpl.prod_line_id\n" +
"   AND lmwr.make_order_id = lmo.make_order_id\n" +
"   AND lmwr.work_order_id = hwo.work_order_id\n" +
"   AND hpl.prod_line_group_id = hplg.prod_line_group_id\n" +
"   AND lmo.plant_id = hp.plant_id\n" +
"   AND lmo.po_number = lsl.so_number(+)\n" +
"   and lmo.so_number = lsl.LINE_NUM(+)\n" +
"   AND hwo.work_order_num = ?";
        
        javax.persistence.Query query = em.createNativeQuery(sql);
        
        query.setParameter(1, workOrderNum);
        
        
            List<Object[]> temp = query.getResultList();
            if(temp != null && temp.size() >0){
                
                HeaderInfo headerInfo = null;
                
                for (int i=0;i<temp.size();i++){
                    Object[] fields = temp.get(i);
                    headerInfo = new HeaderInfo();
                    headerInfo.setMakeOrderNum(objectToString(fields[0]));
                    headerInfo.setPoNumber(objectToString(fields[1]));
                    headerInfo.setSoNumber(objectToString(fields[2]));
                    headerInfo.setPoQty(objectToString(fields[3]));
                    headerInfo.setCustomer(objectToString(fields[4]));
                    headerInfo.setItemCode(objectToString(fields[5]));
                    headerInfo.setDescriptions(objectToString(fields[6]));
                    headerInfo.setLongDescriptions(objectToString(fields[7]));
                    headerInfo.setOneItemGroup(objectToString(fields[8]));
                    headerInfo.setProdLineGroupCode(objectToString(fields[9]));
                    headerInfo.setProdLineCode(objectToString(fields[10]));
                    headerInfo.setPlantCode(objectToString(fields[11]));
                    
                    result.add(headerInfo);
                }
                
            }
            return result;
        
    }
    
    
}
