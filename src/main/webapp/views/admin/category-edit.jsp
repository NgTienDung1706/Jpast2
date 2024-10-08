<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>

<form action="<c:url value="/admin/category/update"/>" method="post" enctype="multipart/form-data">
    <input type="text" id="categoryid" name="categoryid" value="${cate.categoryid}" hidden="hidden" >
    <label for="categoryname">Category name</label><br>
    <input type="text" id="categoryname" name="categoryname" value="${cate.categoryname}"><br>

    <label for="image">Images</label><br>

    <c:if test="${cate.images.substring(0,5) =='https'}">
        <c:url value="${cates.images}" var="imgUrl"></c:url>
    </c:if>

    <c:if test="${cate.images.substring(0,5) !='https'}">
        <c:url value="/image?fname=${cate.images}" var="imgUrl"></c:url>
    </c:if>

    <td><img height="150" width="200" src="${imgUrl}"/></td>

    <label for="image">Upload file:</label><br>
    <input type="file" id="image1" name="image1"> <br>
	<label for="status">Status:</label><br>
    <input type="radio" id=statuson" name="status" value="1" ${cate.status==1?'checked':''}>
    <label for="status">Hoạt động</label><br>
    <input type="radio" id=statusoff" name="status" value="0" ${cate.status==0?'checked':''}>
    <label for="status">Khóa</label><br>
    <input type="submit" value="Insert">
</form>