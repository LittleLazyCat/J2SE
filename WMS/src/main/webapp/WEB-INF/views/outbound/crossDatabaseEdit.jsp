<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/commons/global.jsp" %>
<script type="text/javascript" src="${staticPath }/static/My97DatePicker/WdatePicker.js" charset="utf-8"></script>
<script type="text/javascript">
    $(function () {
        $('#crossDatabaseEditForm').form({
            url: '${path }/crossDatabase/crossDatabase/update',
            onSubmit: function () {
                progressLoad();
                var isValid = $(this).form('enableValidation').form('validate');
                if (!isValid) {
                    progressClose();
                }
                return isValid;
            },
            success: function (result) {
                progressClose();
                result = $.parseJSON(result);
                if (result.success) {
                    parent.$.modalDialog.openner_dataGrid.datagrid('reload');//之所以能在这里调用到parent.$.modalDialog.openner_dataGrid这个对象，是因为user.jsp页面预定义好了
                    parent.$.modalDialog.handler.dialog('close');
                } else {
                    parent.$.messager.alert('错误', result.msg, 'error');
                }
            }
        });

        $("#selectCombobox").combobox({
            url: "${path }/godown/godownComboBox",
            method: 'get',
            valueField: 'id',
            textField: 'text',
            panelHeight: 'auto',
            onLoadSuccess: function () {
                var data = $('#selectCombobox').combobox('getData');
                if (data.length > 0) {
                    $("#selectCombobox").combobox('select', '${crossDatabase.cdWhid}');
                }
            }
        });
    });
</script>
<div class="easyui-layout" data-options="fit:true,border:false">
    <div data-options="region:'center',border:false" title="" style="overflow: hidden;padding: 3px;">
        <form id="crossDatabaseEditForm" method="post">
            <table class="grid">
                <tr>
                    <td>货物名称</td>
                    <input name="cdId" type="hidden" value="${crossDatabase.cdId}">
                    <td><input name="cdName" type="text" placeholder="请输入货物名称" class="easyui-validatebox" data-options="required:true,validType:'length[1,20]',novalidate:true" value="${crossDatabase.cdName}"></td>
                    <td>货物型号</td>
                    <td><input name="cdSkumodel" type="text" placeholder="请输入货物型号" class="easyui-validatebox" data-options="required:true,validType:'length[1,20]',novalidate:true" value="${crossDatabase.cdSkumodel}"></td>
                </tr>
                <tr>
                    <td>发货数量</td>
                    <td><input name="cdNum" type="text" placeholder="请输入发货数量" class="easyui-validatebox" data-options="required:true,validType:'length[1,20]',novalidate:true" value="${crossDatabase.cdNum}"></td>
                    <td>仓库编号</td>
                    <td><input name="cdWhid" id="selectCombobox" class="easyui-combobox"  data-options="required:true,validType:'length[1,10]',novalidate:true" /></td>
                </tr>
                <tr>
                    <td>调拨单号</td>
                    <td><input name="cdOddnumbers" type="text" placeholder="请输入调拨单号" class="easyui-validatebox" data-options="required:true,validType:'length[1,20]',novalidate:true" value="${crossDatabase.cdOddnumbers}"></td>
                    <td>发货时间</td>
                    <td><input name="byTime" placeholder="点击选择时间" onclick="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd'})" readonly="readonly" value="<fmt:formatDate pattern="yyyy-MM-dd" value="${crossDatabase.cdTime}" />"/></td>
                </tr>
                <tr>
                    <td>货物体积</td>
                    <td><input name="cdVolume" type="text" placeholder="请输入货物体积" class="easyui-validatebox" data-options="required:true,validType:'length[1,20]',novalidate:true" value="${crossDatabase.cdVolume}"></td>
                </tr>
            </table>
        </form>
    </div>
</div>