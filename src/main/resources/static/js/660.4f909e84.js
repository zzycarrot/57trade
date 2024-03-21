"use strict";(self["webpackChunkvue_project"]=self["webpackChunkvue_project"]||[]).push([[660],{6660:function(t,e,s){s.r(e),s.d(e,{default:function(){return u}});var i=function(){var t=this,e=t._self._c;return e("div",[e("el-container",[e("el-header",{staticStyle:{height:"5%"}}),e("el-main",{staticStyle:{display:"flex","flex-direction":"column"}},[e("div",[e("div",{staticStyle:{display:"flex",width:"auto","flex-direction":"column","align-items":"center","justify-content":"center"}},[e("el-input",{staticStyle:{width:"auto"},attrs:{placeholder:"请输入..."},model:{value:t.input3,callback:function(e){t.input3=e},expression:"input3"}},[e("el-button",{attrs:{slot:"append",icon:"el-icon-search"},on:{click:t.search},slot:"append"})],1)],1)]),e("div",{staticStyle:{height:"45px"}}),e("div",{staticStyle:{display:"flex"}},[e("div",{staticStyle:{width:"150px"}}),e("div",{staticStyle:{width:"250px",height:"750px",background:"#ffffff","border-radius":"6px"}},[e("el-row",{staticClass:"tac",staticStyle:{width:"auto",height:"750px",background:"#ffffff","border-radius":"6px"}},[e("el-col",{attrs:{span:24}},[e("el-menu",{staticStyle:{"line-height":"25px"},attrs:{"default-active":"3"}},[e("div",{staticStyle:{height:"10px"}}),e("el-menu-item",{attrs:{index:"1"}},[e("i",{staticClass:"el-icon-picture-outline-round"}),e("span",{attrs:{slot:"title"},on:{click:t.hand1},slot:"title"},[t._v("道具专区")])]),e("el-menu-item",{attrs:{index:"2"}},[e("i",{staticClass:"el-icon-mouse"}),e("span",{attrs:{slot:"title"},on:{click:t.hand2},slot:"title"},[t._v("宠物专区")])]),e("el-menu-item",{attrs:{index:"3"}},[e("i",{staticClass:"el-icon-s-custom"}),e("span",{attrs:{slot:"title"},on:{click:t.hand3},slot:"title"},[t._v("账号专区")])]),e("el-menu-item",{attrs:{index:"4"}},[e("i",{staticClass:"el-icon-s-check"}),e("span",{attrs:{slot:"title"},on:{click:t.hand4},slot:"title"},[t._v("代练专区")])]),e("el-menu-item",{attrs:{index:"5"}},[e("i",{staticClass:"el-icon-s-goods"}),e("span",{attrs:{slot:"title"},on:{click:t.hand5},slot:"title"},[t._v("求购专区")])]),e("el-menu-item",{attrs:{index:"6"}},[e("i",{staticClass:"el-icon-setting"}),e("span",{attrs:{slot:"title"},on:{click:t.hand6},slot:"title"},[t._v("攻略专区")])]),e("el-menu-item",{attrs:{index:"7"}},[e("i",{staticClass:"el-icon-setting"}),e("span",{attrs:{slot:"title"},on:{click:t.hand7},slot:"title"},[t._v("工具专区")])]),e("el-menu-item",{attrs:{index:"8"}},[e("i",{staticClass:"el-icon-warning-outline"}),e("span",{attrs:{slot:"title"},on:{click:t.hand8},slot:"title"},[t._v("骗子专区")])])],1),e("div",{staticStyle:{display:"flex","justify-content":"center"}},[e("div",{staticStyle:{position:"relative",width:"240px",height:"165px","overflow-y":"hidden","margin-top":"-35px","z-index":"2"}},[e("img",{staticStyle:{height:"100%",width:"auto","/* 将宽度设置为自动，以保持原始比例 */\n        position":"relative","z-index":"2"},attrs:{src:s(9384)}})])])],1)],1)],1),e("div",{staticStyle:{width:"60px"}}),e("div",{staticStyle:{top:"5%",right:"150px",height:"auto",flex:"1",background:"#ffffff","border-radius":"6px"}},[e("div",{staticStyle:{height:"25px"}}),e("div",{staticStyle:{display:"flex"}},[e("div",{staticStyle:{width:"40px"}}),e("div"),e("div",{staticStyle:{width:"50%"}}),e("div",{staticStyle:{flex:"1"}},[e("div",[e("el-button",{attrs:{type:"warning",size:"mini",round:""},on:{click:t.getHotRanking}},[t._v("热销排行")]),e("el-button-group",[e("el-button",{attrs:{type:"success",size:"mini",round:""},on:{click:t.moren}},[t._v("默认排序")]),e("span",{staticClass:"kong"},[e("span",{staticClass:"arrUp",attrs:{type:"text"},on:{click:t.moren22}}),e("span",{staticClass:"arrDown",attrs:{type:"text"},on:{click:t.daoxu}})])],1),e("span",[t._v("价格")]),e("el-input-number",{staticStyle:{"z-index":"0",width:"70px"},attrs:{min:0,max:1e19,label:"最小值",size:"mini",controls:!1},model:{value:t.number1,callback:function(e){t.number1=e},expression:"number1"}}),e("span",[t._v("-")]),e("el-input-number",{staticStyle:{"z-index":"0",width:"70px"},attrs:{min:0,max:1e19,label:"最大值",size:"mini",controls:!1},model:{value:t.number2,callback:function(e){t.number2=e},expression:"number2"}}),e("el-button-group",[e("el-button",{attrs:{type:"info",size:"mini",round:""},on:{click:t.handleCalculate}},[t._v("筛选")]),e("span",{staticClass:"kong"},[e("span",{staticClass:"arrUp",attrs:{type:"text"},on:{click:t.clickUp}}),e("span",{staticClass:"arrDown",attrs:{type:"text"},on:{click:t.clickDown}})])],1)],1)])]),e("div",{staticStyle:{height:"20px"}}),e("div",{staticStyle:{display:"flex"}},[e("div",{staticStyle:{width:"55px"}}),e("div",{staticStyle:{width:"100%",height:"600px",flex:"1","overflow-y":"auto"}},[e("el-row",{attrs:{gutter:0}},t._l(t.carts.slice(0,12),(function(s,i){return e("el-col",{key:s.id,attrs:{span:5,offset:i>0?1.8:0}},[e("el-card",{staticStyle:{width:"100%",height:"100%"}},[e("div",{staticStyle:{padding:"0"}},[e("div",{staticStyle:{height:"50px",top:"0",left:"0",right:"0"}},[e("img",{staticStyle:{cursor:"pointer",width:"100%",height:"80px",top:"0"},attrs:{src:t.getFullImagePath(s.image)},on:{click:function(e){t.showPopup(t.getFullImagePath(s.image))}}}),t.isPopupVisible?e("div",{staticClass:"popup"},[e("div",{staticClass:"popup-content"},[e("img",{staticClass:"popup-photo",attrs:{src:t.popupPhotoUrl}}),e("span",{staticClass:"close-btn",on:{click:t.closePopup}},[t._v("×")])])]):t._e()]),e("div",{staticStyle:{height:"25px"}}),e("div",[e("span",[t._v("账号描述:")]),t._v(" "),e("span",[t._v(t._s(s.name))])]),e("span",[t._v(" 账号价格:")]),e("span",[t._v(t._s(s.price))]),e("div",{staticClass:"bottom clearfix"},[e("div",[e("span",[t._v("联系QQ:")]),e("span",[t._v(t._s(s.qq))])])])])])],1)})),1)],1)]),e("div",{staticClass:"block",staticStyle:{display:"flex","flex-direction":"column","margin-top":"auto"}},[e("el-pagination",{attrs:{layout:" total,prev, pager, next,jumper",total:parseInt(t.total),"page-size":t.pagesize,"current-page":t.currentPage},on:{"size-change":t.handleSizeChange,"current-change":t.handlePageChange}})],1)]),e("div",{staticStyle:{width:"110px"}})])])],1)],1)},a=[],n=(s(4114),s(5111)),o=s(9143),l={data(){return{equipmentId:"",carts:[],chaxun:{},ad:{},prev:0,next:0,id:"",input3:"",input:"",activeName:"first",number1:null,number2:null,num1:null,num2:null,ishot:0,cost:"",latest:0,isPopupVisible:!1,chaui:!1,addui:!1,popupPhotoUrl:"",currentPage:1,pagesize:12,total:""}},methods:{clickUp(){this.cost=1,this.latest=0,this.moren()},clickDown(){this.cost=0,this.latest=0,this.moren()},daoxu(){this.latest=1,this.cost=2,this.num1="",this.num2="",this.moren()},handleCalculate(){this.num1=this.number1,this.num2=this.number2,this.moren()},getHotRanking(){this.ishot=1,this.moren(),this.ishot=0},search(){this.input=this.input3,this.moren()},moren22(){this.latest=0,this.cost=2,this.num1="",this.num2="",this.moren()},moren(){n.A.get("/accountPage",{params:{BeginPrice:this.num1,EndPrice:this.num2,ishot:this.ishot,page:this.currentPage,pagesize:this.pagesize,name:this.input,cost:this.cost,latest:this.latest}}).then((t=>{console.log(t),this.carts=t.data.data.rows}))},handlePageChange(t){this.currentPage=t,console.log(this.currentPage),n.A.get("/accountPage",{params:{BeginPrice:this.num1,EndPrice:this.num2,ishot:this.ishot,page:this.currentPage,pagesize:this.pagesize,name:this.input,cost:this.cost,latest:this.latest}}).then((t=>{console.log(t),this.carts=t.data.data.rows,this.total=t.data.data.total})).catch((t=>{console.error("获取数据时出错:",t)}))},handleSizeChange:function(t){this.pagesize=t,console.log(this.pagesize)},getFullImagePath(t){return s(7565)("./"+t)},cha(t){const e=parseInt(t);n.A.get(`/account/${e}`).then((t=>{console.log(t),this.chaxun=t.data.data,this.chaui=!0}))},delet(){const t=parseInt(this.chaxun.id);n.A.delete(`/account/${t}`).then((t=>{1===t.data.code&&(console.log("删除成功:",t.data),o.Message.success("删除成功"),this.chaxun={},location.reload())})).catch((t=>{console.error("删除资源时出错：",t),o.Message.error("删除失败")}))},xiugai(){this.chaui=!1;const t={name:this.chaxun.name,price:this.chaxun.price,qq:this.chaxun.qq,image:this.chaxun.image,weight:this.chaxun.weight,id:this.chaxun.id};n.A.post("/account/update",null,{params:t}).then((t=>{1===t.data.code?(console.log("修改成功:",t.data),o.Message.success("修改成功"),this.chaxun={},location.reload(),o.Message.success("修改成功")):o.Message.error("修改失败: "+t.data.msg)})).catch((t=>{console.error("请求异常:",t),o.Message.error("修改失败: ")}))},quxiao(){this.addui=!1,this.ad=[]},add(){const t={name:this.ad.name,price:this.ad.price,qq:this.ad.qq,image:this.ad.image,weight:this.ad.weight};n.A.post("/account",null,{params:t}).then((t=>{1===t.data.code?(console.log("添加成功:",t.data),o.Message.success("添加成功"),this.ad={},location.reload()):o.Message.error("添加失败: "+t.data.msg)})).catch((t=>{console.error("请求异常:",t),o.Message.error("添加失败")}))},beforeAvatarUpload(t){const e=52428800;if(t.size>e)return o.Message.error("上传的文件大小不能超过50MB"),!1;const s=t.type;if("image/jpeg"!==s&&"image/png"!==s)return o.Message.error("上传的文件格式必须为 JPG 或 PNG"),!1;this.equipmentId=t.name;const i=new FormData;return i.append("file",t),i.append("equipmentId",`${this.equipmentId}.txt`),n.A.post("/uploadFile",i,{headers:{"Content-Type":"multipart/form-data"}}).then((t=>{1===t.data.code?(this.ad.image=t.data.data,this.chaxun.image=t.data.data,console.log("上传成功:",t.data),o.Message.success("上传成功")):o.Message.error("上传失败: "+t.data.msg)})).catch((t=>{console.error("请求异常:",t),o.Message.error("上传失败")})),!1},fetchData(){n.A.get("/account").then((t=>{console.log(t),this.carts=t.data.data}))},hand1(){this.$router.push("/home")},hand2(){this.$router.push("/pet01")},hand3(){this.$router.push("/account")},hand4(){this.$router.push("/practise")},hand5(){this.$router.push("/qiu")},hand6(){this.$router.push("/lue")},hand7(){this.$router.push("/tool")},hand8(){this.$router.push("/pianzi")},hand11(){this.$router.push("/home")},hand12(){this.$router.push("/proop02")},hand13(){this.$router.push("/proop03")},showPopup(t){this.popupPhotoUrl=t,this.isPopupVisible=!0},closePopup(){this.isPopupVisible=!1}},mounted(){this.handlePageChange(this.currentPage)}},c=l,r=s(1656),h=(0,r.A)(c,i,a,!1,null,null,null),u=h.exports}}]);
//# sourceMappingURL=660.4f909e84.js.map