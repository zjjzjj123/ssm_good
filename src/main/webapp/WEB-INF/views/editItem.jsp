<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>修改商品信息</title>

</head>
<body>

<h3>执行成功${id}</h3>
<!-- 通过提交的参数 进行查询  这个action提交的是什么东西 这样提交的就应该是整个商品信息-->
<form id="itemForm" action="${pageContext.request.contextPath }/items/editItemSubmit" method="post" >
    <input type="hidden" name="id" value="${id }"/>
    修改商品信息：
    <table width="100%" border=1>
        <tr>
            <td>商品名称</td>
            <td><input type="text" name="name" value="${itemsCustom.name }"/></td>
        </tr>
        <tr>
            <td>商品价格</td>
            <td><input type="text" name="price" value="${itemsCustom.price }"/></td>
        </tr>
        <!-- 这里需要进行格式的转换不然在你修改日期的时候读的是字符串对应bean中date肯定是报错的 -->
        <tr>
            <td>商品生产日期</td>
            <td><input type="text" name="createtime" value="<fmt:formatDate value="${itemsCustom.createtime}" pattern="yyyy-MM-dd HH-mm-ss"/>"/></td>
<%--            <td><input type="text" name="createtime"  value="${itemsCustom.createtime}"/></td>--%>
<%--            <td><input type="text" name="createtime"/></td>--%>
        </tr>
        <tr>
            <td>商品简介</td>
            <td>
                <textarea rows="3" cols="30" name="detail">${itemsCustom.detail }</textarea>
            </td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="submit" value="提交"/>
            </td>
        </tr>
    </table>

</form>
</body>
</html>