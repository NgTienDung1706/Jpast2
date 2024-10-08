<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>

<form action="<c:url value="/admin/category/insert"/>" method="post" enctype="multipart/form-data">
  <label for="categoryname">Category name</label><br>
  <input type="text" id="categoryname" name="categoryname"><br>

  <label for="image">Images</label><br>
  <input type="text" id="image" name="image"> <br>

  <label for="image">Upload file:</label><br>
  <input type="file" id="images" name="images"> <br>

  <label for="status">Status:</label><br>
  <input type="radio" id=statuson" name="status" value="1">
  <label for="status">Hoạt động</label><br>
  <input type="radio" id=statusoff" name="status" value="0">
  <label for="status">Khóa</label><br>
  <input type="submit" value="Insert">
</form>