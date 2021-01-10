$(function(){
    // console.log("aaaaaaaaaaaaaa");
    // 进入页面时加载数据
    $.ajax({
        // url: 'http://localhost:8080/requestAllUser',
        url: 'http://121.196.145.152:8080/MyBlog/requestAllUser',
        dataType: 'json',
        type: 'POST',
        cache: false,
        success: function (res) {
            console.log("status: " + res.status);
            let tbodyTrHtml = "";
            if (res.status == 1){
                console.log(res.users);
                let users = res.users;
                for (let index in users) {
                    let trHtml = '<label style="display: none;" class="userId">'+users[index].id+'</label>\n' +
                        '        <tr class="tbody-tr">\n' +
                        '            <td class="index">'+(parseInt(index)+1)+'</td>\n' +
                        '            <td>'+users[index].userName+'</td>\n' +
                        '            <td>'+users[index].passWord+'</td>\n' +
                        '            <td>'+users[index].email+'</td>\n' +
                        '            <td>'+users[index].registerTime+'</td>\n' +
                        '            <td><button class="btn btn-default opt-btn opt-delete" onclick="deleteUser(this)">删除</button></td>\n' +
                        '         </tr>\n';
                    tbodyTrHtml += trHtml;
                }
            }else {
                tbodyTrHtml = '<h2>还没有用户注册~~~</h2>';
            }
            $('.content-body').html(tbodyTrHtml);
        },
        error: function (res) {
            console.log("error: " + res);
        }
    });
    // console.log("bbbbbbbbbbbbbbbbbbbbb");
});

// 删除用户
function deleteUser(event){
    console.log("进来了！！！！！！！ deleteUser");
    let deleteBtnList = $('.opt-delete');
    let index = deleteBtnList.index(event);
    if (confirm("确定删除此用户？")){
        console.log("deleteUser | index: " + index);
        let userLable = $('.userId').eq(index);
        let userId = userLable.text();
        console.log("deleteUser | userId: " + userId);
        $.ajax({
            // url: 'http://localhost:8080/deleteUser',
            url: 'http://121.196.145.152:8080/MyBlog/deleteUser',
            dataType: 'json',
            data: 'userId=' + userId,
            type: 'POST',
            cache: false,
            success: function (res) {
                console.log('deleteUser | status: ' + res.status);
                if (res.status == '1'){
                    $('.tbody-tr').eq(index).remove();
                    // 序号重新排序
                    for (let i = 0; i < $('.tbody-tr').length; i++) {
                        // console.log("new index: "+(parseInt(i)+1));
                        $('.index').eq(i).html((parseInt(i)+1)+"");
                    }
                }
            }
        });
    }
};