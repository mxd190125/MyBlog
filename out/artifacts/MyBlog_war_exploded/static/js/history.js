$(function(){
    // 进入页面时加载数据
    let  userId = $('#userId').text();
    console.log("userId: " + userId);
    $.ajax({
        // url: 'http://localhost:8080/requestHistory',
        url: 'http://121.196.145.152:8080/MyBlog/requestHistory',
        dataType: 'json',
        data: 'userId=' + userId,
        type: 'POST',
        cache: false,
        success: function (res) {
            let tbodyTrHtml = "";
            console.log("status: " + res.status);
            if (res.status == 1){
                console.log(res.blogs);
                let blogs = res.blogs;
                for (let index in blogs) {
                    let trHtml = '' +
                        '<label style="display: none;" class="blogId">'+blogs[index].id+'</label>\n' +
                        '<tr class="tbody-tr">\n' +
                        '            <td class="index">'+(parseInt(index)+1)+'</td>\n' +
                        '            <td>'+blogs[index].title+'</td>\n' +
                        '            <td>'+blogs[index].subTime+'</td>\n' +
                        '            <td><button class="btn btn-default opt-btn opt-delete" onclick="deleteBlog(this)">删除</button></td>\n' +
                        '            <td><button class="btn btn-primary opt-btn opt-check" onclick="checkBlog(this)">查看</button></td>\n' +
                        '</tr>';
                    tbodyTrHtml += trHtml;
                }
            }else {
                tbodyTrHtml = '<h2>您还没有记录，快去写博客吧~~~</h2>';
            }
            $('.content-body').html(tbodyTrHtml);
        }
    });

    // // 触发静态面板
    // $(".opt-check").click(function(){
    //     $("#mymodal").modal();
    // });
});


// 删除博客
function deleteBlog(event){
    console.log("进来了！！！！！！！ deleteBlog");
    let deleteBtnList = $('.opt-delete');
    let index = deleteBtnList.index(event);
    if (confirm("确定删除此博客？")){
        console.log("deleteBlog | index: " + index);
        let blogLable = $('.blogId').eq(index);
        let blogId = blogLable.text();
        console.log("deleteBlog | blogId: " + blogId);
        $.ajax({
            // url: 'http://localhost:8080/deleteHistory',
            url: 'http://121.196.145.152:8080/MyBlog/deleteHistory',
            dataType: 'json',
            data: 'blogId=' + blogId,
            type: 'POST',
            cache: false,
            success: function (res) {
                console.log('deleteBlog | status: ' + res.status);
                if (res.status == '1'){
                    $('.tbody-tr').eq(index).remove();
                    // 序号重新排序
                    // let len = ;
                    for (let i = 0; i < $('.tbody-tr').length; i++) {
                        // console.log("new index: "+(parseInt(i)+1));
                        $('.index').eq(i).html((parseInt(i)+1)+"");
                    }
                }
            }
        });
    }
};

// 触发静态面板(查看博客)
function checkBlog(event) {
    console.log("进来了！！！！！！！ checkBlog");
    let checkBtnList = $('.opt-check');
    let index = checkBtnList.index(event);
    console.log("checkBlog | index: " + index);
    let blogLable = $('.blogId').eq(index);
    let blogId = blogLable.text();
    console.log("checkBlog | blogId: " + blogId);

    $.ajax({
        // url: 'http://localhost:8080/checkHistory',
        url: 'http://121.196.145.152:8080/MyBlog/checkHistory',
        dataType: 'json',
        data: 'blogId=' + blogId,
        type: 'POST',
        cache: false,
        success: function (res) {
            console.log('checkBlog | status: ' + res.status);
            if (res.status == '1'){
                let blog = res.blog;
                console.log(blog);
                $('.modal-title').text(blog.title);
                $('.author-name').text(blog.blogerName);
                $('.sub-time').text(blog.subTime);
                $('.good-num').text(blog.goodNum);
                $('.content').text(blog.content);
                let images = blog.images;
                let items = images.split('#');
                let imagesHtml = '';
                for (let item of items){
                    // imagesHtml += '<img class="upImage" src="http://localhost:8080/' + item + '">';
                    imagesHtml += '<img class="upImage" src="http://121.196.145.152:8080/' + item + '">';
                }
                $('.images').html(imagesHtml);

                let discusses = blog.discusses;
                let discussesHtml='';
                for (let discuss of discusses){
                    discussesHtml += '<p><label class="dis-name">'+discuss.subTime+' '+discuss.discusserName+'：</label>' + discuss.content + '</p>';
                }
                $('.pl-div2').html(discussesHtml);
                // 触发静态模板
                $("#mymodal").modal();
            }
        }
    });
}