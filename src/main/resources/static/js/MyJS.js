/*正则表达式验证输入框元素，失去焦点时触发，不符合则在spanId显示结果*/
function myRegCheck(idElem,reg,spanElem) {
    //创建正则规则
    idElem.on("blur",function(){
        //校验并返回结果
        if(idElem.val()==""||idElem.val()==null){
            //空串
            spanElem.html(idElem.attr("alt")+"不能为空");
            return false;
        }else if(reg.test(idElem.val())){
            //验证成功
            spanElem.html("√");
            return true;
        }else{
            //验证失败
            spanElem.html("×");
            return false;
        }
    });
}
//自动将form表单封装成json对象
$.fn.serializeObject = function()
{
    var o = {};
    var a = this.serializeArray();
    $.each(a, function() {
        if (o[this.name]) {
            if (!o[this.name].push) {
                o[this.name] = [o[this.name]];
            }
            o[this.name].push(this.value || '');
        } else {
            o[this.name] = this.value || '';
        }
    });
    return o;
};
$( "#button-box-7 button" ).onclick = function () {
    Dialog({
        title: "标题",
        width: 1100,
        iframeContent: {
            src: "http://www.baidu.com/",
            height: 600
        },
        showButton: false
    });
}