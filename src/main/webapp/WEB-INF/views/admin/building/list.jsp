<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
<c:url var="buildingListURL" value="/admin/building-list"/>
<c:url var="formAjax" value="/api/user"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>
        Danh sách tòa nhà
    </title>
</head>
<body>
<div class="main-content">
    <div class="main-content-inner">
        <div class="breadcrumbs" id="breadcrumbs">
            <script type="text/javascript">
                try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
            </script>

            <ul class="breadcrumb">
                <li>
                    <i class="ace-icon fa fa-home home-icon"></i>
                    <a href="#">Home</a>
                </li>
                <li class="active">Dashboard</li>
            </ul><!-- /.breadcrumb -->
        </div>

        <div class="page-content">
            <div class="row">  <!-- chính là chia 12 clum -->
                <div class="widget-box">
                    <div class="widget-header">
                        <h4 class="widget-title">Tìm kiếm</h4>

                        <div class="widget-toolbar">
                            <a href="#" data-action="collapse">
                                <i class="ace-icon fa fa-chevron-up"></i>
                            </a>

                            <a href="#" data-action="close">
                                <i class="ace-icon fa fa-times"></i>
                            </a>
                        </div>
                    </div>

                    <div class="widget-body">
                        <div class="widget-main">
                            <div class = "form-horizontal">
                                <form:form commandName="modelSearch" action="$(buildingListURL)" id="listForm" method="GET">
                                    <div class="form-group">
                                        <div class="col-sm-6">

                                                <label for="name">Tên tòa nhà</label>
<%--                                                <input type="text" id="name" class="form-control" name="name" value=$"{modelSearch.name}"/>--%>
                                                <form:input path="name" cssClass="form-control"/>

                                        </div>

                                        <div class="col-sm-6">
                                            <div>
                                                <label for="floorArea">Diện tích sàn</label>

                                                <input type="number" id="floorArea" name="floorArea" value="${modelSearch.floorArea}" class="form-control" />
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-2">
                                            <div>
                                                <label for="district">Quận hiện có</label>
                                                <br />
                                                <select class="form-control" id="district">
                                                    <option selected>--Chọn quận--</option>
                                                    <option value="Q1">Quận 1</option>
                                                    <option value="Q2">Quận 2</option>
                                                    <option value="Q4">Quận 4</option>

                                                </select>
                                            </div>
                                        </div>
                                        <div class="col-sm-4">
                                            <div>
                                                <label for="ward">Phường</label>
                                                <form:input path="ward" cssClass="form-control"/>
                                            </div>
                                        </div>

                                        <div class="col-sm-4">
                                            <div>
                                                <label for="street">Đường</label>
                                                <form:input path="street" cssClass="form-control"/>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-4">
                                            <div>
                                                <label for="numberOfBasement">Số tầng hầm</label>
<%--                                                <input type="number" id="numberOfBasement" class="form-control">--%>
                                                <form:input path="numberOfBasement" cssClass="form-control"/>
                                            </div>
                                        </div>
                                        <div class="col-sm-4">
                                            <div>
                                                <label for="direction">Hướng</label>
<%--                                                <input type="type" id="direction" class="form-control">--%>
                                                <form:input path="direction" cssClass="form-control"/>
                                            </div>
                                        </div>
                                        <div class="col-sm-4">
                                            <div>
                                                <label for="level">Hạng</label>
                                                <form:input path="level" cssClass="form-control"/>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <div>
                                                <label for="rentAreaFrom">Diện tích từ</label>
                                                <input type="number" id="rentAreaFrom" class="form-control">
                                            </div>
                                        </div>

                                        <div class="col-sm-3">
                                            <div>
                                                <label for="rentAreaTo">Diện tích đến</label>
                                                <input type="number" id="rentAreaTo" class="form-control">
                                            </div>
                                        </div>

                                        <div class="col-sm-3">
                                            <div>
                                                <label for="rentCostFrom">Gía thuê từ</label>
                                                <input type="number" id="rentCostFrom" class="form-control">
                                            </div>
                                        </div>
                                        <div class="col-sm-3">
                                            <div>
                                                <label for="rentCostTo">Gía thuê đến</label>
                                                <input type="number" id="rentCostTo" class="form-control">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-4">
                                            <div>
                                                <label for="managerName">Tên quản lý</label>
<%--                                                <input type="type" id="managerName" class="form-control">--%>
                                                <form:input path="managerName" cssClass="form-control"/>
                                            </div>
                                        </div>
                                        <div class="col-sm-4">
                                            <div>
                                                <label for="managerPhone">Điện thoại quản lý</label>
                                                <form:input path="managerPhone" cssClass="form-control"/>
                                            </div>
                                        </div>
                                        <div class="col-sm-3">
                                            <div>
                                                <form:select path="staffId">
                                                    <form:option value="-1" label="--- Chọn nhân viên ---"/>
                                                    <form:options items="${staffmaps}"/>
                                                </form:select>"
                                                
<%--                                                <label for="staffId">Chọn nhân viên phụ trách</label>--%>
                                                <!-- <br/> -->
<%--                                                <select class="form-control" id="staffId">--%>
<%--                                                    <option value="">--Chọn nhân viên phụ trách--</option>--%>
<%--                                                    <option value="nguyenVanA">Nguyễn Văn A</option>--%>
<%--                                                    <option value="nguyenVanB">Nguyễn Văn B</option>--%>
<%--                                                    <option value="nguyenVanC">Nguyễn Văn C</option>--%>
<%--                                                    <option value="nguyenVanD">Nguyễn Văn D</option>--%>

<%--                                                </select>--%>
                                            </div>
                                        </div>
                                    </div>
                            </div>
                            <div class="form-group">
                                <div>
                                    <label class="checkbox-inline"><input type="checkbox" value="TANG_TRET" id="buildingTypes1" name="buildingTypes">Tầng trệt</label>
                                    <label class="checkbox-inline"><input type="checkbox" value="NGUYEN_CAN" id="buildingTypes2" name="buildingTypes">Nguyên căn</label>
                                    <label class="checkbox-inline"><input type="checkbox" value="NGUYEN_CAN" id="buildingTypes3" name="buildingTypes">Nội thất</label>
                                </div>
                            </div>
                            <div>
                                <button type="button" class="btn btn-sm btn-success" id="btnSearch">
                                    Tìm kiếm
                                </button>
                            </div>
                        </form:form>
                        </div>
                    </div>
                </div>
            </div><!-- /.row -->
            <div>
                <div class="col-xs-12">
                    <div class="pull-right">
                        <button class="btn btn-white btn-info btn-bold" data-toggle="tooltip"  title="Thêm tòa nhà">
                            <i class="fa fa-plus-circle" aria-hidden="true"></i>
                        </button>
                        <button class="btn btn-white btn-warning btn-bold"
                                data-toggle="tooltip" title="Xóa tòa nhà" id="btnDeleteBuilding">
                            <i class="fa fa-trash" aria-hidden="true"></i>
                        </button>
                    </div>
                </div>
            </div>
            </br>
        </div>
    </div>
    <div class="main-content-inner">
        <div class="page-content">
            <div class="row">
                <div>
                    <table id="buildingList" class="table table-striped table-bordered table-hover">
                        <thead>
                        <tr>
                            <th></th>
                            <th>Tên sản phẩm</th>
                            <th>Số tầng hầm</th>
                            <th>Địa chỉ</th>
                            <th>Tên quản lý</th>
                            <th>Số điện thoại</th>
                            <th>Diện tích sàn</th>
                            <th>Gía thuê</th>
                            <th>Phí dịch vụ</th>
                            <th>Thao tác</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="item" items="${buildings}">
                            <tr>
                                <td><input type="checkbox" value="1" id="checkbox1"></td>
                                <td>${item.name}</td>
                                <td>${item.numberOfBasement}</td>
                                <td>${item.street}</td>
                                <td>${item.managerName}</td>
                                <td>${item.managerPhone}</td>
                                <td>${item.floorArea}</td>
                                <td>111</td>
                                <td>111</td>
                                <td>
                                    <button class="btn btn-xs btn-info" data-toggle="tooltip"
                                            title="Giao tòa nhà" onclick="assingmentBuilding(1)">
                                        <i class="fa fa-bars" aria-hidden="true"></i>

                                    </button>
                                </td>
                            </tr>
                        </c:forEach>


                        </tbody>
                    </table>
                </div>
            </div>
        </div><!-- /.page-content -->
    </div>
</div>

<div class="modal fade" id="assingmentBuildingModal" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Danh sách nhân viên</h4>
            </div>
            <div class="modal-body">
                <table class="table">
                    <thead>
                    <tr>
                        <th>Chọn nhân viên</th>
                        <th>Tên nhân viên</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td><input type="checkbox" value="2" id="checkbox_2"></td>
                        <td>Nguyen Van B</td>
                    </tr>
                    <tr>
                        <td><input type="checkbox" value="3" id="checkbox_3"></td>
                        <td>Nguyen Van C</td>
                    </tr>
                    <tr>
                        <td><input type="checkbox" value="4" id="checkbox_4"></td>
                        <td>Nguyen Van D</td>
                    </tr>
                    </tbody>
                </table>
                <input type="hidden" id="buildingId" name="buildingId" value="">
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" id="btnAssignBuilding">Giao tòa nhà</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">Đóng</button>
            </div>

        </div>

    </div>
</div>
<script>
    function assingmentBuilding(buildingId) {
        openModalAssingmentBuilding();
        $('#buildingId').val(buildingId);
        console.log($('#buildingId').val());

    }

    function openModalAssingmentBuilding() {
        $('#assingmentBuildingModal').modal();
    }
    $('#btnAssignBuilding').click(function (e) {
        e.preventDefault();
        var data = {}
        var staffs = []
        data['buildingId'] = $('#buildingId').val();
        //   $('#staffList').find('tbody input[type=checkbox]')
        //   staffId.push()
        var staffs = ('#staffList').find('tbody input[type=checkbox]:checked').map(function () {
            return $(this).val();
        }).get();
        data['staffs'] = staffs;
        assignment(data);



    });

    function assignment(data) {
        $.ajax({
            type: "POST",
            url: "http://localhost:8081/api-user",
            data: JSON.stringify(data),
            dataType: "json",
            contentType : "application/json",
            success: function (response) {
                console.log('success');
            },
            error: function (response) {
                console.log('failed');
                console.log(response);
            }
        });
    }

    $('#btnDeleteBuilding').click(function (e) {
        e.preventDefault();
        var data = {};
        var buildingIds = ('#buildingList').find('tbody input[type=checkbox]:checked').map(function () {
            return $(this).val();
        }).get();
        data['buildingIds'] = buildingIds;
        deleteBuilding(data);
    });



    function deleteBuilding(data) {
        $.ajax({
            type: "DELETE",
            url: "http://localhost:8081/api-building",
            data: JSON.stringify(data),
            dataType: "json",
            contentType : "application/json",
            success: function (response) {
                console.log('success');
            },
            error: function (response) {
                console.log('success');
                console.log(response);
            }
        });
    }
    $('#btnSearch').click(function (e) {
        e.preventDefault();
        $('#listForm').submit();

    });
</script>
</body>

</html>