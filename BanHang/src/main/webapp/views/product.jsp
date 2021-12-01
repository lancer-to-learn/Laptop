<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!-- content -->
<div class="container">
	<div class="row">
		<div class="col">
			<nav aria-label="breadcrumb">
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="index.html">Home</a></li>
					<li class="breadcrumb-item"><a href="category.html">Category</a></li>
					<li class="breadcrumb-item active" aria-current="page">${categoryname}</li>
				</ol>
			</nav>
		</div>
	</div>
</div>
<div class="container">
	<div class="row">
		<div class="col-12 col-sm-3">
			<div class="card bg-light mb-3">
				<div class="card-header bg-primary text-white text-uppercase">
					<i class="fa fa-list"></i> Categories
				</div>
				<ul class="list-group category_block">
					<c:forEach items="${listcate}" var="o">
						<li><a class="dropdown-item ${tagactive==o.cate_id ? "
							active" : ""}" href="product?cid=${o.cate_id}">${o.icon}
								${o.cname}</a></li>
					</c:forEach>
				</ul>
			</div>
			<div class="card bg-light mb-3">
				<div class="card-header bg-success text-white text-uppercase">Last
					product</div>
				<div class="card-body">
					<img class="img-fluid" src="${ lastproduct.image}" />
					<h5 class="card-title">${lastproduct.pName}</h5>
					<p class="card-text">${lastproduct.description}</p>
					<p class="bloc_left_price">${lastproduct.price}$</p>
				</div>
			</div>
		</div>

		<!-- old -->
		<%-- <div class="col">
			<div class="row">
				<c:forEach items="${listproductbycid}" var="p">
					<div class="col-12 col-md-6 col-lg-4">
						<div class="card">
							<img class="card-img-top" src="${p.image}" alt="${p.pName}">
							<div class="card-body">
								<h4 class="card-title">
									<a href="productdetail?pid=${p.pID}" title="View Product">${p.pName}</a>
								</h4>
								<p class="card-text">${p.description}</p>
								<div class="row">
									<div class="col">
										<p class="btn btn-danger btn-block">${p.price}$</p>
									</div>
									<div class="col">
										<a href="#" class="btn btn-success btn-block">Add to cart</a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>

			</div>
		</div>
		 --%>
		<!-- old -->
		<div class="col">
			<div class="card">
				<c:forEach items="${listcate}" var="o">
					<div class="card-header bg-primary text-white text-uppercase">
						<i class="fa fa-star">${o.cname} </i>
					</div>
					<div class="card-body">
						<div class="row">
							<c:forEach items="${listproductbycid}" var="p">
								<c:if test="${o.cate_id == p.categoryID}">
									<div class="col-12 col-md-6 col-lg-4">
										<div class="card">
											<img class="card-img-top" src="${p.image}"
												alt="Card image cap">
											<div class="card-body">
												<h4 class="card-title">
													<a href="productdetail?pid=${p.pID}" title="View Product">${p.pName}</a>
												</h4>
												<p class="card-text">${p.description}</p>
												<div class="row">
													<div class="col">
														<p class="btn btn-danger btn-block">${p.price}$</p>
													</div>
													<div class="col">
														<a href="<c:url value="/member/cart-add?pId=${o.id}&quantity=1"></c:url>" class="btn btn-success btn-block">Add
															to cart</a>
													</div>
												</div>
											</div>
										</div>
									</div>
								</c:if>
							</c:forEach>
						</div>
					</div>
				</c:forEach>
				<div class="col-12">
                    <nav aria-label="...">
                        <ul class="pagination">
                         <c:if test="${tag>1}">
                            <li class="page-item">
                                <a class="page-link" href="product?cid=${tagactive}&index=${tag-1}">Previous</a>
                            </li>
                            </c:if>
                            <c:forEach begin="1" end="${endP}" var="i">
                             <li class="page-item ${tag==i ? "active":"" }"><a class="page-link" href="product?cid=${tagactive}&index=${i}"">${i}</a></li>
                            </c:forEach>
                            <c:if test="${tag<endP}">
                            <li class="page-item">
                                <a class="page-link" href="product?cid=${tagactive}&index=${tag+1}">Next</a>
                            </li>
                            </c:if>
                        </ul>
                    </nav>
                </div>
			</div>
		</div>
	</div>
</div>
<!-- end content -->
