<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<c:url var="buildingAPI" value="/api/building "/>
<html>
<head>
    <title>Chỉnh sửa tòa nhà</title>
</head>
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
                <div class="col-xs-12">
                    <form class="form-horizontal" role="form" id="formEdit">
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="name">Tên tòa nhà</label>
                            <div class="col-sm-9">
                                <input type="text" id="name" class="form-control" name="name" value=""/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="staffId">Người quản lý sản phẩm</label>
                            <div class="col-sm-9">
                                <input type="text" id="staffId" class="form-control" name="staffId"/>
                            </div>
                        </div>

                        <%--<div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="district">Quận</label>
                            <div class="col-sm-9">
                                <input type="text" id="district" class="form-control" name="district"/>
                            </div>
                        </div>--%>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="ward">Phường</label>
                            <div class="col-sm-9">
                                <input type="text" id="ward" class="form-control" name="ward" value=""/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="street">Đường</label>
                            <div class="col-sm-9">
                                <input type="text" id="street" class="form-control" name="street" value=""/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="stucture">Kết cấu</label>
                            <div class="col-sm-9">
                                <input type="text" id="stucture" class="form-control" name="stucture" />
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="numberOfBasement">Số tầng hầm</label>
                            <div class="col-sm-9">
                                <input type="number" id="numberOfBasement" class="form-control" name="numberOfBasement"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="floorArea">Diện tích sàn</label>
                            <div class="col-sm-9">
                                <input type="number" id="floorArea" class="form-control" name="floorArea" />
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="direction">Hướng</label>
                            <div class="col-sm-9">
                                <input type="text" id="direction" class="form-control" name="direction" />
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="level">Hạng</label>
                            <div class="col-sm-9">
                                <input type="text" id="level" class="form-control" name="level" />
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="rentArea">Diện tích thuê</label>
                            <div class="col-sm-9">
                                <input type="text" id="rentArea" class="form-control" name="rentArea" />
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="rentAreaDescription">Mô tả diện tích</label>
                            <div class="col-sm-9">
                                <input type="text" id="rentAreaDescription" class="form-control" name="rentAreaDescription" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="costDescription">Mô tả giá</label>
                            <div class="col-sm-9">
                                <input type="number" id="costDescription" class="form-control" name="costDescription" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="serviceCost">Phí dịch vụ</label>
                            <div class="col-sm-9">
                                <input type="text" id="serviceCost" class="form-control" name="serviceCost" />
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="carCort">Phí ô tô</label>
                            <div class="col-sm-9">
                                <input type="text" id="carCort" class="form-control" name="carCort" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="motorCort">Phí mô tô</label>
                            <div class="col-sm-9">
                                <input type="text" id="motorCort" class="form-control" name="motorCort" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="overtimeCort">Phí ngoài giờ</label>
                            <div class="col-sm-9">
                                <input type="text" id="overtimeCort" class="form-control" name="overtimeCort" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="electricBill">Tiền điện</label>
                            <div class="col-sm-9">
                                <input type="text" id="electricBill" class="form-control" name="electricBill" />
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="deposit">Đặt cọc</label>
                            <div class="col-sm-9">
                                <input type="text" id="deposit" class="form-control" name="deposit" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="payment">Thanh toán</label>
                            <div class="col-sm-9">
                                <input type="text" id="payment" class="form-control" name="payment" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="timeRent">Thời hạn thuê</label>
                            <div class="col-sm-9">
                                <input type="text" id="timeRent" class="form-control" name="timeRent" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="timeDecorator">Thời gian trang trí</label>
                            <div class="col-sm-9">
                                <input type="text" id="timeDecorator" class="form-control" name="timeDecorator" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="managerName">Tên quản lí</label>
                            <div class="col-sm-9">
                                <input type="text" id="managerName" class="form-control" name="managerName" />
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="managerPhone">Số điện thoại quản lí</label>
                            <div class="col-sm-9">
                                <input type="number" id="managerPhone" class="form-control" name="managerPhone" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="costTips">Phí môi giới</label>
                            <div class="col-sm-9">
                                <input type="number" id="costTips" class="form-control" name="costTips" />
                            </div>
                        </div>

                       <%-- <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">Loại tòa nhà</label>
                            <div class="col-sm-9">
                                <label class="checkbox-inline"><input type="checkbox" value="TANG_TRET" id="buildingTypes1" name="buildingTypes">Tầng trệt</label>
                                <label class="checkbox-inline"><input type="checkbox" value="NGUYEN_CAN" id="buildingTypes2" name="buildingTypes">Nguyên căn</label>
                                <label class="checkbox-inline"><input type="checkbox" value="NGUYEN_CAN" id="buildingTypes3" name="buildingTypes">Nội thất</label>
                            </div>
                        </div>--%>
                        <div class="form-group">
<%--                            <label class="col-sm-3 control-label no-padding-right"></label>--%>
                            <div class="col-sm-9">
                                <button type="button" class="btn btn-primary" id="btnAddBuilding">Thêm tòa nhà</button>
                                <button type="button" class="btn btn-primary">Hủy</button>
                            </div>
                        </div>

                    </form>
                </div>
            </div><!-- /.row -->
        </div><!-- /.page-content -->
    </div>
</div><!-- /.main-content -->
<script>
    $('#btnAddBuilding').click(function(e) {
        e.preventDefault();
        var data = {};
        var buildingTypes = [];
        var formData = $('#formEdit').serializeArray();
        /* $.each(formData, function (index, v) {
             if (v.name == 'buildingTypes') {
                 buildingTypes.push(v.value);
             } else {
                 data["" +v.name+ ""] = v.value;
             }
         });
         data['buildingTypes'] = buildingTypes; */
        $.each(formData, function (index, v) {
            data["" + v.name + ""] = v.value;

        });

        $.ajax({
            type: 'POST',
            url: '${buildingAPI}',
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

    });
    function assginmentBuilding() {
        openModalAssingmentBuilding();
    }
</script>
</html>
