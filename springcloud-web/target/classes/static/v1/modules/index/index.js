$.namespace("fm");
fm={
    initTable: function () {

        $('#myTable').bootstrapTable({
            method: 'post',
            url: '/springcloud/page',
            pagination:'true',
            sidePagination:'server',
            pageSize:5,
            search: 'true',
            queryParams: function query(params){
                params['name']=$('#myName').val();
                return params;
            },
            pageList: [5,10,20],
            columns:[
                {checkbox:'true'},
                {field:"id",title:"序号123",align:"center"},
                {field:"name",title:"姓名",align:"center"},
                {field:"age",title:"年龄",align:"center"},
                {field:"",title:"操作",align:"center",
                formatter:function (value,row,index) {

                    return "<a href='#' onclick='fm.test()' class='glyphicon glyphicon-ok'></a>"
                        +"<a href='#' onclick='fm.test()' class='glyphicon glyphicon-remove'></a>";
                }}
            ]
        });
    },
    query: function () {
        $('#myTable').bootstrapTable('refresh');
    },
    reset: function () {
        document.getElementById("searchForm").reset();
    },
    test : function () {
        layer.alert("hello")
    }
};
$(function () {
    fm.initTable();
});