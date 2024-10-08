<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>	
<head>
    <title>Video Management</title>
</head>
<body>
    <h2>Video Management</h2>
    <form action="${pageContext.request.contextPath}/admin/video/insert" method="post" enctype="multipart/form-data">
        <label>Upload: </label>
        <input type="file" name="image" /><br/>

        <label>Video ID: </label>
        <input type="text" name="videoid" value="${video.videoid}" /><br/>

        <label>Video Title: </label>
        <input type="text" name="title" value="${video.title}" /><br/>

        <label>View Count: </label>
        <input type="number" name="viewCount" value="${video.viewCount}" /><br/>

        <label>Category: </label>
        <select name="categoryid">
            <c:forEach var="category" items="${categories}">
                <option value="${category.categoryid}" ${category.categoryid == video.category.categoryid ? 'selected' : ''}>
                    ${category.categoryname}
                </option>
            </c:forEach>
        </select><br/>

        <label>Description: </label>
        <textarea name="description">${video.description}</textarea><br/>

        <label>Status: </label>
        <input type="radio" name="active" value="1" ${video.active == 1 ? 'checked' : ''} /> Hoạt động
        <input type="radio" name="active" value="0" ${video.active == 0 ? 'checked' : ''} /> Khóa<br/>

        <button type="submit">Create</button>
        <button type="reset">Reset</button>
    </form>

    <h3>Video List</h3>
    <table border="1">
        <tr>
            <th>Video ID</th>
            <th>Poster</th>
            <th>Video Title</th>
            <th>Description</th>
            <th>Views</th>
            <th>Category</th>
            <th>Status</th>
            <th>Action</th>
        </tr>
        <c:forEach var="video" items="${videos}">
            <tr>
                <td>${video.videoId}</td>
                <td><img src="${video.poster}" width="50"/></td>
                <td>${video.title}</td>
                <td>${video.description}</td>
                <td>${video.views}</td>
                <td>${video.category.categoryname}</td>
                <td>${video.active == 1 ? 'Hoạt động' : 'Khóa'}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/admin/video/edit?id=${video.videoId}">Edit</a>
                    <a href="${pageContext.request.contextPath}/admin/video/delete?id=${video.videoId}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
