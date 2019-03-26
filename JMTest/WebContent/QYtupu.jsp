<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>企业图谱信息展示</title>
    <!-- 引入 echarts.js -->
    <script src="echarts.js"></script>
    <script src="js/jquery.min.js"></script>
    
</head>
<body>
       		
    <!-- 为ECharts准备一个具备大小（宽高）的Dom -->
    <h1 align="center">企业图谱</h1>
    <div id="main" style="width: 1000px;height:800px; " align="center"></div>
    
    <input style="display: none" type="text" id="CORP_NAME" value="${sessionScope.needBeanQ[0].CORP_NAME}" />
    <input style="display: none" type="text" id="PERSON_NAME" value="${sessionScope.needBeanQ[0].PERSON_NAME}" />
    <input style="display: none" type="text" id="PERSON_TYPE" value="（总经理）${sessionScope.needBeanQ[0].PERSON_TYPE}" />
    <input style="display: none" type="text" id="OPER_MAN_NAME" value="${sessionScope.needBeanQ[0].OPER_MAN_NAME}" />
    <input style="display: none" type="text" id="DIST_NAME" value="${sessionScope.needBeanT[0].DIST_NAME}" />
        <input style="display: none" type="text" id="REG_CAPI" value="${sessionScope.needBeanT[0].REG_CAPI}" />
    <input style="display: none" type="text" id="STOCK_NAME" value="${sessionScope.needBeanG[0].STOCK_NAME}" />
    <input style="display: none" type="text" id="STOCK_CAPI" value="${sessionScope.needBeanG[0].STOCK_CAPI}" />
    
   
    <script type="text/javascript">
	var CORP_NAME = $("#CORP_NAME").attr('value');
	var PERSON_NAME = $("#PERSON_NAME").attr('value');
	var PERSON_TYPE = $("#PERSON_TYPE").attr('value');
	var OPER_MAN_NAME = $("#OPER_MAN_NAME").attr('value');
	var DIST_NAME = $("#DIST_NAME").attr('value');
	var REG_CAPI = $("#REG_CAPI").attr('value');
	var STOCK_NAME = $("#STOCK_NAME").attr('value');
	var STOCK_CAPI = $("#STOCK_CAPI").attr('value');
    
    var myChart = echarts.init(document.getElementById('main'));
    myChart.showLoading();


    var data2 = [{
        name: CORP_NAME,
        label: {
            normal: {
                backgroundColor: '#725bb8'
            }
        },
        children: [{
            name: "对外投资",
            children: [{
                name: DIST_NAME
            }]
        }, {
            name: "法定代表人",
            children: [{
                name: OPER_MAN_NAME
            }]
        }, {
            name: "投资方",
            children: [{
                name: STOCK_NAME
            }]
        }, {
            name: PERSON_TYPE,
            children: [{
                name: PERSON_NAME
            }]
        }]
    }];

    myChart.hideLoading();

    myChart.setOption(option = {
        backgroundColor: '',
        tooltip: {
            trigger: 'item',
            formatter: '{b}'
        },
        legend: {
            top: '2%',
            left: '3%',
            bottom: '2%',
            orient: 'radial',
           
            textStyle:{
                color:'#fff'
            }
        },
        series: [{
                type: 'tree',
                name: ' ',
                data: data2,
                top: '1%',
                right: '50%',
                symbolSize: 1,
                initialTreeDepth: 10,
                label: {
                    normal: {
                        position: 'center',
                        verticalAlign: 'middle',
                        align: 'left',
                        backgroundColor: '',
                        color: '#fff',
                        padding: 3,
                        formatter: [
                            '{box|{b}}'
                        ].join('\n'),
                        rich: {
                            box: {
                                height: 30,
                                color: '#fff',
                                padding: [0, 5],
                                align: 'center'
                            }
                        }
                    }
                },
                leaves: {
                    label: {
                        normal: {
                            position: 'center',
                            verticalAlign: 'middle',
                            align: 'left',
                            backgroundColor: '#c44eff',
                            formatter: [
                                '{box|{b}}'
                            ].join('\n'),
                            rich: {
                                box: {
                                    height: 18,
                                    color: '#fff',
                                    padding: [0, 5],
                                    align: 'center'
                                }
                            }
                        }
                    }
                },
                expandAndCollapse: true,
                animationDuration: 550,
                animationDurationUpdate: 750
            },
            {
                type: 'tree',
                name: ' ',
                data: data2,
                top: '1%',
                right: '50%',
                symbolSize: 1,
                initialTreeDepth: 10,
                label: {
                    normal: {
                        position: 'center',
                        verticalAlign: 'middle',
                        align: 'left',
                        backgroundColor: '#7049f0',
                        color: '#fff',
                        padding: 3,
                        formatter: [
                            '{box|{b}}'
                        ].join('\n'),
                        rich: {
                            box: {
                                height: 30,
                                color: '#fff',
                                padding: [0, 5],
                                align: 'center'
                            }
                        }
                    }
                },
                leaves: {
                    label: {
                        normal: {
                            position: 'center',
                            verticalAlign: 'middle',
                            align: 'left',
                            backgroundColor: '#c44eff',
                            formatter: [
                                '{box|{b}}'
                            ].join('\n'),
                            rich: {
                                box: {
                                    height: 18,
                                    color: '#fff',
                                    padding: [0, 5],
                                    align: 'center'
                                }
                            }
                        }
                    }
                },
                expandAndCollapse: true,
                animationDuration: 550,
                animationDurationUpdate: 750
            }
        ]
    });
    myChart.on('legendselectchanged', function (params) {
        // 获取点击图例的选中状态
        var isSelected = params.selected[params.name];
        // 在控制台中打印
        console.log((isSelected ? '选中了' : '取消选中了') + '图例' + params.name);
        // 打印所有图例的状态
        console.log(params.selected);
    })
   </script>
    <!-- -------------------------------------投资出资情况---------------------------------- -->
      
</body>
</html>