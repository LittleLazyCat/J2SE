package com.wms.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.wms.bean.Invoice;
import com.wms.commons.utils.OrderNumberUtil;
import com.wms.commons.utils.PageInfo;
import com.wms.dao.InvoiceMapper;
import com.wms.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ZhongYu on 2016/12/19.
 */
@Service
public class InvoiceServiceImpl implements InvoiceService {

    @Autowired
    private InvoiceMapper invoiceMapper;

    @Override
    public List<Invoice> queryAll() {
        return invoiceMapper.queryAll();
    }

    @Override
    public void selectDataGrid(PageInfo pageInfo) {
        Page<Invoice> page = new Page<Invoice>(pageInfo.getNowpage(), pageInfo.getSize());
        List<Invoice> list = invoiceMapper.selectInvoicePage(page, pageInfo.getCondition());
        pageInfo.setRows(list);
        pageInfo.setTotal(page.getTotal());
    }

    @Override
    public Invoice selectById(Integer id) {
        return invoiceMapper.selectByPrimaryKey(id);
    }

    @Override
    public int addInvoice(Invoice invoice) {
        invoice.setInOddnumber(OrderNumberUtil.generateOrderNo());
        return invoiceMapper.insert(invoice);
    }

    @Override
    public int deleteById(Integer id) {
        Invoice invoice = selectById(id);
        if (invoice != null) {
            return invoiceMapper.deleteByPrimaryKey(id);
        } else {
            //没有此ID
            return 0;
        }
    }

    /**
     * Selective 为动态SQL
     *
     * @param invoice
     * @return
     */
    @Override
    public int updateInvoice(Invoice invoice) {
        return invoiceMapper.updateByPrimaryKeySelective(invoice);
    }

}
