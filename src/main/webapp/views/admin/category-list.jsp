<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>

<a href="<c:url value="/admin/category/add"/> ">Add Category</a>
<table border="1" width="100%">
  <tr>
    <th>STT</th>
    <th>Image</th>
    <th>Category Name</th>
    <th>Status</th>
    <th>Action</th>
  </tr>
  <c:forEach items="${listcate}" var="cate" varStatus="STT" >
    <tr class="odd gradeX">
      <td>${STT.index+1 }</td>

      <c:if test="${cate.images.substring(0,5) =='https'}">
        <c:url value="${cate.images}" var = "imgUrl"></c:url>
      </c:if>

      <c:if test="${cate.images.substring(0,5) !='https'}">
        <c:url value="/image?fname=${cate.images}" var = "imgUrl"></c:url>
      </c:if>

      <td><img height="150" width="200" src="${imgUrl}" /></td>
      <td>${cate.categoryname }</td>
      <td>
      <c:if test="${cate.status==1}">
      	<span>Hoạt động</span>
      </c:if>
      <c:if test="${cate.status!=1}">
      	<span>Khóa</span>
      </c:if>
      </td>
      <td>
        <a href="<c:url value='/admin/category/edit?id=${cate.categoryid }'/>" >Sửa</a>
        <a href="<c:url value='/admin/category/delete?id=${cate.categoryid }'/>">Xóa</a></td>
    </tr>
  </c:forEach>
</table>