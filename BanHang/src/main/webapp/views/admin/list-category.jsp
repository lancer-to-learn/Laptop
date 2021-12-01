<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>

<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
<link
	href="https://cdn.datatables.net/1.11.3/css/dataTables.bootstrap.min.css" />
<link
	href="https://cdn.datatables.net/fixedheader/3.2.0/css/fixedHeader.bootstrap.min.css" />
<link
	href="https://cdn.datatables.net/responsive/2.2.9/css/responsive.bootstrap.min.css" />


<table id="example" class="table table-striped table-bordered nowrap"
	style="width: 100%">
	<thead>
		<tr>
			<th>STT</th>
			<th>Ảnh</th>
			<th>Tên danh mục</th>
			<th>Hoạt động</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${cateList}" var="cate" varStatus="STT">
			<tr class="odd gradeX">
				<td>${STT.index+1 }</td>
				<c:url value="/image?fname=${cate.icon }" var="imgUrl"></c:url>
				<td><img height="150" width="200" src="${imgUrl}" /></td>
				<td>${cate.cname }</td>
				<td><a
					href="<c:url value='/admin/category/edit?id=${cate.cate_id }'/>"
					class="center">Sửa</a> | <a
					href="<c:url value='/admin/category/delete?id=${cate.cate_id }'/>"
					class="center">Xóa</a></td>
			</tr>
		</c:forEach>

	</tbody>
	<tfoot>
		<tr>
			<th>STT</th>
			<th>Ảnh</th>
			<th>Tên danh mục</th>
			<th>Hoạt động</th>
		</tr>
	</tfoot>
</table>
<script>
    $(document).ready(function){
    	var table = $('#example').DataTable({
    		fixedHeader: true
    	});
    });
    </script>