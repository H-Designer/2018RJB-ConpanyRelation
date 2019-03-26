<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
 <meta charset="utf-8">
    <title>疑似关系信息展示</title>
    <!-- 引入 echarts.js -->
    <script src="echarts.js"></script>
    <script src="js/jquery.min.js"></script>
</head>
<body>
    <!-- 为ECharts准备一个具备大小（宽高）的Dom -->
    <h1 align="center">疑似关系</h1>
    
    <div id="main" style="width: 1000px;height:1000px;"></div>
    
    <input style="display:none " type="text" id="CORP_NAME" value="${sessionScope.needBeanY[0].CORP_NAME}" />
    <input style="display:none " type="text" id="OPER_MAN_NAME" value="${sessionScope.needBeanY[0].OPER_MAN_NAME}" />
    <input style="display:none " type="text" id="OPER_MAN_TYPE" value="法定代表人" />
    <input style="display:none " type="text" id="PERSON_NAME" value="${sessionScope.needBeanY[0].PERSON_NAME}" />
    <input style="display:none " type="text" id="PERSON_TYPE" value="（总经理）${sessionScope.needBeanY[0].PERSON_TYPE}" />
    <input style="display:none" type="text" id="STOCK_NAME" value="${sessionScope.needBeanG[0].STOCK_NAME}" />
    <input style="display:none "  type="text" id="DIST_NAME" value="${sessionScope.needBeanT[0].DIST_NAME}" />
    
    <script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main'));
    var CORP_NAME = $("#CORP_NAME").attr('value');
	var OPER_MAN_NAME = $("#OPER_MAN_NAME").attr('value');
	var OPER_MAN_TYPE = $("#OPER_MAN_TYPE").attr('value');
	var PERSON_NAME = $("#PERSON_NAME").attr('value');
	var PERSON_TYPE = $("#PERSON_TYPE").attr('value');
	var STOCK_NAME = $("#STOCK_NAME").attr('value');
	var DIST_NAME = $("#DIST_NAME").attr('value');
option = {
    tooltip: {},
    animationDurationUpdate: 1500,
    animationEasingUpdate: 'quinticInOut',
    label: {
        normal: {
            show: true,
            textStyle: {
                fontSize: 14
            },
        }
    },
    legend: {
        x: "center",
    },
    series: [

        {
            type: 'graph',
            layout: 'force',
            symbolSize: 50,
            focusNodeAdjacency: true,
            roam: true,
            categories: [
               
            {
                name: ' '
            },
            {
                name: ' '
            }],
            label: {
                normal: {
                    show: true,
                    textStyle: {
                        fontSize:14
                    },
                }
            },
            force: {
                repulsion: 2000
            },
            //edgeSymbol: ['pin'],
            //edgeSymbolSize: [1, 10],
            edgeLabel: {
                normal: {
                    show: true,
                    textStyle: {
                        fontSize: 13
                    },
                    formatter: "{c}"
                }
            },
            data: [ 
            {
                name: OPER_MAN_NAME,
                category: 0
            },
            {
                name: DIST_NAME,
                category: 0             
            },
            {
                name: STOCK_NAME,
                category: 0  
            },
            
            {
                name:CORP_NAME,
                category: 0,
                //symbolSize: [250, 250],
                 draggable: true,
            },
            
            {
                name: PERSON_NAME,
                category: 0,
                draggable: true,
            }
            ],
            links: [{
            	
            	
                source: CORP_NAME,
                target: STOCK_NAME,
                value: '投资方',
                lineStyle:{
                    normal:{
                        color:'#003D79',
                    }
                }
                
            }, 
            {
            	source: CORP_NAME,
                target: DIST_NAME,
                value: '外资投资',
                lineStyle:{
                    normal:{
                        color:'#003D79',
                     //   type:'dotted'
                    }
                }
            }, 
            {
            	source: CORP_NAME,
                target: PERSON_NAME,
                value: PERSON_TYPE,
                lineStyle:{
                    normal:{
                        color:'#003D79',
                    }
                }
            }, 
            {
            	source: CORP_NAME,
                target: OPER_MAN_NAME,
                value: OPER_MAN_TYPE,
                lineStyle:{
                    normal:{
                        color:'#003D79',
                    //    type:'dotted'
                    }
                }                
            }, 
          
            ],
            lineStyle: {
                normal: {
                    opacity: 0.7,
                    width: 1,
                    curveness: 0.1
                }
            }
        }
    ]
};
  myChart.setOption(option);
    </script>
</body>
</html>