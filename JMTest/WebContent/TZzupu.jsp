<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="Mes.*"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>投资族谱信息展示</title>
    <!-- 引入 echarts.js -->
    <script src="echarts.js"></script>
    <script src="js/jquery.min.js"></script>
</head>
<body>
				
        <h1 align="center">投资以及出资占比</h1>
    <!-- 为ECharts准备一个具备大小（宽高）的Dom -->
    <div id="main" style="width: 1000px;height:800px; margin-left: 300px"></div>
    
    <input style="display: none" type="text" id="CORP_NAME" value="${sessionScope.needBeanT[0].CORP_NAME}" />
    <input style="display: none" type="text" id="OPER_MAN_NAME" value="${sessionScope.needBeanT[0].OPER_MAN_NAME}" />
    <input style="display: none" type="text" id="DIST_NAME" value="${sessionScope.needBeanT[0].DIST_NAME}" />
    <input style="display: none" type="text" id="STOCK_NAME" value="${sessionScope.needBeanG[0].STOCK_NAME}" />
    <input style="display: none" type="text" id="STOCK_CAPI" value="${sessionScope.needBeanG[0].STOCK_CAPI}" />
    <input style="display: none"  type="text" id="REG_CAPI" value="${sessionScope.needBeanT[0].REG_CAPI}" />
    
    <script type="text/javascript">
        // 基于准备好的dom，初始化echarts实例
        
        		var STOCK_CAPI = $("#STOCK_CAPI").attr('value');
        		var STOCK_NAME = $("#STOCK_NAME").attr('value');
        		var CORP_NAME = $("#CORP_NAME").attr('value');
        		var OPER_MAN_NAME = $("#OPER_MAN_NAME").attr('value');
        		var REG_CAPI = $("#REG_CAPI").attr('value');
        		var DIST_NAME = $("#DIST_NAME").attr('value');
                var myChart = echarts.init(document.getElementById('main'));
                var json = {
                		
                	    "series": [{

                	        "type": "tree",
                	        "data": [{
                	            "name":CORP_NAME,
                	            "children": [{
                	                "name": "对外投资",
                					value:" 1966488",
                	                "children": [{
                	                    "name":DIST_NAME ,
                	                    "value":REG_CAPI  
                	                },
                	                {
                	                    "name":REG_CAPI  
                	                }
                	                ]
                	            },{
                	                "name": "股东",
                	                "children": [
                	                {
                	                    "name": STOCK_NAME,
                	                    "value":STOCK_CAPI
                	                },
                	                {
                	                    "name": STOCK_CAPI
                	                   
                	                }
                	                ]
                	            }]
                	        }],
                	        "itemStyle":{ //设置边框的属性
                				normal: {
                					color:'#40b2f8',
                					borderWidth:0
                				}
                			},
                			label:{ //内容位置等属性
                				normal: {
                	                verticalAlign: 'middle',
                	                align: 'center',
                	                fontSize: 13,
                					color:'#FFF'
                	            }
                			},
                			lineStyle:{  //连线颜色
                				normal: {
                					color:'#ccc', 
                					width:1.5
                				}
                			},
                			emphasis:{
                				
                			},
                			leaves:{
                				label:{show:true}
                			},
                			"top": "10%",
                	        "left": "0%",
                	        "bottom": "20%",
                	        "right": "20%",
                	        "symbolSize": [180, 50],

                	        "expandAndCollapse": true,
                	        "animationDuration": 550,
                	        "animationDurationUpdate": 750,
                	        "orient": "vertical",
                	        "symbol": "rect",
                			"initialTreeDepth": 2,
                	    }]
                	};					   
             			myChart.setOption(json);
             			myChart.on('click',function(params){
             			alert(params.value);
             	})
    </script>
    <!-- -------------------------------------投资出资情况---------------------------------- -->
      
</body>
</html>